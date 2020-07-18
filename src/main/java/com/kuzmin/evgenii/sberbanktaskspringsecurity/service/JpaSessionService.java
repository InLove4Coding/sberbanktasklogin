package com.kuzmin.evgenii.sberbanktaskspringsecurity.service;

import com.kuzmin.evgenii.sberbanktaskspringsecurity.entity.Session;
import com.kuzmin.evgenii.sberbanktaskspringsecurity.entity.UserEntity;
import com.kuzmin.evgenii.sberbanktaskspringsecurity.repository.SessionRepo;
import com.kuzmin.evgenii.sberbanktaskspringsecurity.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;

import javax.security.auth.login.CredentialException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class JpaSessionService implements SessionService {

    private final UserRepo userRepo;
    private final SessionRepo sessionRepo;


    @Value("${session.lifetime}")
    private int sessionLifeTime;

    @Override
    public Session login(String login, String password) throws CredentialException {
        UserEntity userByLogin = userRepo.findUserByLogin(login).orElseThrow(CredentialException::new);
        String hash = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!hash.equals(userByLogin.getPasswordHash())) {
            throw new CredentialException();
        }
        return sessionRepo.save(buildSession());
    }

    @Override
    public List<Session> getActiveSession(String login) {
        return sessionRepo.findAllByUserLogin(login);
    }

    @Override
    public boolean logoutSession(UUID sessionId) {
        try {
            sessionRepo.deleteById(sessionId);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private Session buildSession() {
        Session session = new Session();
        session.setSessionId(UUID.randomUUID());
        long timestamp = System.currentTimeMillis();
        session.setTimestamp(timestamp);
        session.setExpire(timestamp + TimeUnit.MINUTES.toMillis(sessionLifeTime));
        return session;
    }
}

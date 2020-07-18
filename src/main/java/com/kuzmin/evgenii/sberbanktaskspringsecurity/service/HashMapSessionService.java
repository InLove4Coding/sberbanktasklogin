package com.kuzmin.evgenii.sberbanktaskspringsecurity.service;

import com.kuzmin.evgenii.sberbanktaskspringsecurity.entity.Session;
import com.kuzmin.evgenii.sberbanktaskspringsecurity.entity.UserEntity;
import com.kuzmin.evgenii.sberbanktaskspringsecurity.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.security.auth.login.CredentialException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
public class HashMapSessionService implements SessionService {

    private final ConcurrentMap<String, List<Session>> activeSessionsByLogin = new ConcurrentHashMap<>();

    private final UserRepo userRepo;

    @Value("${session.lifetime}")
    private int sessionLifeTime;

    public Session login(String login, String password) throws CredentialException {
        UserEntity userByLogin = userRepo.findUserByLogin(login).orElseThrow(CredentialException::new);
        String hash = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!hash.equals(userByLogin.getPasswordHash())) {
            throw new CredentialException();
        }
        Session session = buildSession();
        saveSession(login, session);

        return session;
    }


    @Override
    public List<Session> getActiveSession(String login) {
        return activeSessionsByLogin.getOrDefault(login, emptyList());
    }

    @Override
    public void logoutSession() {

    }

    private Session buildSession() {
        Session session = new Session();
        session.setSessionId(UUID.randomUUID());
        long timestamp = System.currentTimeMillis();
        session.setTimestamp(timestamp);
        session.setExpire(timestamp + TimeUnit.MINUTES.toMillis(sessionLifeTime));
        return session;
    }

    private void saveSession(String login, Session session) {
        List<Session> activeSessionsList = activeSessionsByLogin.getOrDefault(login, emptyList());
        activeSessionsList.add(session);
        activeSessionsByLogin.put(login, activeSessionsList);
    }
}

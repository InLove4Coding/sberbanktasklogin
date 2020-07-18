package com.kuzmin.evgenii.sberbanktaskspringsecurity.service;

import com.kuzmin.evgenii.sberbanktaskspringsecurity.entity.Session;

import javax.security.auth.login.CredentialException;
import java.util.List;
import java.util.UUID;

public interface SessionService {
    Session login(String login, String password) throws CredentialException;
    List<Session> getActiveSession(String login);
    boolean logoutSession(UUID sessionId);
}

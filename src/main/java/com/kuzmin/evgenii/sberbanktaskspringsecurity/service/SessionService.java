package com.kuzmin.evgenii.sberbanktaskspringsecurity.service;

import com.kuzmin.evgenii.sberbanktaskspringsecurity.entity.Session;

import javax.security.auth.login.CredentialException;
import java.util.List;

public interface SessionService {
    Session login(String login, String password) throws CredentialException;

    List<Session> getActiveSession(String login);
}

package com.kuzmin.evgenii.sberbanktaskspringsecurity.service;

import com.kuzmin.evgenii.sberbanktaskspringsecurity.entity.IUserSession;
import com.kuzmin.evgenii.sberbanktaskspringsecurity.entity.IUserWithCredentials;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {
    List<? extends IUserSession> getUserSessions(String login);

    boolean registerUser(IUserWithCredentials userWithCredentials);

    boolean updatePassword(Long userId, String password);

    boolean deleteUser(Long userId);
}

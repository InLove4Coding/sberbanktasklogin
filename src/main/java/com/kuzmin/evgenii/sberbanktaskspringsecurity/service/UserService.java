package com.kuzmin.evgenii.sberbanktaskspringsecurity.service;

public interface UserService {
    boolean registerUser();

    boolean updatePassword(Long userId, String password);

    boolean deleteUser(Long userId);
}

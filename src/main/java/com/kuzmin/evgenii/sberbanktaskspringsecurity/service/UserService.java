package com.kuzmin.evgenii.sberbanktaskspringsecurity.service;

import com.kuzmin.evgenii.sberbanktaskspringsecurity.dto.UserDto;

public interface UserService {
    boolean registerUser(UserDto userDto);

    boolean updatePassword(Long userId, String password);

    boolean deleteUser(Long userId);
}

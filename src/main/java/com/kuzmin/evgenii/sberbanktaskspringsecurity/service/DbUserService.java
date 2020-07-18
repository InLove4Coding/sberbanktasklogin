package com.kuzmin.evgenii.sberbanktaskspringsecurity.service;

import com.kuzmin.evgenii.sberbanktaskspringsecurity.dto.UserDto;
import com.kuzmin.evgenii.sberbanktaskspringsecurity.entity.UserEntity;
import com.kuzmin.evgenii.sberbanktaskspringsecurity.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbUserService implements UserService {

    private final UserRepo userRepo;

    @Override
    public boolean registerUser(UserDto userDto) {
        String hash = DigestUtils.md5DigestAsHex(userDto.getPasswordHash().getBytes());
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(userDto.getLogin());
        userEntity.setPasswordHash(hash);
        return false;
    }

    @Override
    public boolean updatePassword(Long userId, String password) {
        String hash = DigestUtils.md5DigestAsHex(password.getBytes());
        Optional<UserEntity> byId = userRepo.findById(userId);
        if (byId.isPresent()) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(byId.get().getId());
            userEntity.setLogin(byId.get().getLogin());
            userEntity.setPasswordHash(hash);
            userRepo.save(userEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(Long userId) {
        userRepo.deleteById(userId);
        return true;
    }
}

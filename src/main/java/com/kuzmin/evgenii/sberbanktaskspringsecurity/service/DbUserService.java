package com.kuzmin.evgenii.sberbanktaskspringsecurity.service;

import com.kuzmin.evgenii.sberbanktaskspringsecurity.entity.UserEntity;
import com.kuzmin.evgenii.sberbanktaskspringsecurity.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbUserService implements UserService {

    private final UserRepo userRepo;

    @Override
    public boolean registerUser() {
        return false;
    }

    @Override
    public boolean updatePassword(Long userId, String password) {
        Optional<UserEntity> byId = userRepo.findById(userId);
        if (byId.isPresent()) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(byId.get().getId());
            userEntity.setLogin(byId.get().getLogin());
            userEntity.setPasswordHash(password);
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

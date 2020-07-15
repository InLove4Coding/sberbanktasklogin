package com.kuzmin.evgenii.sberbanktaskspringsecurity.repository;

import com.kuzmin.evgenii.sberbanktaskspringsecurity.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByLogin(String login);
}

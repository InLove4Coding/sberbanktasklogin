package com.kuzmin.evgenii.sberbanktaskspringsecurity.repository;

import com.kuzmin.evgenii.sberbanktaskspringsecurity.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findUserEntityByPassword(String password);
}

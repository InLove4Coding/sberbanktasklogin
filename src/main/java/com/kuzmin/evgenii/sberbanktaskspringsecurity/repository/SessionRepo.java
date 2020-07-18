package com.kuzmin.evgenii.sberbanktaskspringsecurity.repository;

import com.kuzmin.evgenii.sberbanktaskspringsecurity.entity.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.*;


public interface SessionRepo extends CrudRepository<Session, UUID> {
    List<Session> findAllByUserLogin(String userLogin);
}

package com.kuzmin.evgenii.sberbanktaskspringsecurity.repository;

import com.kuzmin.evgenii.sberbanktaskspringsecurity.entity.Session;

public interface SessionRepo {
    Session getSession(String login);
}

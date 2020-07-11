package com.kuzmin.evgenii.sberbanktaskspringsecurity.entity;

import java.util.UUID;

public interface IUserSession {
    UUID getSessionId();
    Long getTimestamp();
    Long getExpire();
}

package com.kuzmin.evgenii.sberbanktaskspringsecurity.entity;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSessionDTO implements IUserSession {

    private UUID sessionId;
    private Long timestamp;
    private Long expire;

}

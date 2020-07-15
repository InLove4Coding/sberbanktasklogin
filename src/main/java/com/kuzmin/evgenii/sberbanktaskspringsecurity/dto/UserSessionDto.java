package com.kuzmin.evgenii.sberbanktaskspringsecurity.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSessionDto {

    private UUID sessionId;
    private Long timestamp;
    private Long expire;

}

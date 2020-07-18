package com.kuzmin.evgenii.sberbanktaskspringsecurity.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String Login;
    private String passwordHash;
}

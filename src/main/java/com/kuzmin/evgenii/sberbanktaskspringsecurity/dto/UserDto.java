package com.kuzmin.evgenii.sberbanktaskspringsecurity.dto;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String passwordHash;
}

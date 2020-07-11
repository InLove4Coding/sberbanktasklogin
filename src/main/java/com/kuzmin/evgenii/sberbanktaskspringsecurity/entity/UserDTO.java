package com.kuzmin.evgenii.sberbanktaskspringsecurity.entity;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements IUser {
    private Long id;
}

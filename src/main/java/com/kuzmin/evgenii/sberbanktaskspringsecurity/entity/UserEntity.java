package com.kuzmin.evgenii.sberbanktaskspringsecurity.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(of = "id")
@Table(name = "user")
public class UserEntity implements IUserWithCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_login", nullable = true, unique = true)
    private String login;
    @Column(name = "user_password", nullable = true, unique = false)
    private String password;
}

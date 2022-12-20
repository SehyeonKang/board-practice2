package com.study.communitypractice2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty
    private String userid;

    @Column
    @NotEmpty
    private String password;

    @Column
    @NotEmpty
    private String username;

    @Column
    @NotEmpty
    private String nickname;

    @Column
    @NotEmpty
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;
}

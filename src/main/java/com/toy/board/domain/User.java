package com.toy.board.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

public class User extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Comment(value = "고객 id")
    private String id;

    @Column(name = "username", nullable = false, unique = true)
    @Comment(value = "로그인 아이디")
    private String username;

    @Column(name = "password", nullable = false)
    @Comment(value = "비밀번호")
    private String password;

    @Column(name = "nickname", nullable = false, unique = true)
    @Comment(value = "고객 별칭")
    private String nickname;

    @Column(name = "email", nullable = false, unique = true)
    @Comment(value = "고객 이메일")
    private String email;
}
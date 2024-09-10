package com.toy.board.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="board")
@Entity
public class Post extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Comment(value = "게시글 id")
    private long id;

    @Column(name = "title", nullable = false)
    @Comment(value = "게시글 제목")
    private String title;

    @Column(name = "content", nullable = false)
    @Comment(value = "게시글 내용")
    private String content;

    @Column(name = "writer", nullable = false)
    @Comment(value = "작성자명")
    private String writer;

    @Column(name = "password", nullable = false)
    @Comment(value = "비밀번호")
    private String password;

}

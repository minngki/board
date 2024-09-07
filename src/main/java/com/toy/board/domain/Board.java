package com.toy.board.domain;

import com.toy.board.dto.BoardDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="board")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Board {
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

    @CreatedDate
    @Column(name = "created", nullable = false)
    @Comment(value = "생성일자")
    private LocalDateTime created;

    @LastModifiedDate
    @Column(name = "updated", nullable = false)
    @Comment(value = "수정일")
    private LocalDateTime updated;




    public Board toEntity(BoardDto.Response boardDto) {
        return Board.builder()
                .id(boardDto.getId())
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .writer(boardDto.getWriter())
                .created(boardDto.getCreated())
                .updated(boardDto.getUpdated())
                .build();

    }
}

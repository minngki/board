package com.toy.board.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTime {
    @CreatedDate
    @Column(name = "created", nullable = false)
    @Comment(value = "생성일자")
    private LocalDateTime created;

    @LastModifiedDate
    @Column(name = "updated", nullable = false)
    @Comment(value = "수정일")
    private LocalDateTime updated;
}

package com.toy.board.dto;

import com.toy.board.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


public class PostDto {
    @AllArgsConstructor
    @Data
    @Builder
    public static class Request {
        private String title;
        private String content;
        private String writer;
        private String password;


        public Post toEntity() {
            return Post.builder()
                    .title(title)
                    .content(content)
                    .writer(writer)
                    .password(password)
                    .build();
        }
    }

    @AllArgsConstructor
    @Data
    @Builder
    public static class Response {
        private long id;
        private String title;
        private String content;
        private String writer;
        private LocalDateTime created;
        private LocalDateTime updated;

        public static Response toDto(Post post) {
            return Response.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .writer(post.getWriter())
                    .created(post.getCreated())
                    .updated(post.getUpdated())
                    .build();
            }
    }
}


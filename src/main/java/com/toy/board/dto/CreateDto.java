package com.toy.board.dto;

import com.toy.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


public class CreateDto {
    @AllArgsConstructor
    @Data
    @Builder
    public static class Request {
        private String title;
        private String content;
        private String writer;
        private String password;

        public Board toDto()  {
            return Board.builder()
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

        public Board toDto(Board board) {
            return Board.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .created(board.getCreated())
                    .updated(board.getUpdated())
                    .build();
        }
    }
}

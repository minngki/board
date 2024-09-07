package com.toy.board.dto;

import com.toy.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


public class ReadTargetDto {
    @AllArgsConstructor
    @Data
    @Builder
    public static class Request {
        private long id;

        public Board toDto() {
            return Board.builder()
                    .id(id)
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

        public Board toDto() {
            return Board.builder()
                    .id(id)
                    .title(title)
                    .content(content)
                    .writer(writer)
                    .created(created)
                    .updated(updated)
                    .build();
        }
    }

}


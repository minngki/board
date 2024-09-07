package com.toy.board.dto;

import com.toy.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


public class DeleteDto {
    @AllArgsConstructor
    @Data
    @Builder
    public static class Request {
        private long id;
        private String password;

        public Board toDto() {
            return Board.builder()
                    .id(id)
                    .password(password)
                    .build();
        }
    }
}
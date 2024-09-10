package com.toy.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ApiResponseDto<T> {
    private boolean result;
    private T data;
    private String msg;
}

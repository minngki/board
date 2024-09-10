package com.toy.board.advice;

import com.toy.board.dto.ApiResponseDto;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 모든 컨트롤러의 응답을 처리하기 위해 항상 true 반환
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // body가 이미 ApiResponse 형식이면 그대로 반환 -> 오류 반환 시 왜 두번 타게 되는지 생각.
        if (body instanceof ApiResponseDto) {
            return body;
        }

        // 예외가 아닌 정상적인 응답인 경우
        return ApiResponseDto.builder()
                .result(true)
                .data(body)
                .msg(null)
                .build();
    }
}
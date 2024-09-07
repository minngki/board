package com.toy.board.controller;
import com.toy.board.domain.Board;
import com.toy.board.dto.CreateDto;
import com.toy.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@Slf4j
@RequestMapping("/board")
@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/posts")
    public List<Board> read() {
        return boardService.getPosts();
    }

    @PostMapping("/post")
    public Board create(@RequestBody CreateDto.Request dto) {
        return boardService.createPost(dto);
    }
}

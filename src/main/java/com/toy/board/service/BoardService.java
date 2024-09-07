package com.toy.board.service;

import com.toy.board.domain.Board;
import com.toy.board.dto.CreateDto;
import com.toy.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<Board> getPosts() {
        return boardRepository.findAllByOrderByUpdatedDesc();
    }

    @Transactional
    public Board createPost(CreateDto.Request dto) {
        Board board = dto.toDto();
        boardRepository.save(board);
        return board;
    }

}

package com.toy.board.service;

import com.toy.board.domain.Post;
import com.toy.board.dto.PostDto;
import com.toy.board.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public Page<Post> pageList(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Transactional
    public PostDto.Response createPost(PostDto.Request dto) {
        Post post = dto.toEntity();
        postRepository.save(post);
        return PostDto.Response.toDto(post);
    }

    @Transactional
    public Post readTarget(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + id));
    }

    @Transactional
    public PostDto.Response updatePost(Long id, PostDto.Request dto) throws Exception {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new Exception("해당 게시글이 존재하지 않습니다. id: " + id));
        if (!dto.getPassword().equals(post.getPassword())) {
            throw new Exception("비밀번호가 일치하지 않습니다.");
        }
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());

        return PostDto.Response.toDto(post);
    }

    @Transactional
    public void deletePost(Long id, String password) throws Exception {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new Exception("해당 게시글이 존재하지 않습니다. id: " + id));
        if (!password.equals(post.getPassword())) {
            throw new Exception("비밀번호 노일치.");
        }
        postRepository.deleteById(id);
    }





}

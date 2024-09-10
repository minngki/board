package com.toy.board.repository;

import com.toy.board.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByUpdatedDesc();

//    @Modifying
//    @Query("update Board b " +
//            "set b.title = :title, " +
//            "b.content = :content " +
//            "where b.id = :id")
//    void updatePostById(@Param("id") Long id, @Param("title") String title, @Param("content") String content );

}

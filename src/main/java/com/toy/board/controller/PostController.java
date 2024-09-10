package com.toy.board.controller;
import com.toy.board.domain.Post;
import com.toy.board.dto.PostDto;
import com.toy.board.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

@Slf4j
@RequestMapping("/board")
@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @GetMapping("/")     /* default page = 0, size = 10  */
    public Page<Post> index(Model model, @PageableDefault(sort = "updated", direction = Sort.Direction.ASC)
    Pageable pageable) {
        Page<Post> list = postService.pageList(pageable);

        model.addAttribute("posts", list);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());

        return list;
    }

    @PostMapping("/post")
    public ResponseEntity<PostDto.Response> create(@RequestBody PostDto.Request dto) {
        return ResponseEntity.ok(postService.createPost(dto));
    }

    @GetMapping("/post")
    public ResponseEntity<Post> readTarget(@RequestParam Long id) {
        return ResponseEntity.ok(postService.readTarget(id));
    }

    @PatchMapping("/post")
    public ResponseEntity<PostDto.Response> update(@RequestParam Long id, @RequestBody PostDto.Request dto) throws Exception {
        PostDto.Response response = postService.updatePost(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/post")
    public ResponseEntity<Void> delete(@RequestParam Long id,String password) throws Exception {
        postService.deletePost(id, password);
        return ResponseEntity.ok().build();
    }
}

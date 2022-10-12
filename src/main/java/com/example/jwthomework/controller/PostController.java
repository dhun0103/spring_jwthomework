package com.example.jwthomework.controller;

import com.example.jwthomework.dto.PostRequestDto;
import com.example.jwthomework.entity.Post;
import com.example.jwthomework.repository.PostRepository;
import com.example.jwthomework.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    //전체 조회
    @GetMapping("/api/posts")
    public List<Post> getPosts(){

        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    //개별 조회
    @GetMapping("/api/posts/{id}")
    public Post getEachPosts(@PathVariable Long id){
        Optional<Post> post = postRepository.findById(id);

        return post.orElseGet(null);
    }

    //작성
    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto){

        Post post = new Post(requestDto);

        return postRepository.save(post);
    }

    //수정
    @PutMapping("/api/posts/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){

        Post post = postService.update(id,requestDto);

        return post;
    }

    //삭제
    @DeleteMapping("/api/posts/{id}")
    public String deletePost(@PathVariable Long id){
        postRepository.deleteById(id);

        return "굿";
    }
}


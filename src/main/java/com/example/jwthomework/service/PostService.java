package com.example.jwthomework.service;

import com.example.jwthomework.dto.PostRequestDto;
import com.example.jwthomework.entity.Post;
import com.example.jwthomework.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post update(Long id, PostRequestDto requestDto){

        Post post=postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id 존재 안함")
        );

        post.update(requestDto);

        return post;
    }
}


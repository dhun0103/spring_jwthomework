package com.example.jwthomework.controller;

import com.example.jwthomework.config.UserDetailsImpl;
import com.example.jwthomework.dto.CommentRequestDto;
import com.example.jwthomework.dto.CommentResponseDto;
import com.example.jwthomework.dto.MemberResponseDto;
import com.example.jwthomework.entity.Comment;
import com.example.jwthomework.entity.Post;
import com.example.jwthomework.repository.CommentRepository;
import com.example.jwthomework.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    private final CommentRepository commentRepository;




    @PostMapping("/api/posts/comments")
    public ResponseEntity<Comment> createComment(
            @RequestBody CommentRequestDto requestDto )
    {

        return ResponseEntity.ok(commentService.createComment(requestDto));
    }
}

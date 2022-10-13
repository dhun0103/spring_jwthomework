package com.example.jwthomework.service;

import com.example.jwthomework.config.UserDetailsImpl;
import com.example.jwthomework.dto.CommentRequestDto;
import com.example.jwthomework.dto.CommentResponseDto;
import com.example.jwthomework.entity.Comment;
import com.example.jwthomework.entity.Member;
import com.example.jwthomework.entity.Post;
import com.example.jwthomework.repository.CommentRepository;
import com.example.jwthomework.repository.MemberRepository;
import com.example.jwthomework.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Transactional
    public Comment createComment( CommentRequestDto requestDto) {
        Post post = postRepository.findById(requestDto.getPostid()).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다.")
        );

        Comment comment = new Comment(requestDto.getComment(),post);


        commentRepository.save(comment);
        return comment;
    }


}

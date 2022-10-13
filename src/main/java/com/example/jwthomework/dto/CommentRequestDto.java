package com.example.jwthomework.dto;

import com.example.jwthomework.entity.Comment;
import com.example.jwthomework.entity.Member;
import com.example.jwthomework.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {
    private Long postid;
    private String comment;
}


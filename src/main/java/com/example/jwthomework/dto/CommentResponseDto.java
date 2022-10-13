package com.example.jwthomework.dto;

import com.example.jwthomework.entity.Comment;
import com.example.jwthomework.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentResponseDto {

    private Long id;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}

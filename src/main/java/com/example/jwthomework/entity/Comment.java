package com.example.jwthomework.entity;

import com.example.jwthomework.dto.CommentRequestDto;
import com.example.jwthomework.dto.MemberResponseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment; // 댓글 내용

    @Column(name = "created_date")
    @CreatedDate
    private String createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private String modifiedDate;

    @ManyToOne
    @JoinColumn(name = "post_id") //외래 키 매핑
    @JsonIgnore
    private Post post;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member; //작성자

    public Comment(String comment, Post post) {
        this.comment = comment;
        this.post = post;
    }


}
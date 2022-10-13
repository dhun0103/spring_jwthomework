package com.example.jwthomework.entity;

import com.example.jwthomework.dto.PostRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Post extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "post_id")
    Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;

    //FetchType.LAZY는 지연로딩을 의미
    @ManyToOne(fetch = FetchType.LAZY) //Member를 조회할 때 지연로딩을 사용하겠다
    @JoinColumn(name = "member_id")
    private Member member;

    //FetchType.EAGER는 기본이고 즉시로딩을 의미, CascadeType.REMOVE는 글 삭제시 댓글도 삭제
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("id asc") // 댓글 정렬
    private List<Comment> comments;

    public Post(String title, String username, String password, String contents) {
        this.title = title;
        this.username = username;
        this.password = password;
        this.contents = contents;
    }

    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }

    public void update(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }
}


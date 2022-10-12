package com.example.jwthomework.entity;

import com.example.jwthomework.dto.PostRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post extends Timestamped{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String contents;

    public Post(String title, String username, String password, String contents) {
        this.title = title;
        this.username = username;
        this.password = password;
        this.contents = contents;
    }

    public Post(PostRequestDto requestDto){
        this.title=requestDto.getTitle();
        this.username=requestDto.getUsername();
        this.password=requestDto.getPassword();
        this.contents=requestDto.getContents();
    }

    public void update(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }
}


package com.example.jwthomework.repository;

import com.example.jwthomework.entity.Post;
import com.example.jwthomework.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByModifiedAtDesc();
}
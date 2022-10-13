package com.example.jwthomework.repository;

import com.example.jwthomework.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByNickname(String nickname);

    boolean existsByNickname(String nickname);
}

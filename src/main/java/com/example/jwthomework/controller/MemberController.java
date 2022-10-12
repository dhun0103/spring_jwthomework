package com.example.jwthomework.controller;

import com.example.jwthomework.dto.MemberResponseDto;
import com.example.jwthomework.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/api/member/me")
    public ResponseEntity<MemberResponseDto> getMyMemberInfo() {

        return ResponseEntity.ok(memberService.getMyInfo());
    }

    @GetMapping("/api/member/{email}")
    public ResponseEntity<MemberResponseDto> getMemberInfo(@PathVariable String email) {
        return ResponseEntity.ok(memberService.getMemberInfo(email));
    }
}

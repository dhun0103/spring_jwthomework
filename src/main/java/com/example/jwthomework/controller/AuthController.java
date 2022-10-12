package com.example.jwthomework.controller;

import com.example.jwthomework.dto.MemberRequestDto;
import com.example.jwthomework.dto.MemberResponseDto;
import com.example.jwthomework.dto.TokenDto;
import com.example.jwthomework.dto.TokenRequestDto;
import com.example.jwthomework.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/api/auth/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {

        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto) {

        return ResponseEntity.ok(authService.login(memberRequestDto));
    }

    @PostMapping("/api/auth/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {

        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}

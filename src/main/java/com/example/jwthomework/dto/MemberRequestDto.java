package com.example.jwthomework.dto;


import com.example.jwthomework.entity.Authority;
import com.example.jwthomework.entity.Member;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {

    @NotNull
    @Pattern(regexp="[a-zA-Z0-9]{4,12}")
    private String nickname;

    @NotNull
    @Pattern(regexp="[a-z0-9]{4,32}")
    private String password;

    private String passwordConfirm;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .nickname(nickname)
                .password(passwordEncoder.encode(password))
                .authority(Authority.ROLE_USER)
                .build();
    }
}

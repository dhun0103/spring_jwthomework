package com.example.jwthomework.dto;

import com.example.jwthomework.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberResponseDto {
    private String nickname;

    public static MemberResponseDto of(Member member) {

        return new MemberResponseDto(member.getNickname());
    }
}

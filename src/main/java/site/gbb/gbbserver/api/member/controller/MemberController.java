package site.gbb.gbbserver.api.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.gbb.gbbserver.api.member.domain.Member;
import site.gbb.gbbserver.api.member.dto.MemberRequestDto;
import site.gbb.gbbserver.api.member.dto.MemberResponseDto;
import site.gbb.gbbserver.api.member.service.MemberService;


@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;


    @PostMapping("/api/v1/login")
    public Member save(@RequestBody MemberRequestDto memberRequestDto){
        return memberService.join(memberRequestDto);
    }
    @GetMapping("/api/v1/login/{id}") //중간 결과 조회
    public MemberResponseDto findById(@PathVariable Long id){
        MemberResponseDto dto = memberService.findById(id);
        return dto;
    }


}

package site.gbb.gbbserver.api.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.gbb.gbbserver.api.member.domain.Member;
import site.gbb.gbbserver.api.member.dto.MemberRequestDto;
import site.gbb.gbbserver.api.member.service.MemberService;


@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;


    @PostMapping("/api/v1/login")
    public Member save(@RequestBody MemberRequestDto memberRequestDto){
        return memberService.join(memberRequestDto);
    }
    @GetMapping("/api/v1/member/{id}") //멤버 조회-아이디기반
    public Member findById(@PathVariable("id") Long id){
        return memberService.findById(id);
    }
}

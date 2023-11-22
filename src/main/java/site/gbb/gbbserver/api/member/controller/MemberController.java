package site.gbb.gbbserver.api.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.gbb.gbbserver.api.member.dto.MemberRequestDto;
import site.gbb.gbbserver.api.member.dto.MemberResponseDto;
import site.gbb.gbbserver.api.member.service.MemberService;


@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/login")
    public String save(@RequestBody MemberRequestDto memberRequestDto){
        return memberService.join(memberRequestDto);
    }
    @GetMapping("/login/{id}")
    public MemberResponseDto findById(@PathVariable Long id){
        return memberService.show(id);
    }


}

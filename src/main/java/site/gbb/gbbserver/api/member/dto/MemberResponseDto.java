package site.gbb.gbbserver.api.member.dto;

import lombok.Getter;
import site.gbb.gbbserver.api.member.domain.Member;


@Getter
public class MemberResponseDto {
    private Long id;
    private String nickname;

    public MemberResponseDto(Member member){
        this.id = member.getId();
        this.nickname = member.getNickname();
    }


}

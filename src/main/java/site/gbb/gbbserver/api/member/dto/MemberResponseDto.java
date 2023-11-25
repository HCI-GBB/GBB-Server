package site.gbb.gbbserver.api.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.gbb.gbbserver.api.hobby.domain.Hobby;
import site.gbb.gbbserver.api.member.domain.Member;
import site.gbb.gbbserver.api.result.domain.Result;

import java.util.List;


@Getter
@NoArgsConstructor
public class MemberResponseDto {
    private Long id;
    private String nickname;
    private List<String> like;
    private List<String> hate;
    private List<String> active;

    @Builder
    public MemberResponseDto (Long id,String nickname,List<String> like,List<String> hate,List<String> active){
        this.id = id;
        this.nickname = nickname;
        this.like = like;
        this.hate = hate;
        this.active = active;
    }

}

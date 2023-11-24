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
    private List<String> likes;//from Hobby
    private List<String> hates;//from Hobby
    //private List<String> active;//from result


    @Builder
    public MemberResponseDto (Member member, Hobby hobby, Result result){
        this.id = member.getId();
        this.nickname = member.getNickname();
        this.likes = hobby.getLikes();
        this.hates = hobby.getHates();
        //this.active = result.getActive();
    }
}

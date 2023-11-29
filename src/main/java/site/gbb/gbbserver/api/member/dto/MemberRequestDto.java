package site.gbb.gbbserver.api.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.gbb.gbbserver.api.member.domain.Member;


@Getter
@NoArgsConstructor
public class MemberRequestDto {
    private String nickname;

    @Builder
    public MemberRequestDto(String nickname) {
        this.nickname = nickname;
    }

    public Member toEntity(){
        return Member.builder()
                .nickname(nickname)
                .build();
    }
}

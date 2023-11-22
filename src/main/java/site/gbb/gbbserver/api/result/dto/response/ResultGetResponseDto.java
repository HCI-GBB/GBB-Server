package site.gbb.gbbserver.api.result.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import site.gbb.gbbserver.api.result.domain.Result;

import java.util.List;

@Getter
@AllArgsConstructor(staticName = "of")
public class ResultGetResponseDto {
    private String nickname;

    private List<String> active;

    private List<String> percent;

    public static ResultGetResponseDto of(Result result) {
        return new ResultGetResponseDto(result.getHobby().getMember().getNickname(), result.getActive(), result.getPercent());
    }
}

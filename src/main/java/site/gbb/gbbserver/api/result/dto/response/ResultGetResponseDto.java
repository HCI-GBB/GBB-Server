package site.gbb.gbbserver.api.result.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(staticName = "of")
public class ResultGetResponseDto {
    private String nickname;

    private String top;

    private List<String> interest;

    private List<String> interest_percent;

    private List<String> focus;

    private List<String> focus_percent;
}

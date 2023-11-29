package site.gbb.gbbserver.api.result.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CsvResultGetResponseDto {
    private int status;
    private String message;
    private dataObject data;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class dataObject {
        private String top;
        private List<String> interest;
        private List<String> interest_percent;
        private List<String> focus;
        private List<String> focus_percent;
    }
}

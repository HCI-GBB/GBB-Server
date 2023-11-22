package site.gbb.gbbserver.api.hobby.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
public class HobbyCreateResponseDto {
    @JsonProperty("id")
    private Long id;

    @Builder
    public HobbyCreateResponseDto(Long id) {
        this.id = id;
    }
}

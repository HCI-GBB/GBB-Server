package site.gbb.gbbserver.api.hobby.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
public class HobbyCreateRequestDto {

    private List<String> likes;

    private List<String> hates;
}

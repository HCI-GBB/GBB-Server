package site.gbb.gbbserver.api.hobby.service;

import site.gbb.gbbserver.api.hobby.dto.request.HobbyCreateRequestDto;
import site.gbb.gbbserver.api.hobby.dto.response.HobbyCreateResponseDto;

public interface HobbyService {
    HobbyCreateResponseDto createHobby(Long memberId, HobbyCreateRequestDto requestDto);
}

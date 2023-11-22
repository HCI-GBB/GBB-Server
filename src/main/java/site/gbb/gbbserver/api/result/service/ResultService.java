package site.gbb.gbbserver.api.result.service;

import site.gbb.gbbserver.api.result.dto.response.ResultGetResponseDto;

public interface ResultService {
    ResultGetResponseDto getResult(Long memberId);
}

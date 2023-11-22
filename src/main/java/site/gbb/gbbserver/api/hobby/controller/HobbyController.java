package site.gbb.gbbserver.api.hobby.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import site.gbb.gbbserver.api.hobby.dto.request.HobbyCreateRequestDto;
import site.gbb.gbbserver.api.hobby.dto.response.HobbyCreateResponseDto;
import site.gbb.gbbserver.api.hobby.service.HobbyService;
import site.gbb.gbbserver.common.response.ApiResponse;
import site.gbb.gbbserver.common.response.SuccessCode;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hobby")
public class HobbyController {
    private final HobbyService hobbyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<HobbyCreateResponseDto> createCard(@RequestHeader(value="memberId") Long memberId, @RequestBody HobbyCreateRequestDto hobbyCreateRequestDto) {
        HobbyCreateResponseDto response = hobbyService.createHobby(memberId, hobbyCreateRequestDto);

        return ApiResponse.success(SuccessCode.CREATE_HOBBY_SUCCESS, response);
    }
}

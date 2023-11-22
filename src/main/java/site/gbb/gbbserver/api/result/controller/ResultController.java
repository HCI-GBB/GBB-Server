package site.gbb.gbbserver.api.result.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import site.gbb.gbbserver.api.result.dto.response.ResultGetResponseDto;
import site.gbb.gbbserver.api.result.service.ResultService;
import site.gbb.gbbserver.common.response.ApiResponse;
import site.gbb.gbbserver.common.response.SuccessCode;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/result")
public class ResultController {
    private final ResultService resultService;

    @GetMapping("/{hobbyId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<ResultGetResponseDto> getResult(@RequestHeader(value="memberId") Long memberId, @PathVariable Long hobbyId) {
        ResultGetResponseDto response = resultService.getResult(memberId, hobbyId);
        return ApiResponse.success(SuccessCode.GET_RESULT_SUCCESS, response);
    }
}

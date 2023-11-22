package site.gbb.gbbserver.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Getter
@AllArgsConstructor
public enum SuccessCode {

    // hobby
    CREATE_HOBBY_SUCCESS(CREATED, "취미 선택 성공"),

    // result
    GET_RESULT_SUCCESS(OK, "취미 추천 받기 성공");

    private final HttpStatus status;
    private final String message;
}

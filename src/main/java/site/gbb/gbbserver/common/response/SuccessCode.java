package site.gbb.gbbserver.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.CREATED;

@Getter
@AllArgsConstructor
public enum SuccessCode {

    /* 201 CREATED */
    CREATE_HOBBY_SUCCESS(CREATED, "취미 선택 성공");

    private final HttpStatus status;
    private final String message;
}

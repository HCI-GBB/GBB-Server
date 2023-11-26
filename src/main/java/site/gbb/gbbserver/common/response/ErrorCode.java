package site.gbb.gbbserver.common.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum ErrorCode {
    /* 400 BAD REQUEST */

    /* 404 NOT FOUND */
    NOT_FOUND_MEMBER(NOT_FOUND, "존재하지 않는 유저입니다."),
    NOT_FOUND_HOBBY(NOT_FOUND, "존재하지 않는 취미입니다.");

    private final HttpStatus status;
    private final String message;
}

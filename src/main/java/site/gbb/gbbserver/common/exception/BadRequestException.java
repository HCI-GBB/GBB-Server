package site.gbb.gbbserver.common.exception;

import org.springframework.http.HttpStatus;
import site.gbb.gbbserver.common.response.ErrorCode;

public class BadRequestException extends BaseException {

    public BadRequestException(ErrorCode errorCode) {
        super(HttpStatus.BAD_REQUEST, errorCode.getMessage());
    }
}

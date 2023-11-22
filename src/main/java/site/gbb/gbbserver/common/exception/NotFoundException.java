package site.gbb.gbbserver.common.exception;

import org.springframework.http.HttpStatus;
import site.gbb.gbbserver.common.response.ErrorCode;

public class NotFoundException extends BaseException {

    public NotFoundException(ErrorCode errorCode) {
        super(HttpStatus.NOT_FOUND, errorCode.getMessage());
    }
}

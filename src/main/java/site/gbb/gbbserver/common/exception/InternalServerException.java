package site.gbb.gbbserver.common.exception;

import org.springframework.http.HttpStatus;
import site.gbb.gbbserver.common.response.ErrorCode;

public class InternalServerException extends BaseException {

    public InternalServerException(ErrorCode errorCode) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, errorCode.getMessage());
    }
}

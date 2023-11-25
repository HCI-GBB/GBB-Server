package site.gbb.gbbserver.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Already exists")
public class DuplicateException extends RuntimeException {

    public DuplicateException(String message) {
        super(message);
    }
}
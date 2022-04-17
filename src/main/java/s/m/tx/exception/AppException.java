package s.m.tx.exception;

import lombok.Builder;
import lombok.Getter;
import s.m.tx.common.ErrorCode;

@Builder
@Getter
public class AppException extends RuntimeException {

    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public AppException(ErrorCode errorCode) {
        super(new Exception(errorCode.getMessage()));
        this.errorCode = errorCode;
    }
}

package s.m.tx.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    TX_NOT_FOUND("The transaction with id %s was not found!", HttpStatus.NOT_FOUND),
    ERROR_PROCESSING_JSON("Error processing json data.", HttpStatus.BAD_REQUEST);

    private final HttpStatus httpStatus;
    private String message;

    ErrorCode(final String message, final HttpStatus httpStatus){
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public ErrorCode format(Object... param){
        this.message = String.format(this.message, param);
        return this;
    }

}

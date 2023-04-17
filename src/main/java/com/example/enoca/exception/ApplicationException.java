package com.example.enoca.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@Setter
@JsonIgnoreProperties({"stackTrace", "cause", "suppressed", "localizedMessage"})
public class ApplicationException extends RuntimeException {

    private final int resultCode;
    private final String message;
    private final int httpStatusCode;
    private final ZonedDateTime thrownAt;

    private static final String ZONE_ID = "Europe/Istanbul";

    public ApplicationException(int resultCode, String message, HttpStatus httpStatus) {
        super();
        this.resultCode = resultCode;
        this.message = message;
        this.httpStatusCode = httpStatus.value();
        this.thrownAt = ZonedDateTime.now(ZoneId.of(ZONE_ID));
    }

    @Override
    public String toString() {
        return "ApplicationException{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", httpStatusCode=" + httpStatusCode +
                ", thrownAt=" + thrownAt +
                '}';
    }
}

package br.com.pzg.project.two.exception;

import br.com.pzg.project.two.domain.RequestError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestfulExceptions {

    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public RequestError runtimeException(RuntimeException ex) {
        // log exception to svc
        return RequestError.builder()
                .code(HttpStatus.NOT_ACCEPTABLE.value())
                .message(ex.getMessage())
                .build();
    }
}

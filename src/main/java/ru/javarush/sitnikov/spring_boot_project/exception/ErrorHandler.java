package ru.javarush.sitnikov.spring_boot_project.exception;


import java.util.Arrays;
import java.util.List;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(MyException.class)
    public ErrorResponse handleInternalException(MyException e) {
        var response = ErrorResponse.build(
                HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        log.error("Internal Server Error: {}", response);
        if (log.isTraceEnabled()) {
            log.error(Arrays.toString(e.getStackTrace()));
        }
        return response;
    }

}
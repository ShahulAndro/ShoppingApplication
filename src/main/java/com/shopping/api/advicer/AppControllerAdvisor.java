package com.shopping.api.advicer;

import com.shopping.api.exception.RecordNotFoundException;
import com.shopping.api.builder.MessageBuilder;
import com.shopping.api.response.Message;
import com.shopping.api.types.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.Objects;

@ControllerAdvice
@Slf4j
public class AppControllerAdvisor {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Message> handleRecordNotFound(RecordNotFoundException exception) {
        log.error(Status.NOT_FOUND.name(), exception);

        Message message = MessageBuilder.response(Status.NOT_FOUND.name(), exception.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Message> handleGenericException(Exception exception) {
        log.error(Status.NOT_FOUND.name(), exception);

        Message message = MessageBuilder.response(Status.GENERIC_ERROR.name(), "Generic Exception");
        return ResponseEntity.internalServerError().body(message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Message> handleMethodValidationExceptions(MethodArgumentNotValidException exception) {
        log.error(Status.BAD_REQUEST.name(), exception);

        StringBuilder errorMessage = new StringBuilder();
        for (ObjectError error : exception.getBindingResult().getAllErrors()) {

            if(error instanceof FieldError fieldError) {
                errorMessage.append(fieldError.getField()).append(":").append(error.getDefaultMessage()).append("\n");
            } else {
                errorMessage.append(Arrays.stream(Objects.requireNonNull(error.getCodes())).findFirst()).append(":").append(error.getDefaultMessage()).append("\n");
            }
        }

        Message message = MessageBuilder.response(Status.BAD_REQUEST.name(), errorMessage.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

}

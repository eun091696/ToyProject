package com.ToyProject.eun.api.advice;
import com.ToyProject.eun.dto.CMRespDto;
import com.ToyProject.eun.exception.CustomInternalServerErrorException;
import com.ToyProject.eun.exception.CustomValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<?> validationErrorException(CustomValidationException e) {
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    }

    @ExceptionHandler(CustomInternalServerErrorException.class)
    public ResponseEntity<?> internalServerErrorException(CustomValidationException e) {

        return ResponseEntity.internalServerError().body(new CMRespDto<>(e.getMessage(), null));
    }

}

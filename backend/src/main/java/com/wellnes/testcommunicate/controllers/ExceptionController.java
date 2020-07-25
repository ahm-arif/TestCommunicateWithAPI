package com.wellnes.testcommunicate.controllers;

import com.wellnes.testcommunicate.exceptions.NotFoundException;
import com.wellnes.testcommunicate.models.outbounds.wrapper.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice
public class ExceptionController {
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler({ NotFoundException.class, NoHandlerFoundException.class })
  public BaseResponse notFoundException(Exception e) {

    log.error(e.getMessage(), e);

    return BaseResponse.builder()
            .code(HttpStatus.NOT_FOUND.value())
            .status(HttpStatus.NOT_FOUND.getReasonPhrase())
            .build();
  }
}

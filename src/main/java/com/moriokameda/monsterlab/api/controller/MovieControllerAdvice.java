package com.moriokameda.monsterlab.api.controller;

import com.moriokameda.monsterlab.api.infra.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice(basePackageClasses = MovieController.class)
public class MovieControllerAdvice extends ResponseEntityExceptionHandler {

    /**
     * idからMovieの取得が失敗した場合
     */
    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleNotFoundException(NullPointerException e, WebRequest request) {
        return super.handleExceptionInternal(e, null, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    /**
     * その他全てのException
     *
     * @param e
     * @param headers
     * @param request
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleAllException(
            Exception e,
            HttpHeaders headers,
            WebRequest request
    ) {
        return super.handleExceptionInternal(e, null, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}

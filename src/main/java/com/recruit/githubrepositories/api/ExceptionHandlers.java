package com.recruit.githubrepositories.api;

import com.recruit.githubrepositories.infrastructure.dao.GithubRepositoryClientErrorException;
import com.recruit.githubrepositories.infrastructure.dao.GithubRepositoryServerErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlers {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(GithubRepositoryClientErrorException.class)
    public ResponseEntity onGithubRepositoryClientErrorException(GithubRepositoryClientErrorException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(GithubRepositoryServerErrorException.class)
    public ResponseEntity onGithubRepositoryServerErrorException(GithubRepositoryServerErrorException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity onRuntimeException(RuntimeException exception) {
        return new ResponseEntity("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

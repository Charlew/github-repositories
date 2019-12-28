package com.recruit.githubrepositories.api;

import com.recruit.githubrepositories.infrastructure.dao.GithubRepositoryCommunicationErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlers {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(GithubRepositoryCommunicationErrorException.class)
    public ResponseEntity onGithubRepositoryCommunicationErrorException(
            GithubRepositoryCommunicationErrorException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}

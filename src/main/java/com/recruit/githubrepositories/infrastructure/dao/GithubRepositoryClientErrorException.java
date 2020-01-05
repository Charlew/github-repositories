package com.recruit.githubrepositories.infrastructure.dao;

import org.springframework.http.HttpStatus;

public class GithubRepositoryClientErrorException extends RuntimeException {
    private final HttpStatus httpStatus;

    public GithubRepositoryClientErrorException(HttpStatus httpStatus, Exception cause) {
        super(String.format("Github repository client communication failed with status code: %s", httpStatus.value()), cause);
        this.httpStatus = httpStatus;
    }
}

package com.recruit.githubrepositories.infrastructure.dao;

import org.springframework.http.HttpStatus;

public class GithubRepositoryCommunicationErrorException extends RuntimeException {
    private final HttpStatus httpStatus;

    public GithubRepositoryCommunicationErrorException(HttpStatus httpStatus, Exception cause) {
        super(String.format("Github repository communication failed with code: %s", httpStatus.value()), cause);
        this.httpStatus = httpStatus;
    }
}

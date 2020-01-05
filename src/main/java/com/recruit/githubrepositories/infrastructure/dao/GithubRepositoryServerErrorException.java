package com.recruit.githubrepositories.infrastructure.dao;

public class GithubRepositoryServerErrorException extends RuntimeException {

    public GithubRepositoryServerErrorException() {
        super("Github repository internal server error");
    }
}

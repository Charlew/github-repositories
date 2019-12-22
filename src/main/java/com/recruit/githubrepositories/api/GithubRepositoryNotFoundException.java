package com.recruit.githubrepositories.api;

public class GithubRepositoryNotFoundException extends RuntimeException {

    public GithubRepositoryNotFoundException(String owner, String name) {
        super("Cannot find repository: " + name + " and owner: " + owner);
    }
}

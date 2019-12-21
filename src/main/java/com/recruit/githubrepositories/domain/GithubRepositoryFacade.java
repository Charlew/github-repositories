package com.recruit.githubrepositories.domain;

public interface GithubRepositoryFacade {

    GithubRepository get(String owner, String repositoryName);
}

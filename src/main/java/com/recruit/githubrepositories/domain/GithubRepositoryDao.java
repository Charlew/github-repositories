package com.recruit.githubrepositories.domain;

public interface GithubRepositoryDao {

    GithubRepository getRepositoryData(String owner, String name);
}

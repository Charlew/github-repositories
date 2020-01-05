package com.recruit.githubrepositories.domain;

import com.recruit.githubrepositories.infrastructure.dao.GithubRepositoryRestApiClient;
import org.springframework.stereotype.Service;

@Service
public final class GithubRepositoryFacade {

    private final GithubRepositoryRestApiClient githubRepositoryClient;

    public GithubRepositoryFacade(GithubRepositoryRestApiClient githubRepositoryClient) {
        this.githubRepositoryClient = githubRepositoryClient;
    }

    public GithubRepository get(String owner, String repositoryName) {
        return githubRepositoryClient.getRepositoryData(owner, repositoryName);
    }
}

package com.recruit.githubrepositories.domain;

import com.recruit.githubrepositories.infrastructure.dao.GithubRepositoryRestApiClient;
import org.springframework.stereotype.Service;

@Service
final class StandardGithubRepositoryFacade implements GithubRepositoryFacade {

    private final GithubRepositoryRestApiClient githubRepositoryClient;

    public StandardGithubRepositoryFacade(GithubRepositoryRestApiClient githubRepositoryClient) {
        this.githubRepositoryClient = githubRepositoryClient;
    }

    public GithubRepository get(String owner, String repositoryName) {
        return githubRepositoryClient.getRepositoryData(owner, repositoryName);
    }
}

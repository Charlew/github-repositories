package com.recruit.githubrepositories.domain;

import org.springframework.stereotype.Service;

@Service
public final class StandardGithubRepositoryFacade implements GithubRepositoryFacade {

    private final GithubRepositoryDao githubRepositoryDao;

    public StandardGithubRepositoryFacade(GithubRepositoryDao githubRepositoryDao) {
        this.githubRepositoryDao = githubRepositoryDao;
    }

    public GithubRepository get(String owner, String repositoryName) {
        return githubRepositoryDao.getRepositoryData(owner, repositoryName);
    }
}

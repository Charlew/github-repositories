package com.recruit.githubrepositories.api;

import com.recruit.githubrepositories.domain.GithubRepository;
import com.recruit.githubrepositories.domain.GithubRepositoryFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/repositories")
public class GithubRepositoryEndpoint {

    private final GithubRepositoryFacade githubRepository;

    public GithubRepositoryEndpoint(GithubRepositoryFacade githubRepository) {
        this.githubRepository = githubRepository;
    }

    @GetMapping(path = "{owner}/{repository-name}", produces = APPLICATION_JSON_VALUE)
    public GithubRepository getRepositoryData(@PathVariable("owner") String owner,
                                              @PathVariable("repository-name") String repositoryName) {
        return githubRepository.get(owner, repositoryName);
    }
}

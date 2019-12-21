package com.recruit.githubrepositories.infrastructure.dao;

import com.recruit.githubrepositories.api.BadResponseFromExternalApiException;
import com.recruit.githubrepositories.domain.GithubRepository;
import com.recruit.githubrepositories.domain.GithubRepositoryDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public final class RestGithubRepositoryDao implements GithubRepositoryDao {

    private final RestTemplate http;

    private final String externalApiUrl;

    public RestGithubRepositoryDao(RestTemplate http, @Value("${externalApi.url}") String externalApiUrl) {
        this.http = http;
        this.externalApiUrl = externalApiUrl;
    }

    @Override
    public GithubRepository getRepositoryData(String owner, String name) {
        var url = UriComponentsBuilder
                .newInstance()
                .pathSegment(externalApiUrl, owner, name)
                .toUriString();

        try {
            return http.getForObject(url, GithubRepository.class);
        } catch (HttpClientErrorException e) {
            throw new BadResponseFromExternalApiException(e.getResponseBodyAsString());
        }
    }
}

package com.recruit.githubrepositories.infrastructure.dao;

import com.recruit.githubrepositories.domain.GithubRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public final class GithubRepositoryRestApiClient {

    private final RestTemplate http;

    private final String externalApiUrl;

    public GithubRepositoryRestApiClient(RestTemplate http, @Value("${externalApi.url}") String externalApiUrl) {
        this.http = http;
        this.externalApiUrl = externalApiUrl;
    }

    public GithubRepository getRepositoryData(String owner, String name) {
        var url = UriComponentsBuilder
                .fromUriString(externalApiUrl)
                .pathSegment("repos", owner, name)
                .toUriString();

        try {
            return http.getForObject(url, GithubRepository.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw new GithubRepositoryCommunicationErrorException(e.getStatusCode(), e);
        }
    }
}

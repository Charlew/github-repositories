package com.recruit.githubrepositories.api

import com.recruit.githubrepositories.IntegrationSpec
import com.recruit.githubrepositories.domain.GithubRepository
import spock.lang.Unroll

import java.time.LocalDate

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse
import static com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import static com.github.tomakehurst.wiremock.client.WireMock.get
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo

class GithubRepositoryEndpointSpec extends IntegrationSpec {

    def "should get repository from external api"() {
        given:
            stubFor(
                get(urlEqualTo("/repos/octocat/Hello-World"))
                    .willReturn(aResponse()
                        .withHeader('Content-Type', 'application/json')
                        .withBody(
                            '''
                            {
                                "clone_url": "https://github.com/octocat/Hello-World.git",
                                "created_at": "2011-01-26",
                                "description": "My first repository on GitHub!",
                                "full_name": "octocat/Hello-World",
                                "stargazers_count": 1527
                            }
                            '''
                        )))
            def url = url("/repositories/octocat/Hello-World")
        when:
            def response = httpClient.getForEntity(url, GithubRepository.class)
        then:
            response.statusCode.is2xxSuccessful()

            response.body.fullName == "octocat/Hello-World"
            response.body.description == "My first repository on GitHub!"
            response.body.createdAt == LocalDate.parse("2011-01-26")
            response.body.stars == 1527
            response.body.cloneUrl == "https://github.com/octocat/Hello-World.git"
    }

    def "should return client communication error"() {
        given:
            stubFor(
                    get(anyUrl())
                            .willReturn(aResponse()
                                    .withStatus(statusCode)
                            ))
            def url = url("/repositories/octocat/Hello-World")
        when:
            def response = httpClient.getForEntity(url, String.class)
        then:
            response.statusCode.is4xxClientError()
            response.body == "Github repository client communication failed with status code: $statusCode"
        where:
            statusCode << [403, 404]
    }

    def "should return github repository internal server error"() {
        given:
            stubFor(
                    get(anyUrl())
                            .willReturn(aResponse()
                                    .withStatus(statusCode)
                            ))
            def url = url("/repositories/octocat/Hello-World")
        when:
            def response = httpClient.getForEntity(url, String.class)
        then:
            response.statusCode.is5xxServerError()
            response.body == "Github repository internal server error"
        where:
            statusCode << [500, 502, 503]
    }

    @Unroll
    def "should return github repository internal error when external API delay is #delay"() {
        given:
            stubFor(
                    get(anyUrl())
                            .willReturn(aResponse()
                                    .withStatus(200)
                                    .withFixedDelay(delay)
                            ))
            def url = url("/repositories/octocat/Hello-World")
        when:
            def response = httpClient.getForEntity(url, String.class)
        then:
            response.statusCode.is5xxServerError()
            response.body == "Internal error"
        where:
            delay << [1000, 5000]
    }
}

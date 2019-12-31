package com.recruit.githubrepositories

import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Rule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(
    classes = GithubRepositoriesApplication,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@TestPropertySource(value = "classpath:application-test.properties")
abstract class IntegrationSpec extends Specification {

    TestRestTemplate httpClient = new TestRestTemplate()

    @LocalServerPort
    int port

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089)

    String url(String endpoint) {
        return "http://localhost:" + port + endpoint;
    }
}

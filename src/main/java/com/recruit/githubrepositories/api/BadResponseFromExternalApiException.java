package com.recruit.githubrepositories.api;

public class BadResponseFromExternalApiException extends RuntimeException {

    private final String responseBody;

    public BadResponseFromExternalApiException(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getResponseBody() {
        return responseBody;
    }
}

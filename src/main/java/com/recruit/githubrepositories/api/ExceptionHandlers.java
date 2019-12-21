package com.recruit.githubrepositories.api;

import com.recruit.githubrepositories.domain.Problem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static java.lang.invoke.MethodHandles.lookup;
import static java.util.Collections.singletonList;

@ControllerAdvice
public class ExceptionHandlers {

    private final Logger logger = LoggerFactory.getLogger(lookup().lookupClass());

    @ExceptionHandler(value = BadResponseFromExternalApiException.class)
    public Problem onBadResponseFromExternalApiException(BadResponseFromExternalApiException e) {
        logger.info("Received bad response from external api: {}", e.getResponseBody());
        return new Problem(singletonList(e.getResponseBody()));
    }

    @ExceptionHandler(value = RuntimeException.class)
    public Problem onRuntimeException() {
        logger.error("internalError");
        return new Problem(singletonList("internalError"));
    }
}

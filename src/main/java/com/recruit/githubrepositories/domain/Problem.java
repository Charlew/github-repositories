package com.recruit.githubrepositories.domain;

import java.util.List;

public class Problem {

    private final List<String> codes;

    public Problem(List<String> codes) {
        this.codes = codes;
    }

    public List<String> getCodes() {
        return codes;
    }
}

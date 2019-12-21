package com.recruit.githubrepositories.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Objects;

public final class GithubRepository {

    private final String fullName;

    private final String description;

    private final String cloneUrl;

    private final int stars;

    private final LocalDate createdAt;

    public GithubRepository(@JsonProperty("fullName") String fullName,
                            @JsonProperty("description") String description,
                            @JsonProperty("cloneUrl") String cloneUrl,
                            @JsonProperty("stars") int stars,
                            @JsonProperty("createdAt") LocalDate createdAt) {
        this.fullName = fullName;
        this.description = description;
        this.cloneUrl = cloneUrl;
        this.stars = stars;
        this.createdAt = createdAt;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public int getStars() {
        return stars;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubRepository that = (GithubRepository) o;
        return stars == that.stars &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(description, that.description) &&
                Objects.equals(cloneUrl, that.cloneUrl) &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public String toString() {
        return "GithubRepository{" +
                "fullName='" + fullName + '\'' +
                ", description='" + description + '\'' +
                ", cloneUrl='" + cloneUrl + '\'' +
                ", stars=" + stars +
                ", createdAt=" + createdAt +
                '}';
    }
}

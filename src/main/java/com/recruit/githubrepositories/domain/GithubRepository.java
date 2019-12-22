package com.recruit.githubrepositories.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class GithubRepository {

    private final String fullName;

    private final String description;

    private final String cloneUrl;

    private final int stars;

    private final LocalDate createdAt;

    @JsonCreator
    public GithubRepository(@JsonProperty("full_name") String fullName,
                            @JsonProperty("description") String description,
                            @JsonProperty("clone_url") String cloneUrl,
                            @JsonProperty("stargazers_count") int stars,
                            @JsonProperty("created_at") LocalDate createdAt) {
        this.fullName = fullName;
        this.description = description;
        this.cloneUrl = cloneUrl;
        this.stars = stars;
        this.createdAt = createdAt;
    }

    @JsonGetter("fullName")
    public String getFullName() {
        return fullName;
    }

    @JsonGetter("description")
    public String getDescription() {
        return description;
    }

    @JsonGetter("cloneUrl")
    public String getCloneUrl() {
        return cloneUrl;
    }

    @JsonGetter("stars")
    public int getStars() {
        return stars;
    }

    @JsonGetter("createdAt")
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
    public int hashCode() {
        return Objects.hash(fullName, description, cloneUrl, stars, createdAt);
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

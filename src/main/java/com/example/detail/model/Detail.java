package com.example.detail.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity(name = "detail")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(name = "article")
    private String article;

    @NotNull
    @Column(name = "prod")
    private LocalDate dateCreated;

    @NotNull
    @Column(name = "organisation_id")
    private int organisationId;

    public Detail(String article, LocalDate dateCreated, int organisationId) {
        this.article = article;
        this.dateCreated = dateCreated;
        this.organisationId = organisationId;
    }

    public Detail() {
    }

    public long getId() {
        return this.id;
    }

    public String getArticle() {
        return this.article;
    }

    public LocalDate getDateCreated() {
        return this.dateCreated;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setOrganisationId(int organisationId) {
        this.organisationId = organisationId;
    }

    public int getOrganisationId() {
        return organisationId;
    }
}
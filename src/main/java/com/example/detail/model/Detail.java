package com.example.detail.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity(name = "detail")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "article")
    private String article;

    @NotNull
    @Column(name = "prod")
    private LocalDate dateCreated;


    public Detail(String article, LocalDate dateCreated) {
        this.article = article;
        this.dateCreated = dateCreated;
    }

    public Detail() {
    }

    public Long getId() {
        return this.id;
    }

    public String getArticle() {
        return this.article;
    }

    public LocalDate getDateCreated() {
        return this.dateCreated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

}
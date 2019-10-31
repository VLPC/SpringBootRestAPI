package com.example.detail.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Calendar;


@Entity(name = "details")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NonNull
    private String article;

    @NotNull
    @Column(name = "prod")
    private LocalDate productionDate;

    public Detail(String article, LocalDate productionDate) {
        this.article = article;
        this.productionDate = productionDate;
    }

    public Detail() {
    }

    public long getId() {
        return this.id;
    }

    public String getArticle() {
        return this.article;
    }

    public LocalDate getProductionDate() {
        return this.productionDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }
}
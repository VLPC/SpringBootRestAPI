package com.example.detail.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "details")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String article;

    public Detail(String article) {
        this.article = article;
    }

    public Detail() {
    }

    public Long getId() {
        return this.id;
    }


    public String getArticle() {
        return this.article;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}

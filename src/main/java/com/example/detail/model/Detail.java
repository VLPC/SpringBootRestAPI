package com.example.detail.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "details")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String article;

    public Detail(int id, String article) {
        this.id = id;
        this.article = article;
    }

    public Detail() {
    }

    public int getId() {
        return this.id;
    }


    public String getArticle() {
        return this.article;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}

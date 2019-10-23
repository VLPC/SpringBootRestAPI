package com.example.detail.controller;

public class Detail {
    private int id;
    private String article;

    public Detail(int id, String article){
        this.id = id;
        this.article = article;
    }

    public Detail(){}

    public int getId(){
        return this.id;
    }

    public String getArticle(){
        return this.article;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setArticle(String article){
        this.article = article;
    }
}

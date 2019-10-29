package com.example.detail.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;


@Entity(name = "details")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String article;
    private Calendar productionDate;

    public Detail(String article, Calendar productionDate) {
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

    public Calendar getProductionDate(){
        return this.productionDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setProductionDate(Calendar productionDate){
        this.productionDate = productionDate;
    }
}

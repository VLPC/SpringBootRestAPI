package com.example.detail.service;

import com.example.detail.model.Detail;
import com.example.detail.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailService {

    private DetailRepository detailRepository;

    @Autowired
    public DetailService(DetailRepository detailRepository){
        this.detailRepository = detailRepository;
    }

    public Detail getDetailById(Long id) {
        return detailRepository.findById(id).get();
    }

    public Detail saveDetail(Detail detail) {
        return detailRepository.save(detail);
    }

    public void updateDetail(Long id, String article) {
        detailRepository.findById(id).get().setArticle(article);
    }

    public void deleteDetail(long id) {
        detailRepository.deleteById(id);
    }

    public Iterable<Detail> findAll() {
        return detailRepository.findAll();
    }

    public List<Detail>  getDetailsByProd(int year){
        return detailRepository.getDetailsByProd(year);
    }
}

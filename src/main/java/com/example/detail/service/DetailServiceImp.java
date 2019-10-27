package com.example.detail.service;

import com.example.detail.model.Detail;
import com.example.detail.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImp implements DetailService {

    @Autowired
    private DetailRepository detailRepository;


    @Override
    public Detail getDetailById(Long id) {
        return detailRepository.findById(id).get();
    }

    @Override
    public void saveDetail(Detail detail) {
        detailRepository.save(detail);
    }

    @Override
    public void updateDetail(Long id, String article) {
        detailRepository.findById(id).get().setArticle(article);

    }

    @Override
    public void deleteDetail(Long id) {
        detailRepository.deleteById(id);
    }

    @Override
    public Iterable<Detail> findAll() {
        return detailRepository.findAll();
    }
}

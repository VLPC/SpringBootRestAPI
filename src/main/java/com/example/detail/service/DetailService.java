package com.example.detail.service;

import com.example.detail.model.Detail;

public interface DetailService {
    Detail getDetailById(Long id);
    void saveDetail(Detail detail);
    void updateDetail(Long id, String article);
    void deleteDetail(Long id);
    Iterable<Detail> findAll();
}

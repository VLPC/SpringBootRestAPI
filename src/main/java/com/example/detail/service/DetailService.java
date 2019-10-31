package com.example.detail.service;

import com.example.detail.model.Detail;
import com.example.detail.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DetailService {

    @Autowired
    private DetailRepository detailRepository;

    public Detail getDetailById(Long id) {
        return detailRepository.findById(id).get();
    }

    public void saveDetail(Detail detail) {
        detailRepository.save(detail);
    }

    public void updateDetail(Long id, String article) {
        detailRepository.findById(id).get().setArticle(article);
    }

    public void deleteDetail(Long id) {
        detailRepository.deleteById(id);
    }

    public Iterable<Detail> findAll() {
        return detailRepository.findAll();
    }

    public List<Detail> detailAgeMoreThen(long detailAge){
        Iterable<Detail> iterable = detailRepository.findAll();
        List<Detail> list = new ArrayList<>();
        Iterator<Detail> iterator = iterable.iterator();
        Calendar currentDate = new GregorianCalendar();
//        while (iterator.hasNext()){
//            Detail detail = iterator.next();
//            if (currentDate.getWeekYear() - detail.getProductionDate().getWeekYear() > detailAge){
//                list.add(detail);
//            }
//        }
        return list;
    }
}

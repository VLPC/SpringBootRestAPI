package com.example.detail.controller;

import com.example.detail.model.Detail;
import com.example.detail.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("details")
public class DetailController {

    @Autowired
    DetailRepository detailRepository;

    private List<Detail> details = new ArrayList<Detail>(){{
        add(new Detail(1, "detail1"));
        add(new Detail(2, "detail2"));
        add(new Detail(3, "detail3"));
    }};

    @GetMapping
    public List<Detail> getAllDetails(){
        return details;
    }

    @GetMapping("{id}")
    public Detail getDetail(@PathVariable int id){
        for (int i = 0; i < details.size(); i++){
            Detail detail = details.get(i);
            if (detail.getId() == id){
                return detail;
            }
        }
        return new Detail(); //if object not found return empty object
    }

    @PostMapping("/add")
    public List<Detail> createDetail(@RequestBody String article){
        int maxId = details.get(details.size() - 1).getId();
        details.add(new Detail(maxId + 1, article));
        return details;
    }

    @PutMapping("update/{id}")
    public List<Detail> updateDetail(@PathVariable int id, @RequestBody String article){
        for (int i = 0; i < details.size(); i++){
            Detail detail = details.get(i);
            if (detail.getId() == id){
                detail.setArticle(article);
                return details;
            }
        }
        return details;
    }

    @DeleteMapping("delete/{id}")
    public void deleteDetail(@PathVariable long id){
        detailRepository.deleteById(id);
    }
}

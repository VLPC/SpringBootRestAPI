package com.example.detail.controller;

import com.example.detail.model.Detail;
import com.example.detail.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("details")
public class DetailController {

    @Autowired
    private DetailService detailService;

    @GetMapping
    public Iterable<Detail> getAllDetails(){
        return detailService.findAll();
    }

    @GetMapping("{id}")
    public Detail getDetail(@PathVariable int id){
        return detailService.getDetailById(Long.valueOf(id));
    }

    @PostMapping("/add")
    public void createDetail(@RequestBody String article){
        detailService.saveDetail(new Detail(article));
    }

    @PutMapping("update/{id}")
    public void updateDetail(@PathVariable int id, @RequestBody String article){
        detailService.updateDetail(Long.valueOf(id), article);
    }

    @DeleteMapping("delete/{id}")
    public void deleteDetail(@PathVariable long id){
        detailService.deleteDetail(Long.valueOf(id));
    }
}

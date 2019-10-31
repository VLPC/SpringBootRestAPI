package com.example.detail.controller;

import com.example.detail.model.Detail;
import com.example.detail.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("details")
public class DetailController {

    @Autowired
    private DetailService detailService;

    @GetMapping
    public Iterable<Detail> getAllDetails() {
        return detailService.findAll();
    }

    @GetMapping("{id}")
    public Detail getDetail(@PathVariable long id) {
        return detailService.getDetailById(id);
    }

    @PostMapping("/add")
    public void createDetail(@RequestBody String article, LocalDate productionDate) {
        detailService.saveDetail(new Detail(article, productionDate));
    }

    @PutMapping("update/{id}")
    public void updateDetail(@PathVariable long id, @RequestBody String article) {
        detailService.updateDetail(id, article);
    }

    @DeleteMapping("delete/{id}")
    public void deleteDetail(@PathVariable long id) {
        detailService.deleteDetail(id);
    }
}

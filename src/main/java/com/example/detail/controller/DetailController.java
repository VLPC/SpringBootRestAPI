package com.example.detail.controller;

import com.example.detail.model.Detail;
import com.example.detail.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("details")
public class DetailController {

    @Autowired
    private DetailService detailService;

    @GetMapping
    public ResponseEntity<Iterable<Detail>> getAllDetails() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Information", "all fucking details");
        return new ResponseEntity<>(detailService.findAll(), headers, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public Detail getDetail(@PathVariable long id) {
        return detailService.getDetailById(id);
    }

    @GetMapping("/prod/{year}")
    public List<Detail> getArticles(@PathVariable int year){
        return detailService.getDetailsByProd(year);
    }

    @PostMapping("/add")
    public void createDetail(@RequestBody String article, LocalDate productionDate, int organisationId) {
        detailService.saveDetail(new Detail(article, productionDate, organisationId));
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

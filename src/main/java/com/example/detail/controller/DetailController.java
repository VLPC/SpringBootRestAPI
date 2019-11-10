package com.example.detail.controller;

import com.example.detail.dto.DetailDto;
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
    public ResponseEntity<Detail> getDetail(@PathVariable long id) {
        return new ResponseEntity<>(detailService.getDetailById(id), HttpStatus.OK);
    }

    @GetMapping("/prod/{year}")
    public ResponseEntity<List<Detail>> getArticles(@PathVariable int year){
        return new ResponseEntity<>(detailService.getDetailsByProd(year), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Detail> createDetail(@RequestBody DetailDto detailDto) {

        // todo convert dto to entity with mapper
        Detail newDetail = Detail.builder()
                .article(detailDto.getArticle())
                .dateCreated(detailDto.getDateCreated())
                .build();

        return ResponseEntity.ok(detailService.saveDetail(newDetail));
    }

    @PutMapping("update/{id}")
    public void updateDetail(@PathVariable Long id, @RequestBody String article) {
        detailService.updateDetail(id, article);
    }

    @DeleteMapping("delete/{id}")
    public void deleteDetail(@PathVariable long id) {
        detailService.deleteDetail(id);
    }
}

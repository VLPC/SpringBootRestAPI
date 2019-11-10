package com.example.detail.controller;

import com.example.detail.dto.DetailDto;
import com.example.detail.model.Detail;
import com.example.detail.service.DetailService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Создание товара вручную
     */
    @ApiOperation(value = "Создание детали вручную. " )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Деталь успешно создана"),
            @ApiResponse(code = 500, message = "Произошла внутренняя ошибка"),
            @ApiResponse(code = 401, message = "Информация об аутентификации отсутствует или недействительна"),
            @ApiResponse(code = 403, message = "Действие не доступно для текущего пользователя"),
            @ApiResponse(code = 404, message = "Данные не найдены"),
            @ApiResponse(code = 422, message = "Некоторые значения некорректны")
    })
    @PostMapping
    public ResponseEntity<Detail> createDetail(@RequestBody DetailDto detailDto) {

        // todo convert dto to entity with mapper
        Detail newDetail = new Detail(detailDto.getArticle(), detailDto.getDateCreated());

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

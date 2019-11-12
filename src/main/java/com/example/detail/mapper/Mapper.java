package com.example.detail.mapper;

import com.example.detail.dto.DetailDto;
import com.example.detail.model.Detail;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Detail toEntity(DetailDto detailDto){
        return new Detail(detailDto.getArticle(), detailDto.getDateCreated());
    }

    public DetailDto toDto(Detail detail){
        return new DetailDto(detail.getArticle(), detail.getDateCreated());
    }
}

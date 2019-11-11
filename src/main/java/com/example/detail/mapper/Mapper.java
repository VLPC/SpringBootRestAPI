package com.example.detail.mapper;

import com.example.detail.dto.DetailDto;
import com.example.detail.model.Detail;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private ModelMapper modelMapper = new ModelMapper();

    public Detail toEntity(DetailDto detailDto){
        return modelMapper.map(detailDto, Detail.class);
    }

    public DetailDto toDto(Detail detail){
        return modelMapper.map(detail, DetailDto.class);
    }
}

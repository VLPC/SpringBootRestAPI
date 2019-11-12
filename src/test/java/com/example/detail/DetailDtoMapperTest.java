package com.example.detail;

import com.example.detail.dto.DetailDto;
import com.example.detail.mapper.Mapper;
import com.example.detail.model.Detail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DetailDtoMapperTest {

    @Autowired
    Mapper mapper;

    @Test
    void whenConvertEntityToDto_thenCorrect() {

        Detail detail = new Detail("article_test", LocalDate.of(2019, 11, 12));

        DetailDto detailDto = mapper.toDto(detail);

        assertEquals(detail.getArticle(), detailDto.getArticle());
        assertEquals(detail.getDateCreated(), detailDto.getDateCreated());

    }

    @Test
    void whenConvertDtoToEntity_thenCorrect() {

        DetailDto detailDto = new DetailDto("article", LocalDate.of(2019, 11, 11));

        Detail detail = mapper.toEntity(detailDto);

        assertEquals(detailDto.getArticle(), detail.getArticle());
        assertEquals(detailDto.getDateCreated(), detail.getDateCreated());

    }
}

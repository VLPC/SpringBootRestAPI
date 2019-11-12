package com.example.detail;

import com.example.detail.dto.DetailDto;
import com.example.detail.mapper.Mapper;
import com.example.detail.model.Detail;
import com.example.detail.repository.DetailRepository;
import com.example.detail.service.DetailService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DetailServiceTest {

	@MockBean
	DetailRepository detailRepository;

	@Autowired
	DetailService detailService = new DetailService(detailRepository);

	@Autowired
	Mapper mapper;

	@DisplayName("Initial empty test")
	@Test
	void helloTest() {
	}

	@Test
	void shouldReturnEmptyOldListDetails_whenThereIsOnlyNewDetails() {

		Mockito.when(detailRepository.getDetailsByProd(Mockito.anyInt()))
				.thenReturn(new ArrayList<>());

		Iterable<Detail> oldDetails = detailService.getDetailsByProd(2017);

		//Assertions.assertEquals(0, oldDetails.size());
	}

	@Test
	void whenConvertEntityToDto_thenCorrect() {

		Detail detail = new Detail("article_test", LocalDate.of(2019,11,12));

		DetailDto detailDto = mapper.toDto(detail);

		assertEquals(detail.getArticle(), detailDto.getArticle());
		assertEquals(detail.getDateCreated(), detailDto.getDateCreated());

	}

	@Test
	void whenConvertDtoToEntity_thenCorrect() {

		DetailDto detailDto = new DetailDto("article", LocalDate.of(2019,11,11));

		Detail detail =mapper.toEntity(detailDto);

		assertEquals(detailDto.getArticle(), detail.getArticle());
		assertEquals(detailDto.getDateCreated(), detail.getDateCreated());

	}
}
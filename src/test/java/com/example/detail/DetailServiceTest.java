package com.example.detail;

import com.example.detail.model.Detail;
import com.example.detail.repository.DetailRepository;
import com.example.detail.service.DetailService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

@SpringBootTest
class DetailServiceTest {

	@MockBean
	DetailRepository detailRepository;

	@Autowired
	DetailService detailService = new DetailService(detailRepository);

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
}
package com.example.detail.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailDto {

    @Builder.Default
    private String article = "";

    @Builder.Default
    private LocalDate dateCreated = LocalDate.of(2010, 01, 01);
}

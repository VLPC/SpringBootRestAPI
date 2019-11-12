package com.example.detail.dto

import java.time.LocalDate

data class DetailDto(val article: String = "", val dateCreated: LocalDate = LocalDate.MIN)
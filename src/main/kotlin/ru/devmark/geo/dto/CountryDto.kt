package ru.devmark.geo.dto

data class CountryDto(
    val name: String,
    val cities: List<CityDto>
)

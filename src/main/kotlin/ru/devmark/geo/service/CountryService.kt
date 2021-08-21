package ru.devmark.geo.service

import ru.devmark.geo.dto.CountryDto

interface CountryService {

    fun getAllCountries(): List<CountryDto>

    fun getById(id: Int): CountryDto

    fun create(country: CountryDto)

    fun update(id: Int, country: CountryDto)

    fun deleteById(id: Int)
}
package ru.devmark.geo.service

import ru.devmark.geo.dto.CountryDto
import ru.devmark.geo.model.Country

interface CountryService {

    fun getAllCountries(): List<Country>

    fun getById(id: Int): Country

    fun create(country: CountryDto)

    fun update(id: Int, country: CountryDto)

    fun deleteById(id: Int)
}
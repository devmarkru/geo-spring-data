package ru.devmark.geo.dao

import org.springframework.data.repository.CrudRepository
import ru.devmark.geo.model.Country

interface CountryDao: CrudRepository<Country, Int> {
}
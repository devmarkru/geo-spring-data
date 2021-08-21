package ru.devmark.geo.dao

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import ru.devmark.geo.model.Country

interface CountryDao: CrudRepository<Country, Int> {

    @Query("select distinct c from Country c join fetch c.cities")
    fun findAllWithJoin(): List<Country>
}
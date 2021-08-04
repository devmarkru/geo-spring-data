package ru.devmark.geo.service

import org.springframework.stereotype.Service
import ru.devmark.geo.dao.CountryDao
import ru.devmark.geo.dto.CountryDto
import ru.devmark.geo.model.Country

@Service
class CountryServiceImpl(
    private val countryDao: CountryDao,
) : CountryService {

    override fun getAllCountries(): List<Country> =
        countryDao.findAll().toList()

    override fun getById(id: Int): Country =
        countryDao.findById(id).orElseThrow()

    override fun create(country: CountryDto) {
        val newCountry = Country(
            name = country.name,
        )
        countryDao.save(newCountry)
    }

    override fun update(id: Int, country: CountryDto) {
        countryDao.findById(id).ifPresent { oldCountry ->
            val newCountry = oldCountry.copy(
                name = country.name,
            )
            countryDao.save(newCountry)
        }
    }

    override fun deleteById(id: Int) {
        countryDao.deleteById(id)
    }
}
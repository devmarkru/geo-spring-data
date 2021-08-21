package ru.devmark.geo.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.devmark.geo.dao.CountryDao
import ru.devmark.geo.dto.CityDto
import ru.devmark.geo.dto.CountryDto
import ru.devmark.geo.exception.CountryNotFoundException
import ru.devmark.geo.model.Country

@Service
class CountryServiceImpl(
    private val countryDao: CountryDao,
) : CountryService {

    override fun getAllCountries(): List<CountryDto> =
        countryDao.findAllWithJoin().map {
            it.toDto()
        }

    override fun getById(id: Int): CountryDto =
        countryDao.findByIdOrNull(id)
            ?.toDto()
            ?: throw CountryNotFoundException(id)

    override fun create(country: CountryDto) {
        val newCountry = Country(
            name = country.name,
        )
        countryDao.save(newCountry)
    }

    override fun update(id: Int, country: CountryDto) {
        val oldCountry = countryDao.findByIdOrNull(id)
            ?: throw CountryNotFoundException(id)
        val newCountry = oldCountry.copy(
            name = country.name,
        )
        countryDao.save(newCountry)
    }

    override fun deleteById(id: Int) {
        countryDao.deleteById(id)
    }

    private fun Country.toDto(): CountryDto =
        CountryDto(
            name = this.name,
            cities = this.cities
                .map { city ->
                    CityDto(
                        name = city.name,
                    )
                }
        )
}
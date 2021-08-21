package ru.devmark.geo.exception

import org.springframework.http.HttpStatus

class CountryNotFoundException(id: Int) : BaseException(
    HttpStatus.NOT_FOUND,
    "country.not.found",
    "Country with id=$id not found"
)
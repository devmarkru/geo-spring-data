package ru.devmark.geo.exception

data class ApiError(
    val errorCode: String,
    val description: String,
)
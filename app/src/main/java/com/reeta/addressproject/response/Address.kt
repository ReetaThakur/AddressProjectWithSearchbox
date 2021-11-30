package com.reeta.addressproject.response

data class Address(
    val addressString: String,
    val city: String,
    val id: String,
    val label: String,
    val latitude: Double,
    val longitude: Double,
    val pinCode: String,
    val priority: Int,
    val source: String
)
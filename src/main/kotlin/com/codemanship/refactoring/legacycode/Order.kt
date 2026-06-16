package com.codemanship.refactoring.legacycode

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class Order @JsonCreator constructor(
    @JsonProperty("orderId")
    val orderId: Int,

    @JsonProperty("shippingType")
    val shippingType: String,

    @JsonProperty("weightKg")
    val weightKg: Double,

    @JsonProperty("distanceKm")
    val distanceKm: Double,

    @JsonProperty("fragile")
    val fragile: Boolean
)
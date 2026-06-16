package com.codemanship.refactoring.legacycode

import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ShippingCalculator {

    private val objectMapper = ObjectMapper()
    private val httpClient = HttpClient.newHttpClient()

    fun calculateShipping(orderId: Int): Double {
        return try {
            val request = HttpRequest.newBuilder()
                .uri(
                    URI.create(
                        "https://codemanship.co.uk/api/orders.php?orderId=$orderId"
                    )
                )
                .GET()
                .build()

            val response = httpClient.send(
                request,
                HttpResponse.BodyHandlers.ofString()
            )

            val json = response.body()

            val order = objectMapper.readValue(json, Order::class.java)

            when (order.shippingType) {
                "STANDARD" -> order.weightKg * 0.5

                "EXPRESS" -> order.weightKg * 0.8 +
                        order.distanceKm * 0.1

                "OVERNIGHT" -> order.weightKg * 1.2 + 25

                else -> throw RuntimeException(
                    "Unknown shipping type: ${order.shippingType}"
                )
            }

        } catch (e: Exception) {
            println(e)
            -1.0
        }
    }
}
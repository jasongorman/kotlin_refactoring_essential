package com.codemanship.refactoring.duplication

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class WeatherReportTest {

    @Test
    fun formatsMorningForecastCorrectly() {
        val report = WeatherReport()

        val forecast = Forecast("morning", 12.5, "Cloudy", 10)

        val output = mutableListOf<String>()
        report.formatDailyReport(listOf(forecast), output)

        assertEquals(1, output.size)
        assertEquals(
            "Morning: 12.5°C, Cloudy, wind 10km/h",
            output[0]
        )
    }

    @Test
    fun formatsAfternoonForecastCorrectly() {
        val report = WeatherReport()

        val forecast = Forecast("afternoon", 8.0, "Rain", 20)

        val output = mutableListOf<String>()
        report.formatDailyReport(listOf(forecast), output)

        assertEquals(1, output.size)
        assertEquals(
            "Afternoon: 8.0°C, Rain, wind 20km/h",
            output[0]
        )
    }

    @Test
    fun formatsEveningForecastCorrectly() {
        val report = WeatherReport()

        val forecast = Forecast("evening", 8.0, "Rain", 20)

        val output = mutableListOf<String>()
        report.formatDailyReport(listOf(forecast), output)

        assertEquals(1, output.size)
        assertEquals(
            "Evening: 8.0°C, Rain, wind 20km/h",
            output[0]
        )
    }

    @Test
    fun formatsMultipleForecastsInOrder() {
        val report = WeatherReport()

        val forecasts = listOf(
            Forecast("morning", 10.0, "Sunny", 5),
            Forecast("night", 3.0, "Clear", 2)
        )

        val output = mutableListOf<String>()
        report.formatDailyReport(forecasts, output)

        assertEquals(2, output.size)

        assertEquals(
            "Morning: 10.0°C, Sunny, wind 5km/h",
            output[0]
        )

        assertEquals(
            "Night: 3.0°C, Clear, wind 2km/h",
            output[1]
        )
    }
}
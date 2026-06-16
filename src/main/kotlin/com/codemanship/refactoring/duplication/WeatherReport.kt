package com.codemanship.refactoring.duplication

class WeatherReport {

    fun formatDailyReport(
        forecasts: List<Forecast>,
        output: MutableList<String>
    ) {
        for (forecast in forecasts) {

            if (forecast.isMorning()) {
                val line = "Morning: ${forecast.temperature}°C, " +
                        "${forecast.condition}, wind ${forecast.windSpeed}km/h"
                output.add(line)
            }

            if (forecast.isAfternoon()) {
                val line = "Afternoon: ${forecast.temperature}°C, " +
                        "${forecast.condition}, wind ${forecast.windSpeed}km/h"
                output.add(line)
            }

            if (forecast.isEvening()) {
                val line = "Evening: ${forecast.temperature}°C, " +
                        "${forecast.condition}, wind ${forecast.windSpeed}km/h"
                output.add(line)
            }

            if (forecast.isNight()) {
                val line = "Night: ${forecast.temperature}°C, " +
                        "${forecast.condition}, wind ${forecast.windSpeed}km/h"
                output.add(line)
            }
        }
    }
}
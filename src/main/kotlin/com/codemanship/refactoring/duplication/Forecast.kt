package com.codemanship.refactoring.duplication

class Forecast(
    private val period: String, // "morning", "afternoon", "evening", "night"
    val temperature: Double,
    val condition: String,
    val windSpeed: Int
) {

    fun isMorning() = period == "morning"

    fun isAfternoon() = period == "afternoon"

    fun isEvening() = period == "evening"

    fun isNight() = period == "night"
}

package com.codemanship.refactoring.legacycode

fun main(args: Array<String>) {

    if (args.size != 1) {
        println("Usage: kotlin ShippingAppKt <orderId>")
        return
    }

    val orderId = args[0].toInt()

    val calculator = ShippingCalculator()

    try {
        val cost = calculator.calculateShipping(orderId)

        println("Order ID: $orderId")
        println("Shipping cost: $cost")

    } catch (e: Exception) {
        println("Failed to calculate shipping for order $orderId")
        e.printStackTrace()
    }
}
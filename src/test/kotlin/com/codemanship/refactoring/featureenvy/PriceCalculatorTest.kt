package com.codemanship.refactoring.featureenvy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PriceCalculatorTest {

    private val calculator = PriceCalculator()

    @Test
    fun shouldApplyDiscountWhenProductIsOnSale() {
        val product = Product(100.0, true)

        val result = calculator.calculateFinalPrice(product)

        assertEquals(80.0, result)
    }

    @Test
    fun shouldNotApplyDiscountWhenProductIsNotOnSale() {
        val product = Product(100.0, false)

        val result = calculator.calculateFinalPrice(product)

        assertEquals(100.0, result)
    }

    @Test
    fun shouldReturnZeroWhenPriceIsZeroEvenIfOnSale() {
        val product = Product(0.0, true)

        val result = calculator.calculateFinalPrice(product)

        assertEquals(0.0, result)
    }
}
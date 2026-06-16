package com.codemanship.refactoring.longmethod

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OrderTest {

    @Test
    fun `summarise calculates correct summary for non loyal customer under threshold`() {
        val order = Order(
            listOf(
                OrderItem(10.0, 2.0), // 20
                OrderItem(5.0, 2.0)   // 10
            ),
            Customer(false)
        )

        val summary = order.summarise()

        assertEquals(30.0, summary.subtotal)
        assertEquals(0.0, summary.discount)
        assertEquals(6.0, summary.tax)
        assertEquals(36.0, summary.total)
    }

    @Test
    fun `summarise applies loyal customer discount`() {
        val order = Order(
            listOf(OrderItem(50.0, 1.0)),
            Customer(true)
        )

        val summary = order.summarise()

        assertEquals(50.0, summary.subtotal)
        assertEquals(5.0, summary.discount)
        assertEquals(9.0, summary.tax)
        assertEquals(54.0, summary.total)
    }

    @Test
    fun `summarise applies bulk discount for non loyal customer over threshold`() {
        val order = Order(
            listOf(OrderItem(120.0, 1.0)),
            Customer(false)
        )

        val summary = order.summarise()

        assertEquals(120.0, summary.subtotal)
        assertEquals(6.0, summary.discount)
        assertEquals(22.8, summary.tax)
        assertEquals(136.8, summary.total)
    }

    // -------------------------
    // Guard conditions
    // -------------------------

    @Test
    fun `summarise throws exception when items is null`() {
        val order = Order(null, Customer(false))

        val ex = assertThrows<IllegalStateException> {
            order.summarise()
        }

        assertEquals("Items cannot be null", ex.message)
    }

    @Test
    fun `summarise throws exception when items is empty`() {
        val order = Order(emptyList(), Customer(false))

        val ex = assertThrows<IllegalStateException> {
            order.summarise()
        }

        assertEquals("Order must contain items", ex.message)
    }

    // -------------------------
    // Boundary test
    // -------------------------

    @Test
    fun `summarise no discount when non loyal customer at threshold`() {
        val order = Order(
            listOf(OrderItem(100.0, 1.0)),
            Customer(false)
        )

        val summary = order.summarise()

        assertEquals(100.0, summary.subtotal)
        assertEquals(0.0, summary.discount)
        assertEquals(20.0, summary.tax)
        assertEquals(120.0, summary.total)
    }
}
package com.codemanship.refactoring.longparameterlist

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ShippingNoteGeneratorTest {

    private val shippingNoteGenerator = ShippingNoteGenerator()

    @Test
    fun shouldGenerateShippingNoteWithAllInputFields() {

        val result = shippingNoteGenerator.generateShippingNote(
            "Jane",
            "Doe",

            "12 Baker Street",
            "Flat 4B",
            "London",
            "NW1 6XE",
            "UK",

            "ORD-123",
            "Wireless Headphones",
            2
        )

        assertTrue(result.contains("Order: ORD-123"))
        assertTrue(result.contains("Customer: Jane Doe"))
        assertTrue(result.contains("Item: Wireless Headphones"))
        assertTrue(result.contains("Quantity: 2"))

        assertTrue(result.contains("12 Baker Street"))
        assertTrue(result.contains("Flat 4B"))
        assertTrue(result.contains("London"))
        assertTrue(result.contains("NW1 6XE"))
        assertTrue(result.contains("UK"))
    }

    @Test
    fun shouldIncludeCustomerFullName() {

        val result = shippingNoteGenerator.generateShippingNote(
            "John",
            "Smith",

            "1 High Street",
            "Apt 2",
            "Manchester",
            "M1 2AB",
            "UK",

            "ORD-999",
            "Laptop",
            1
        )

        assertTrue(result.contains("Customer: John Smith"))
    }

    @Test
    fun shouldIncludeOrderIdAndItemDetails() {

        val result = shippingNoteGenerator.generateShippingNote(
            "Alice",
            "Brown",

            "50 King Street",
            "Unit 3",
            "Birmingham",
            "B1 1AA",
            "UK",

            "ORD-555",
            "Tablet",
            5
        )

        assertTrue(result.contains("Order: ORD-555"))
        assertTrue(result.contains("Item: Tablet"))
        assertTrue(result.contains("Quantity: 5"))
    }

    @Test
    fun shouldIncludeFullAddressAcrossAllFields() {

        val result = shippingNoteGenerator.generateShippingNote(
            "Emma",
            "Jones",

            "99 High Road",
            "Floor 2",
            "Leeds",
            "LS1 4AB",
            "UK",

            "ORD-777",
            "Monitor",
            3
        )

        assertTrue(result.contains("99 High Road"))
        assertTrue(result.contains("Floor 2"))
        assertTrue(result.contains("Leeds"))
        assertTrue(result.contains("LS1 4AB"))
        assertTrue(result.contains("UK"))
    }

    @Test
    fun shouldIncludeQuantityCorrectly() {

        val result = shippingNoteGenerator.generateShippingNote(
            "",
            "White",

            "10 Market Street",
            "",
            "Liverpool",
            "L1 8JQ",
            "UK",

            "ORD-321",
            "Keyboard",
            10
        )

        assertTrue(result.contains("Quantity: 10"))
    }
}
package com.codemanship.refactoring.longmethod

class Order(
    private val items: List<OrderItem>?,
    private val customer: Customer
) {

    fun summarise(): OrderSummary {

        // Validation
        val nonNullItems = items ?: throw IllegalStateException("Items cannot be null")
        if (nonNullItems.isEmpty()) {
            throw IllegalStateException("Order must contain items")
        }

        // Subtotal calculation
        var subtotal = 0.0
        for (item in nonNullItems) {
            subtotal += item.price * item.quantity
        }

        // Discount rules
        var discount = 0.0
        discount = when {
            customer.isLoyal() -> subtotal * 0.10
            subtotal > 100 -> subtotal * 0.05
            else -> 0.0
        }

        // Tax calculation
        val taxableAmount = subtotal - discount
        val tax = taxableAmount * 0.20

        // Total calculation
        val total = taxableAmount + tax

        return OrderSummary(subtotal, discount, tax, total)
    }
}

class Customer(
    private val loyal: Boolean
) {
    fun isLoyal(): Boolean = loyal
}

class OrderItem(
    val price: Double,
    val quantity: Double
)

class OrderSummary(
    val subtotal: Double,
    val discount: Double,
    val tax: Double,
    val total: Double
)
package com.codemanship.refactoring.longparameterlist

class ShippingNoteGenerator {

    fun generateShippingNote(
        customerFirstName: String,
        customerLastName: String,

        addressLine1: String,
        addressLine2: String?,

        city: String,
        postcode: String,
        country: String,

        orderId: String,
        itemDescription: String,
        quantity: Int
    ): String {

        val fullName = "$customerFirstName $customerLastName"

        val address = addressLine1 + ", " +
                (addressLine2?.let { "$it, " } ?: "") +
                city + ", " +
                postcode + ", " +
                country

        return "SHIPPING NOTE\n" +
                "Order: $orderId\n" +
                "Customer: $fullName\n" +
                "Ship To: $address\n" +
                "Item: $itemDescription\n" +
                "Quantity: $quantity"
    }
}
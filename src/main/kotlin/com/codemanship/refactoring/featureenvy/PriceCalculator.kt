package com.codemanship.refactoring.featureenvy

class PriceCalculator {

    fun calculateFinalPrice(product: Product): Double {
        var price = product.price

        if (product.isOnSale) {
            price *= 0.8
        }

        return price
    }
}

class Product(
    val price: Double,
    val isOnSale: Boolean
)
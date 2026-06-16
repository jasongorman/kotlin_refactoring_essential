package com.codemanship.refactoring.divergentchange

class CustomerService {

    fun isValidEmail(email: String?): Boolean {
        if (email == null) {
            return false
        }
        return email.matches(Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
    }

    fun formatDisplayName(firstName: String, lastName: String): String {
        return firstName.trim() + " " + lastName.trim().uppercase()
    }

    fun calculateLoyaltyPoints(numberOfPurchases: Int): Int {
        return numberOfPurchases * 10
    }

    fun determineAccountStatus(daysSinceLastLogin: Int): String {
        return when {
            daysSinceLastLogin > 365 -> "INACTIVE"
            daysSinceLastLogin > 30 -> "DORMANT"
            else -> "ACTIVE"
        }
    }
}
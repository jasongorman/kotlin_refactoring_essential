package com.codemanship.refactoring.divergentchange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CustomerServiceTest {

    private val service = CustomerService()

    // -------------------------
    // isValidEmail tests
    // -------------------------

    @Test
    fun isValidEmail_shouldReturnFalse_whenEmailIsNull() {
        assertFalse(service.isValidEmail(null))
    }

    @Test
    fun isValidEmail_shouldReturnFalse_whenEmailIsEmpty() {
        assertFalse(service.isValidEmail(""))
    }

    @Test
    fun isValidEmail_shouldReturnFalse_whenMissingAtSymbol() {
        assertFalse(service.isValidEmail("invalid.email.com"))
    }

    @Test
    fun isValidEmail_shouldReturnFalse_whenMissingLocalPart() {
        assertFalse(service.isValidEmail("@domain.com"))
    }

    @Test
    fun isValidEmail_shouldReturnFalse_whenMissingDomain() {
        assertFalse(service.isValidEmail("user@"))
    }

    @Test
    fun isValidEmail_shouldReturnTrue_whenEmailIsValid() {
        assertTrue(service.isValidEmail("user.name+tag@example.com"))
    }

    @Test
    fun isValidEmail_shouldReturnTrue_whenSimpleValidEmail() {
        assertTrue(service.isValidEmail("user@example.com"))
    }

    // -------------------------
    // formatDisplayName tests
    // -------------------------

    @Test
    fun formatDisplayName_shouldTrimAndUppercaseLastName() {
        val result = service.formatDisplayName(" John ", " smith ")
        assertEquals("John SMITH", result)
    }

    @Test
    fun formatDisplayName_shouldHandleEmptyStrings() {
        val result = service.formatDisplayName("", "")
        assertEquals(" ", result)
    }

    @Test
    fun formatDisplayName_shouldHandleSingleCharacterNames() {
        val result = service.formatDisplayName("A", "b")
        assertEquals("A B", result)
    }

    // -------------------------
    // calculateLoyaltyPoints tests
    // -------------------------

    @Test
    fun calculateLoyaltyPoints_shouldReturnZero_whenNoPurchases() {
        assertEquals(0, service.calculateLoyaltyPoints(0))
    }

    @Test
    fun calculateLoyaltyPoints_shouldCalculateCorrectly_forPositiveValues() {
        assertEquals(50, service.calculateLoyaltyPoints(5))
    }

    @Test
    fun calculateLoyaltyPoints_shouldHandleLargeNumbers() {
        assertEquals(100_000, service.calculateLoyaltyPoints(10_000))
    }

    @Test
    fun calculateLoyaltyPoints_shouldAllowNegativeValues_butStillMultiply() {
        assertEquals(-50, service.calculateLoyaltyPoints(-5))
    }

    // -------------------------
    // determineAccountStatus tests
    // -------------------------

    @Test
    fun determineAccountStatus_shouldReturnInactive_whenDaysOver365() {
        assertEquals("INACTIVE", service.determineAccountStatus(366))
    }

    @Test
    fun determineAccountStatus_shouldReturnDormant_whenBetween31And365() {
        assertEquals("DORMANT", service.determineAccountStatus(100))
    }

    @Test
    fun determineAccountStatus_shouldReturnActive_when30DaysOrLess() {
        assertEquals("ACTIVE", service.determineAccountStatus(30))
        assertEquals("ACTIVE", service.determineAccountStatus(0))
    }

    @Test
    fun determineAccountStatus_shouldTreatNegativeDaysAsActive() {
        assertEquals("ACTIVE", service.determineAccountStatus(-10))
    }
}
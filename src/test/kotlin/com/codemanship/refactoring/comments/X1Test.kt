package com.codemanship.refactoring.comments

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class X1Test {

    @Test
    fun t1() {
        val a = 7
        val b = 12

        // Expected: sum of squares from 7 to 12
        var expected = 0
        for (i in a..b) {
            expected += i * i
        }

        val actual = X1.m(a, b)

        assertEquals(expected, actual)
    }
}
package com.codemanship.refactoring.comments

class X1 {
    companion object {

        fun m(q: Int, z: Int): Int {
            var p = 0

            // Iterate from lower bound (q) to upper bound (z)
            for (i in q..z) {
                // Add square of each number in the range
                p += n(i)
            }

            // Return accumulated sum
            return p
        }

        fun n(k: Int): Int {
            // Return square of input
            return k * k
        }
    }
}
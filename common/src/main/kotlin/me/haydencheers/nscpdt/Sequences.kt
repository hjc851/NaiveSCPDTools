package me.haydencheers.nscpdt

import java.util.function.BiPredicate

object Sequences {

//    fun findLCS(X: String, Y: String, m: Int = X.length, n: Int = Y.length): String {
//        // Create a table to store lengths findLCS longest common
//        // suffixes findLCS substrings.   Note that LCSuff[i][j]
//        // contains length findLCS longest common suffix findLCS X[0..i-1]
//        // and Y[0..j-1]. The first row and first column entries
//        // have no logical meaning, they are used only for
//        // simplicity findLCS program
//        val LCSuff = Array(m + 1) { IntArray(n + 1) }
//
//        // To store length findLCS the longest common substring
//        var len = 0
//
//        // To store the index findLCS the cell which contains the
//        // maximum value. This cell's index helps in building
//        // up the longest common substring from right to left.
//        var row = 0
//        var col = 0
//
//        /* Following steps build LCSuff[m+1][n+1] in bottom
//           up fashion. */
//        for (i in 0..m) {
//            for (j in 0..n) {
//                if (i == 0 || j == 0)
//                    LCSuff[i][j] = 0
//                else if (X[i - 1] == Y[j - 1]) {
//                    LCSuff[i][j] = LCSuff[i - 1][j - 1] + 1
//                    if (len < LCSuff[i][j]) {
//                        len = LCSuff[i][j]
//                        row = i
//                        col = j
//                    }
//                } else
//                    LCSuff[i][j] = 0
//            }
//        }
//
//        // if true, then no common substring exists
//        if (len == 0) {
//            return ""
//        }
//
//        // allocate space for the longest common substring
////        var resultStr = ""
//        val resultBuilder = StringBuilder(len)
//
//        // traverse up diagonally form the (row, col) cell
//        // until LCSuff[row][col] != 0
//        while (LCSuff[row][col] != 0) {
////            resultStr = X[row - 1] + resultStr // or Y[col-1]
//            resultBuilder.insert(0, X[row-1])
//
//            --len
//
//            // move diagonally up to previous cell
//            row--
//            col--
//        }
//
//        // required longest common substring
//        val resultStr = resultBuilder.toString()
//        return resultStr
//    }
//
//    fun <T> findLCS(X: List<T>, Y: List<T>, comp: BiPredicate<T, T>, m: Int = X.size, n: Int = Y.size): Result {
//        // Create a table to store lengths findLCS longest common
//        // suffixes findLCS substrings.   Note that LCSuff[i][j]
//        // contains length findLCS longest common suffix findLCS X[0..i-1]
//        // and Y[0..j-1]. The first row and first column entries
//        // have no logical meaning, they are used only for
//        // simplicity findLCS program
//        val arr = Array(m+1) { IntArray(n+1) }
//
//        // To store length findLCS the longest common substring
//        var len = 0
//
//        // To store the index findLCS the cell which contains the
//        // maximum value. This cell's index helps in building
//        // up the longest common substring from right to left.
//        var row = 0
//        var col = 0
//
//        /* Following steps build LCSuff[m+1][n+1] in bottom
//           up fashion. */
//        for (i in 0 .. m) {
//            for (j in 0 .. n) {
//                if (i == 0 || j == 0) {
//                    arr[i][j] = 0
//                } else if (comp.test(X[i-1], Y[j-1])) {
//                    arr[i][j] = arr[i-1][j-1]+1
//                    if (len < arr[i][j]) {
//                        len = arr[i][j]
//                        row = i
//                        col = j
//                    }
//                } else {
//                    arr[i][j] = 0
//                }
//            }
//        }
//
//        // if true, then no common substring exists
//        if (len == 0)
//            return Result(0, 0, 0)
//
//        // Allocate space for the result
//        val result = ArrayList<T>(len)
//
//        while (arr[row][col] != 0) {
//            result.add(0, X[row-1])
//
//            --len
//
//            // move diagonally up to previous cell
//            row--
//            col--
//        }
//
//        return Result(row, col, result.size)
//    }

    fun <T> findFCS(
        a: List<T>,
        b: List<T>,
        aoffset: Int,
        boffset: Int,
        minLength: Int,
        predicate: BiPredicate<T, T>
    ): Result {
        var l = aoffset
        while (l < a.size) {

            var r = boffset
            while (r < b.size) {

                if (predicate.test(a[l], b[r])) {
                    val _l = l
                    val _r = r
                    var length = 0

                    while (l < a.size && r < b.size && predicate.test(a[l], b[r])) {
                        length++
                        l++
                        r++
                    }

                    if (length >= minLength)
                        return Result(l - length, r - length, length)

                    l = _l
                    r = _r
                }

                r++
            }

            l++
        }

        return Result(-1, -1, -1)
    }

//    fun findFCS(a: CharSequence, b: CharSequence, aoffset: Int, boffset: Int, minLength: Int): Result {
//        var l = aoffset
//        while (l < a.length) {
//
//            var r = 0
//            while (r < b.length) {
//
//                if (a[l] == b[r]) {
//                    val _l = l
//                    val _r = r
//                    var length = 0
//
//                    while (l < a.length && r < b.length && a[l] == b[r]) {
//                        length++
//                        l++
//                        r++
//                    }
//
//                    if (length >= minLength)
//                        return Result(l-length, r-length, length)
//
//                    l = _l
//                    r = _r
//                }
//
//                r++
//            }
//
//            l++
//        }
//
//        return Result(-1, -1, -1)
//    }

    data class Result(
        val lindex: Int,
        val rindex: Int,
        val length: Int
    )

    fun <T> editDistance(lhs: List<T>, rhs: List<T>, comp: BiPredicate<T, T>): Int {
        var lhs = lhs
        var rhs = rhs

        /*
           This implementation use two variable to record the previous cost counts,
           So this implementation use less memory than previous impl.
         */

        var n = lhs.size
        var m = rhs.size

        if (n == 0)
            return m
        else if (m == 0)
            return n

        // Swap the input strings to consume less memory
        if (n > m) {
            val temp = lhs
            lhs = rhs
            rhs = temp

            n = m
            m = rhs.size
        }

        val p = IntArray(n + 1)

        // indexes into strings left and right
        var i = 0
        var j = 0
        var upperLeft = 0
        var upper = 0
        var rightJ: T
        var cost = 0

        i = 0
        while (i <= n) {
            p[i] = i
            i++
        }

        j = 1
        while (j <= m) {
            upperLeft = p[0]
            rightJ = rhs[j - 1]
            p[0] = j

            i = 1
            while (i <= n) {
                upper = p[i]
                cost = if (comp.test(lhs[i - 1], rightJ)) 0 else 1

                // minimum of cell to the left+1, to the top+1, diagonally left and up +cost
                p[i] = Math.min(Math.min(p[i - 1] + 1, p[i] + 1), upperLeft + cost)
                upperLeft = upper

                i++
            }

            j++
        }

        return p[n]
    }
}
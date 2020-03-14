package me.haydencheers.nscpdt.token

import com.github.javaparser.Token
import me.haydencheers.nscpdt.Sequences

class TokenTilingSCPDT(val threshold: Int = 12): AbstractTokenSCPDT() {
    override fun compareTokenisedFiles(lhs: List<Token>, rhs: List<Token>): Double {
        var lsize = lhs.size
        var rsize = rhs.size
        var matched = 0

        var loffset = 0
        var roffset = 0

        while (loffset < lsize && roffset < rsize) {

            val lcs = Sequences.findFCS(lhs, rhs, loffset, roffset, threshold, TokenTypeBiPredicate)
            if (lcs.length >= threshold) {
                matched += lcs.length

                val lseq = lhs.subList(lcs.lindex, lcs.lindex+lcs.length)
                val rseq = rhs.subList(lcs.rindex, lcs.rindex+lcs.length)

                loffset = lcs.lindex + lcs.length + 1
                roffset = lcs.rindex + lcs.length + 1

            } else {
                break
            }
        }

        val sim = ((2.0 * matched) / (lsize + rsize))
        return sim
    }
}
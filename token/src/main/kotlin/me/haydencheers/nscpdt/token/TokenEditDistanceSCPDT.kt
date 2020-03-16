package me.haydencheers.nscpdt.token

import com.github.javaparser.Token
import me.haydencheers.nscpdt.Sequences
import kotlin.math.max

class TokenEditDistanceSCPDT : AbstractTokenSCPDT() {

    override fun compareFileRepresentations(lhs: List<Token>, rhs: List<Token>): Double {
        val distance = Sequences.editDistance(lhs, rhs, TokenTypeBiPredicate)

        val lsize = lhs.size
        val rsize = rhs.size

        val maxSize = max(lsize, rsize).toDouble()
        val sim = 1 - (distance / maxSize)

        return sim
    }
}
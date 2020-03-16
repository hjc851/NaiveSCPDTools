package me.haydencheers.nscpdt.string

import org.apache.commons.text.similarity.LevenshteinDistance
import kotlin.math.max

class StringEditDistanceSCPDT : AbstractStringSCPDT() {

    private val lev = LevenshteinDistance()

    override fun compareFileRepresentations(lhs: CharSequence, rhs: CharSequence): Double {
        val distance = lev.apply(lhs, rhs)

        val lsize = lhs.length
        val rsize = rhs.length

        val maxSize = max(lsize, rsize).toDouble()
        val sim = 1 - (distance / maxSize)

        return sim
    }
}
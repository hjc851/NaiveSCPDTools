package me.haydencheers.nscpdt.string

import org.apache.commons.text.similarity.LevenshteinDistance
import kotlin.math.max

class StringEditDistanceSCPDT: AbstractStringSCPDT() {
    override fun compareFiles(lstr: CharSequence, rstr: CharSequence): Double {
        val lev = LevenshteinDistance()
        val distance = lev.apply(lstr, rstr)

        val lsize = lstr.length
        val rsize = rstr.length

        val maxSize = max(lsize, rsize).toDouble()
        val sim = 1 - (distance / maxSize)

        return sim
    }
}
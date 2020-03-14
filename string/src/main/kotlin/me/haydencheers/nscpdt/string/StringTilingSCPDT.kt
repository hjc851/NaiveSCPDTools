package me.haydencheers.nscpdt.string

import me.haydencheers.nscpdt.Sequences
import me.haydencheers.nscpdt.string.charutil.CharBiPredicate
import me.haydencheers.nscpdt.string.charutil.CharSequenceListAdapter

class StringTilingSCPDT(val threshold: Int = 20): AbstractStringSCPDT() {
    override fun compareFiles(lstr: CharSequence, rstr: CharSequence): Double {

        var lsize = lstr.length
        var rsize = rstr.length
        var matched = 0

        var loffset = 0
        var roffset = 0

        val ladapter = CharSequenceListAdapter(lstr)
        val radapter = CharSequenceListAdapter(rstr)

        while (loffset < lsize && roffset < rsize) {

            val lcs = Sequences.findFCS(ladapter, radapter, loffset, roffset, threshold, CharBiPredicate)
            if (lcs.length >= threshold) {
                matched += lcs.length

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


package me.haydencheers.nscpdt.token

import com.github.javaparser.Token
import me.haydencheers.nscpdt.NaiveSCPDT
import me.haydencheers.nscpdt.ProjectListing
import me.haydencheers.nscpdt.common.HungarianAlgorithm
import java.nio.file.Path
import kotlin.math.max

abstract class AbstractTokenSCPDT: NaiveSCPDT {
    override fun evaluateSimilarity(ldir: Path, rdir: Path): Double {
        val lsub = ProjectListing.makeListing(ldir, ".java")
        val rsub = ProjectListing.makeListing(rdir, ".java")

        if (lsub.sources.isEmpty()) return 0.0
        if (rsub.sources.isEmpty()) return 0.0

        val similarities = mutableMapOf<Path, MutableMap<Path, Double>>()

        for (lfile in lsub.sources) {
            val ltokens = Tokeniser.tokenise(lfile)

            for (rfile in rsub.sources) {
                val rtokens = Tokeniser.tokenise(rfile)

                val sim = compareTokenisedFiles(ltokens, rtokens)
                similarities.getOrPut(lfile) { mutableMapOf() }
                    .put(rfile, sim)
            }
        }

        val simArr = Array(lsub.sources.size) { DoubleArray(rsub.sources.size) { 100.0 } }
        for (l in 0 until lsub.sources.size) {
            val lpath = lsub.sources[l]

            for (r in 0 until rsub.sources.size) {
                val rpath = rsub.sources[r]

                val sim = similarities.getValue(lpath).getValue(rpath)
                simArr[l][r] = 100.0 - sim
            }
        }

        val hung = HungarianAlgorithm(simArr)
        val matches = hung.execute()

        val bestMatches = mutableListOf<Triple<Path, Path, Double>>()
        matches.forEachIndexed { lindex, rindex ->
            if (rindex != -1) {
                val lsrc = lsub.sources[lindex]
                val rsrc = rsub.sources[rindex]
                val sim = 100.0 - simArr[lindex][rindex]

                bestMatches.add(Triple(lsrc, rsrc, sim))
            }
        }

        val maxFileCount = max(lsub.sources.size, rsub.sources.size)
        val sim = bestMatches.map { it.third }
            .toTypedArray()
            .copyOf(maxFileCount)
            .map { it ?: 0.0 }
            .average()

        return sim
    }

    protected abstract fun compareTokenisedFiles(lhs: List<Token>, rhs: List<Token>): Double
}
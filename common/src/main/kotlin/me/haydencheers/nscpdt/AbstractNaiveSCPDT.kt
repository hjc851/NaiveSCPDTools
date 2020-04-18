package me.haydencheers.nscpdt

import java.nio.file.Path
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Semaphore

abstract class AbstractNaiveSCPDT<T> : NaiveSCPDT {

    protected abstract fun transformFile(path: Path): T
    protected abstract fun fallbackValueForFile(path: Path): T
    protected abstract fun compareFileRepresentations(lhs: T, rhs: T): Double

    override fun evaluateSimilarity(ldir: Path, rdir: Path): Double {
        val lsub = ProjectListing.makeListing(ldir, ".java")
        val rsub = ProjectListing.makeListing(rdir, ".java")

        if (lsub.sources.isEmpty()) return 0.0
        if (rsub.sources.isEmpty()) return 0.0

        val similarities = mutableMapOf<Path, MutableMap<Path, Double>>()

        val lreps = lsub.sources.map { it to safeTransformFile(it) }
        val rreps = rsub.sources.map { it to safeTransformFile(it) }

        for ((lfile, lrep) in lreps) {
            for ((rfile, rrep) in rreps) {
                val sim = compareFileRepresentations(lrep, rrep)
                similarities.getOrPut(lfile) { mutableMapOf() }[rfile] = sim
                similarities.getOrPut(rfile) { mutableMapOf() }[lfile] = sim
            }
        }

        val lsize = lsub.sources.size
        val rsize = rsub.sources.size

        val lScores = similarities.filter { lsub.sources.contains(it.key) }
        val rScores = similarities.filter { rsub.sources.contains(it.key) }

        val lAvgSim = lScores.map { (lfile, scores) ->
            scores.maxBy { it.value }?.value ?: 0.0
        }.average()

        val rAvgSim = rScores.map { (rfile, scores) ->
            scores.maxBy { it.value }?.value ?: 0.0
        }.average()

        val sim = (lsize * lAvgSim + rsize * rAvgSim) / (lsize + rsize)
        return sim
    }

    override fun evaluateFileSimilarities(ldir: Path, rdir: Path): List<Triple<Path, Path, Double>> {
        val lsub = ProjectListing.makeListing(ldir, ".java")
        val rsub = ProjectListing.makeListing(rdir, ".java")

        if (lsub.sources.isEmpty()) return emptyList()
        if (rsub.sources.isEmpty()) return emptyList()

        val lreps = lsub.sources.map { it to safeTransformFile(it) }
        val rreps = rsub.sources.map { it to safeTransformFile(it) }

        val similarities = mutableListOf<Triple<Path, Path, Double>>()

        for ((lfile, lrep) in lreps) {
            for ((rfile, rrep) in rreps) {
                val sim = compareFileRepresentations(lrep, rrep)
                similarities.add(Triple(lfile, rfile, sim))
            }
        }

        return similarities
    }

    private fun safeTransformFile(path: Path): T {
        return try {
            transformFile(path)
        } catch (e: Exception) {
            e.printStackTrace()
            fallbackValueForFile(path)
        }
    }
}
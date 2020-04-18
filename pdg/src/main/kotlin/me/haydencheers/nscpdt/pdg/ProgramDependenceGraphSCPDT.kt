package me.haydencheers.nscpdt.pdg

import me.haydencheers.nscpdt.common.HungarianAlgorithm
import me.haydencheers.nscpdt.pdg.util.GraphEditDistanceEvaluator
import org.graphstream.graph.Graph
import java.nio.file.Path
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Semaphore
import kotlin.math.max

class ProgramDependenceGraphSCPDT: AbstractDependenceGraphSCPDT() {
    override fun compareFileRepresentations(lhs: List<Graph>, rhs: List<Graph>): Double {

        if (lhs.isEmpty() || rhs.isEmpty()) return 0.0

        val similarities = Array(lhs.size) { DoubleArray(rhs.size) { 1.0 } }

        val count = lhs.size * rhs.size
        val sem = Semaphore(count)

        for (l in 0 until lhs.size) {
            val lg = lhs[l]
            for (r in 0 until rhs.size) {
                sem.acquire()

                CompletableFuture.runAsync {
                    val rg = rhs[r]
                    val distance = GraphEditDistanceEvaluator.evaluate(lg, rg)
                    val maxSize = max(lg.nodeCount + lg.edgeCount, rg.nodeCount + rg.edgeCount)

                    val sim = 1 - (distance/ maxSize)
                    similarities[l][r] = 1.0 - sim
                }.whenComplete { void, throwable ->
                    throwable?.printStackTrace()
                    sem.release()
                }
            }
        }

        sem.acquire(count)

        val hung = HungarianAlgorithm(similarities)
        val matches = hung.execute()

        val bestMatches = mutableListOf<Triple<Graph, Graph, Double>>()
        matches.forEachIndexed { lindex, rindex ->
            if (rindex != -1) {
                val lsrc = lhs[lindex]
                val rsrc = rhs[rindex]
                val sim = 1.0 - similarities[lindex][rindex]

                bestMatches.add(Triple(lsrc, rsrc, sim))
            }
        }

        val maxGraphCount = max(lhs.size, rhs.size)
        val sim = bestMatches.map { it.third }
            .toTypedArray()
            .copyOf(maxGraphCount)
            .map { it ?: 0.0 }
            .average()

        return sim
    }
}
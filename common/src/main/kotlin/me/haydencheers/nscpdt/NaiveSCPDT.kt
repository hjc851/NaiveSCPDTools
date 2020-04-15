package me.haydencheers.nscpdt

import java.nio.file.Path

interface NaiveSCPDT {
    fun evaluateSimilarity(ldir: Path, rdir: Path): Double
    fun evaluateFileSimilarities(ldir: Path, rdir: Path): List<Triple<Path, Path, Double>>
}
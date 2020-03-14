package me.haydencheers.nscpdt

import java.nio.file.Path

interface NaiveSCPDT {
    fun evaluateSimilarity(ldir: Path, rdir: Path): Double
}
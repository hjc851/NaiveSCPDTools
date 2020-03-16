package me.haydencheers.nscpdt.pdg

import com.github.javaparser.JavaParser
import me.haydencheers.nscpdt.AbstractNaiveSCPDT
import me.haydencheers.nscpdt.pdg.util.ASTUtil
import me.haydencheers.nscpdt.pdg.util.PDGBuilder
import org.graphstream.graph.Graph
import java.nio.charset.Charset
import java.nio.file.Path

abstract class AbstractDependenceGraphSCPDT : AbstractNaiveSCPDT<List<Graph>>() {

    override fun transformFile(path: Path): List<Graph> {
        val parser = JavaParser()
        parser.parserConfiguration.characterEncoding = Charset.forName("ISO-8859-1")

        val cures = parser.parse(path)
        if (cures.result.isPresent) {
            val cu = cures.result.get()
            val callables = ASTUtil.collectAllCallables(cu)

            return callables.map { PDGBuilder.build(it) }
        }

        return emptyList()
    }

    override fun fallbackValueForFile(path: Path): List<Graph> {
        return emptyList()
    }
}
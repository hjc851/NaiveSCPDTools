package me.haydencheers.nscpdt.tree

import com.github.javaparser.JavaParser
import eu.mihosoft.ext.apted.node.Node
import eu.mihosoft.ext.apted.node.StringNodeData
import eu.mihosoft.ext.apted.parser.BracketStringInputParser
import me.haydencheers.nscpdt.AbstractNaiveSCPDT
import java.nio.charset.Charset
import java.nio.file.Path

abstract class AbstractTreeSCPDT: AbstractNaiveSCPDT<Node<StringNodeData>>() {

    val bsparser = BracketStringInputParser()

    override fun transformFile(path: Path): Node<StringNodeData> {
        val jparser = JavaParser()
        jparser.parserConfiguration.characterEncoding = Charset.forName("ISO-8859-1")

        val result = jparser.parse(path)
        if (result.result.isPresent) {
            val cu = result.result.get()
            val stree = NodeBracketedStringTransformer.transform(cu)
            val rootnode = bsparser.fromString(stree)
            return rootnode
        }
        val problems = result.problems
        throw IllegalStateException("Error parsing file")
    }

    override fun fallbackValueForFile(path: Path): Node<StringNodeData> {
        return bsparser.fromString("{}")
    }
}
package me.haydencheers.nscpdt.tree

import com.github.javaparser.ast.CompilationUnit
import eu.mihosoft.ext.apted.costmodel.StringUnitCostModel
import eu.mihosoft.ext.apted.distance.APTED
import eu.mihosoft.ext.apted.node.Node
import eu.mihosoft.ext.apted.node.StringNodeData
import eu.mihosoft.ext.apted.parser.BracketStringInputParser
import eu.mihosoft.ext.apted.parser.InputParser
import kotlin.math.max

class TreeEditDistanceSCPDT: AbstractTreeSCPDT() {

    private val bscostmodel = StringUnitCostModel()

    override fun compareFileRepresentations(lhs: Node<StringNodeData>, rhs: Node<StringNodeData>): Double {
        val apted = APTED<StringUnitCostModel, StringNodeData>(bscostmodel)
        val distance = apted.computeEditDistance(lhs, rhs)

        val lsize = lhs.nodeCount
        val rsize = rhs.nodeCount

        val maxSize = max(lsize, rsize).toDouble()
        val sim = 1 - (distance / maxSize)

        return sim
    }
}
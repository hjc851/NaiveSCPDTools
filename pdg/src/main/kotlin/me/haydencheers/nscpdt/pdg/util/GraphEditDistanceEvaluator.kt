package me.haydencheers.nscpdt.pdg.util

import com.automation.graph.HungarianAlgorithm
import org.graphstream.graph.Edge
import org.graphstream.graph.Graph
import org.graphstream.graph.Node

object GraphEditDistanceEvaluator {
    fun evaluate(g1: Graph, g2: Graph) = evaluate(g1, g2, 3.0, 1.0, 1.0)

    fun evaluate(g1: Graph, g2: Graph, subCost: Double, insCost: Double, delCost: Double): Double {
        val n = g1.nodeCount
        val m = g2.nodeCount
        val costMatrix = Array(n+m) { DoubleArray(n+m) }

        for (i in 0 until n) {
            for (j in 0 until m) {
                costMatrix[i][j] = getSubstituteCost(g1.getNode<Node>(i), g2.getNode<Node>(j), subCost, insCost, delCost)
            }
        }

        for (i in 0 until m) {
            for (j in 0 until m) {
                costMatrix[i + n][j] = getInsertCost(i, j, insCost)
            }
        }

        for (i in 0 until n) {
            for (j in 0 until n) {
                costMatrix[j][i + m] = getDeleteCost(i, j, delCost)
            }
        }


        val assignment = HungarianAlgorithm.hgAlgorithm(costMatrix, "min")

        var sum = 0.0
        for (i in 0 until assignment.size) {
            sum += costMatrix[assignment[i][0]][assignment[i][1]]
        }

        return sum
    }

    private fun getSubstituteCost(node1: Node, node2: Node, subCost: Double, insCost: Double, delCost: Double): Double {
        val diff = getRelabelCost(node1, node2, subCost) + getEdgeDiff(node1, node2, insCost, subCost, delCost)
        return diff * subCost
    }

    private fun getRelabelCost(node1: Node, node2: Node, subCost: Double): Double {
        return if (!equals(node1, node2)) subCost
        else 0.0
    }

    private fun getEdgeDiff(node1: Node, node2: Node, insCost: Double, subCost: Double, delCost: Double): Double {
        val edges1 = node1.getEdgeSet<Edge>().toTypedArray()
        val edges2 = node2.getEdgeSet<Edge>().toTypedArray()

        if (edges1.size == 0 || edges2.size == 0) {
            return Math.max(edges1.size, edges2.size).toDouble()
        }

        val n = edges1.size
        val m = edges2.size
        val edgeCostMatrix = Array(n + m) { DoubleArray(m + n) }

        for (i in 0 until n) {
            for (j in 0 until m) {
                edgeCostMatrix[i][j] = getEdgeEditCost(edges1[i], edges2[j], subCost)
            }
        }

        for (i in 0 until m) {
            for (j in 0 until m) {
                edgeCostMatrix[i + n][j] = getEdgeInsertCost(i, j, insCost)
            }
        }

        for (i in 0 until n) {
            for (j in 0 until n) {
                edgeCostMatrix[j][i + m] = getEdgeDeleteCost(i, j, delCost)
            }
        }

        val assignment = HungarianAlgorithm.hgAlgorithm(edgeCostMatrix, "min")
        var sum = 0.0
        for (i in assignment.indices) {
            sum += edgeCostMatrix[assignment[i][0]][assignment[i][1]]
        }

        return sum / (n + m)
    }

    private fun getEdgeEditCost(edge1: Edge, edge2: Edge, subCost: Double): Double {
        return (if (equals(edge1, edge2)) 0.0 else subCost)
    }

    private fun getEdgeInsertCost(i: Int, j: Int, insCost: Double): Double {
        return if (i == j) {
            insCost
        } else java.lang.Double.MAX_VALUE
    }

    private fun getEdgeDeleteCost(i: Int, j: Int, delCost: Double): Double {
        return if (i == j) {
            delCost
        } else java.lang.Double.MAX_VALUE
    }

    private fun getInsertCost(i: Int, j: Int, insCost: Double): Double {
        return if (i == j) {
            insCost
        } else java.lang.Double.MAX_VALUE
    }

    private fun getDeleteCost(i: Int, j: Int, delCost: Double): Double {
        return if (i == j) {
            delCost
        } else java.lang.Double.MAX_VALUE
    }

    //
    //  Element Equals
    //

    fun equals(lhs: Node, rhs: Node): Boolean {
        val ltype = lhs.getAttribute<String>("type")
        val lvarscope = lhs.getAttribute<String>("pdg.varscope")
        val lnodetype = lhs.getAttribute<String>("pdg.nodetype")

        val rtype = rhs.getAttribute<String>("type")
        val rvarscope = rhs.getAttribute<String>("pdg.varscope")
        val rnodetype = rhs.getAttribute<String>("pdg.nodetype")

        return ltype == rtype &&
                lvarscope == rvarscope &&
                lnodetype == rnodetype
    }

    fun equals(lhs: Edge, rhs: Edge): Boolean {
        val ltype = lhs.getAttribute<String>("type")
        val lsnoderef = lhs.getAttribute<String>("pdg.snoderef")
        val lfnoderef = lhs.getAttribute<String>("pdg.fnoderef")

        val rtype = rhs.getAttribute<String>("type")
        val rsnoderef = rhs.getAttribute<String>("pdg.snoderef")
        val rfnoderef = rhs.getAttribute<String>("pdg.fnoderef")

        return ltype == rtype &&
                lsnoderef == rsnoderef &&
                lfnoderef == rfnoderef
    }
}
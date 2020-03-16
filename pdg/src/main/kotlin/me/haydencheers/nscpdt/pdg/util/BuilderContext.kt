package me.haydencheers.nscpdt.pdg.util

import com.github.javaparser.ast.body.CallableDeclaration
import org.graphstream.graph.Edge
import org.graphstream.graph.Node
import org.graphstream.graph.implementations.MultiGraph
import java.util.*
import com.github.javaparser.ast.Node as ASTNode

val CONTROL = "CONTROL"
val DATA = "DATA"

val STMTEXPR = "STMTEXPR"

class BuilderContext {
    val graph = MultiGraph("PDG")

    lateinit var lastControlNode: Node

    private var counter = 0
    private fun makeid(): String = (counter++).toString()

    private val globalScope = Scope()
    private val scopes = Stack<Scope>()

    fun makeRootNode(sig: CallableDeclaration.Signature): Node {
        val node = graph.addNode<Node>(makeid())
        node.setAttribute("ui.label", sig.toString())
        return node
    }

    fun declareLocal(nameAsString: String): Node {
        val variable =
            Variable(nameAsString, VariableScope.LOCAL)
        val node = makeNodeForVariable(variable)
        scopes.peek().lookupTable[nameAsString] =
                VariableHolder(variable, node.id)
        return node
    }

    fun makeControlDependency(from: Node, to: Node): Edge {
        val edge = graph.addEdge<Edge>(makeid(), from, to, true)
        edge.setAttribute("ui.class", CONTROL)

        edge.setAttribute("type", CONTROL)
        edge.setAttribute("pdg.snoderef", from.getAttribute<String>("edgeref"))
        edge.setAttribute("pdg.fnoderef", to.getAttribute<String>("edgeref"))

        return edge
    }

    fun makeDataDependency(from: Node, to: Node): Edge {
        val edge = graph.addEdge<Edge>(makeid(), from, to, true)
        edge.setAttribute("ui.class", DATA)

        edge.setAttribute("type", DATA)
        edge.setAttribute("pdg.snoderef", from.getAttribute<String>("edgeref"))
        edge.setAttribute("pdg.fnoderef", to.getAttribute<String>("edgeref"))

        return edge
    }

    fun pushScope() {
        scopes.push(Scope())
    }

    fun popScope() {
        scopes.pop()
    }

    fun lookupOrCreateVariableByName(name: String): VariableHolder {
        for (scope in scopes.asReversed()) {
            if (scope.lookupTable.containsKey(name)) {
                val varHolder = scope.lookupTable[name]!!
                return varHolder
            }
        }

        if (!globalScope.lookupTable.containsKey(name)) {
            val variable = Variable(name, VariableScope.EXTERNAL)
            val node = makeNodeForVariable(variable)
            val root = graph.getNode<Node>("0")
            makeControlDependency(root, node)
            globalScope.lookupTable[name] = VariableHolder(variable, node.id)
        }

        return globalScope.lookupTable[name]!!
    }

    class Scope {
        val lookupTable = mutableMapOf<String, VariableHolder>()
    }

    class VariableHolder (
        val variable: Variable,
        var currentNodeId: String
    )

    private fun makeNodeForVariable(variable: Variable): Node {
        val node = graph.addNode<Node>(makeid())
        node.setAttribute("ui.label", variable.name)
        node.setAttribute("ui.class", variable.scope.name)
        node.setAttribute("type", "varnode")
        node.setAttribute("pdg.varscope", variable.scope.name)
        node.setAttribute("edgeref", "varnode-${variable.scope.name}")
        return node
    }

    private val nodeLookup = Hashtable<Any, Node>()
    fun getGraphNodeForTreeNode(astnode: ASTNode, label: String? = null): Node {
        val label = label ?: astnode.toString()
        if (!nodeLookup.contains(astnode)) {
            val node = graph.addNode<Node>(makeid())
            node.setAttribute("ui.class", STMTEXPR)
            node.setAttribute("ui.label", label)

            node.setAttribute("type", "stmtnode")
            node.setAttribute("pdg.nodetype", astnode.javaClass.name)
            node.setAttribute("edgeref", "stmtnode-${astnode.javaClass.name}")

            nodeLookup[astnode] = node
        }

        return nodeLookup[astnode]!!
    }

    fun getGraphNodeForVariable(variable: Variable): Node {
        val varholder = lookupOrCreateVariableByName(variable.name)
        try {
            return graph.getNode(varholder.currentNodeId)
        } catch (e: Exception) {
            throw e
        }
    }
}
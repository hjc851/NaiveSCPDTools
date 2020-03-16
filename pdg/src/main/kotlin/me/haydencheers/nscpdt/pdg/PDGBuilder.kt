package me.haydencheers.nscpdt.pdg

import com.github.javaparser.ast.body.*
import org.graphstream.graph.Graph

object PDGBuilder {
    fun build(method: MethodDeclaration): Graph {
        val ctx = BuilderContext()
        method.accept(PDGVisitor, ctx)
        return ctx.graph
    }

    fun build(constructor: ConstructorDeclaration): Graph {
        val ctx = BuilderContext()
        constructor.accept(PDGVisitor, ctx)
        return ctx.graph
    }
}
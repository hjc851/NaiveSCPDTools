package me.haydencheers.nscpdt.pdg.util

import com.github.javaparser.ast.body.CallableDeclaration
import org.graphstream.graph.Graph

object PDGBuilder {
    fun build(method: CallableDeclaration<*>): Graph {
        val ctx = BuilderContext()
        method.accept(PDGVisitor, ctx)
        return ctx.graph
    }

}
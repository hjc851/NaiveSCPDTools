package me.haydencheers.nscpdt.pdg

import com.github.javaparser.ast.body.CallableDeclaration
import me.haydencheers.nscpdt.pdg.util.BuilderContext
import me.haydencheers.nscpdt.pdg.util.PDGVisitor
import org.graphstream.graph.Graph

object PDGBuilder {
    fun build(method: CallableDeclaration<*>): Graph {
        val ctx = BuilderContext()
        method.accept(PDGVisitor, ctx)
        return ctx.graph
    }

}
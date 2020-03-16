package me.haydencheers.nscpdt.pdg.util

import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.body.CallableDeclaration
import com.github.javaparser.ast.body.TypeDeclaration
import java.util.*

object ASTUtil {
    fun collectTypes(cu: CompilationUnit): List<TypeDeclaration<*>> {
        val toCheck = Stack<TypeDeclaration<*>>()
        val types = mutableListOf<TypeDeclaration<*>>()

        toCheck.addAll(cu.types)
        types.addAll(cu.types)

        while (toCheck.isNotEmpty()) {
            val type = toCheck.pop()

            val itypes = type.members.filterIsInstance<TypeDeclaration<*>>()
            toCheck.addAll(itypes)
            types.addAll(itypes)
        }

        return types
    }

    fun collectCallables(type: TypeDeclaration<*>): List<CallableDeclaration<*>> {
        return type.constructors + type.methods
    }

    fun collectAllCallables(cu: CompilationUnit): List<CallableDeclaration<*>> {
        return collectTypes(cu)
            .flatMap { collectCallables(it) }
    }
}
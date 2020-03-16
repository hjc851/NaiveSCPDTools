package me.haydencheers.nscpdt.pdg.util

class Variable(
    val name: String,
    val scope: VariableScope
)

enum class VariableScope {
    LOCAL,
    EXTERNAL,
    COMPUTED
}
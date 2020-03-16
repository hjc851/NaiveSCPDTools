package me.haydencheers.nscpdt.pdg

class Variable (
    val name: String,
    val scope: VariableScope
)

enum class VariableScope {
    LOCAL,
    EXTERNAL,
    COMPUTED
}
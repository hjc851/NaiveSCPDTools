package me.haydencheers.nscpdt.token

import com.github.javaparser.Token
import java.util.function.BiPredicate

object TokenTypeBiPredicate : BiPredicate<Token, Token> {
    override fun test(p0: Token, p1: Token): Boolean {
        return p0.kind == p1.kind
    }
}
package me.haydencheers.nscpdt.string.charutil

import java.util.function.BiPredicate

object CharBiPredicate: BiPredicate<Char, Char> {
    override fun test(p0: Char, p1: Char): Boolean {
        return p0 == p1
    }
}
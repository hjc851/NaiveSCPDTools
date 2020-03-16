package me.haydencheers.nscpdt.token

import com.github.javaparser.Token
import me.haydencheers.nscpdt.AbstractNaiveSCPDT
import java.nio.file.Path

abstract class AbstractTokenSCPDT : AbstractNaiveSCPDT<List<Token>>() {

    override fun transformFile(path: Path): List<Token> {
        return Tokeniser.tokenise(path)
    }

    override fun fallbackValueForFile(path: Path): List<Token> {
        return emptyList()
    }
}
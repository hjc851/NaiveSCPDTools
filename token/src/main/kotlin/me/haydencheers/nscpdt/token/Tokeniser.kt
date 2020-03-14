package me.haydencheers.nscpdt.token

import com.github.javaparser.*
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path

object Tokeniser {
    fun tokenise(file: Path): List<Token> {
        Files.newBufferedReader(file, Charset.forName("ISO-8859-1")).use { reader ->
            val provider = StreamProvider(reader)
            val cs = SimpleCharStream(provider)
            val tm = GeneratedJavaParserTokenManager(cs)

            val tokens = mutableListOf<Token>()

            while (true) {
                val nt = tm.nextToken
                if (nt.kind == GeneratedJavaParserConstants.EOF) break
                tokens.add(nt)
            }

            return tokens
        }
    }
}
package me.haydencheers.nscpdt.string

import me.haydencheers.nscpdt.AbstractNaiveSCPDT
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path

abstract class AbstractStringSCPDT : AbstractNaiveSCPDT<CharSequence>() {

    override fun transformFile(path: Path): CharSequence {
        val lstr = StringBuilder(Files.size(path).toInt())
        Files.newBufferedReader(path, Charset.forName("ISO-8859-1"))
            .lines()
            .use { it.forEach { lstr.appendln(it) } }
        return lstr
    }

    override fun fallbackValueForFile(path: Path): CharSequence {
        return ""
    }
}
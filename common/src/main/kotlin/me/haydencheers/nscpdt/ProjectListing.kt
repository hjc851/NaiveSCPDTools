package me.haydencheers.nscpdt

import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path
import kotlin.streams.toList

data class ProjectListing (
    val root: Path,
    val sources: List<Path>
) {
    companion object {
        fun makeListing(root: Path, ext: String): ProjectListing {
            val matcher = FileSystems.getDefault().getPathMatcher("glob:*$ext")
            val sources = Files.walk(root)
                .filter { Files.isRegularFile(it) }
                .filter { matcher.matches(it.fileName) }
                .use { it.toList() }

            return ProjectListing(root, sources)
        }
    }
}
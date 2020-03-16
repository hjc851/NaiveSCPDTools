import com.github.javaparser.JavaParser
import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.body.*
import me.haydencheers.nscpdt.ProjectListing
import me.haydencheers.nscpdt.pdg.PDGBuilder
import org.junit.Test
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import kotlin.streams.toList

class PDGTest {

    val root = Paths.get("/Users/haydencheers/Desktop/PhD/Data Sets/SENG1110A12017/All")

    @Test
    fun test() {
        val submissions = Files.list(root)
            .filter { Files.isDirectory(it) && !Files.isHidden(it) }
            .map { ProjectListing.makeListing(it, ".java") }
            .use { it.toList() }

        val parser = JavaParser()
        parser.parserConfiguration.characterEncoding = Charset.forName("ISO-8859-1")

        for (sub in submissions) {
            for (file in sub.sources) {
                val cures = parser.parse(file)
                if (cures.result.isPresent) {
                    val cu = cures.result.get()
                    val types = findAllTypes(cu)

                    for (type in types) {

                        for (constructor in type.constructors) {
                            val graph = PDGBuilder.build(constructor)
                            Unit
                        }

                        for (method in type.methods) {
                            val graph = PDGBuilder.build(method)
                            Unit
                        }
                    }

                } else {
                    System.err.println("Cannot parse $file")
                }
            }
        }
    }

    fun findAllTypes(cu: CompilationUnit): List<TypeDeclaration<*>> {
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
}
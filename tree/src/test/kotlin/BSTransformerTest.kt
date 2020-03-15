import com.github.javaparser.JavaParser
import eu.mihosoft.ext.apted.parser.BracketStringInputParser
import me.haydencheers.nscpdt.ProjectListing
import me.haydencheers.nscpdt.tree.NodeBracketedStringTransformer
import org.junit.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.streams.toList

class BSTransformerTest {
    @Test
    fun test() {
        val root = Paths.get("/home/haydencheers/Desktop/PhD Data Sets/COMP2240 2018 A1 A2 A3/COMP2240_18_A1_Dataset")
        val submissions = Files.list(root)
            .filter { Files.isDirectory(it) }
            .use { it.toList() }

        val parser = JavaParser()
        val bsparser = BracketStringInputParser()

        for (submission in submissions) {
            val listing = ProjectListing.makeListing(submission, ".java")
            for (file in listing.sources) {
                val cu = parser.parse(file).result.get()
                val tstr = NodeBracketedStringTransformer.transform(cu)
                val n = bsparser.fromString(tstr)
                println(tstr)
            }
        }
    }
}
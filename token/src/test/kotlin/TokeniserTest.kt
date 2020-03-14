import me.haydencheers.nscpdt.ProjectListing
import me.haydencheers.nscpdt.token.Tokeniser
import org.junit.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.streams.toList

class TokeniserTest {
    @Test
    fun test() {
        val root = Paths.get("/home/haydencheers/Desktop/PhD Data Sets/COMP2240 2018 A1 A2 A3/COMP2240_18_A1_Dataset")
        val submissions = Files.list(root)
            .filter { Files.isDirectory(it) }
            .use { it.toList() }

        for (submission in submissions) {
            val listing = ProjectListing.makeListing(submission, ".java")
            for (file in listing.sources) {
                val tokens = Tokeniser.tokenise(file)
            }
        }

    }
}
import me.haydencheers.nscpdt.ProjectListing
import org.junit.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.streams.toList

class ProjectListingTest {
    @Test
    fun test() {
        val root = Paths.get("/home/haydencheers/Desktop/PhD Data Sets/COMP2240 2018 A1 A2 A3/COMP2240_18_A1_Dataset")
        val submissions = Files.list(root)
            .filter { Files.isDirectory(it) }
            .use { it.toList() }

        val listings = submissions.map { ProjectListing.makeListing(it, ".java") }
    }
}
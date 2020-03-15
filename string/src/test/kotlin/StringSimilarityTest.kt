import me.haydencheers.nscpdt.string.StringEditDistanceSCPDT
import me.haydencheers.nscpdt.string.StringTilingSCPDT
import org.junit.Test
import java.nio.file.Files
import java.nio.file.Paths
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Semaphore
import java.util.concurrent.TimeUnit
import kotlin.streams.toList

class StringSimilarityTest: AbstractNaiveSCPDTTestCase() {

    val root = Paths.get("/home/haydencheers/Desktop/PhD Data Sets/SENG1110A12017_Seeded/All")
//        val root = Paths.get("/home/haydencheers/Desktop/PhD Data Sets/COMP2240 2018 A1 A2 A3/COMP2240_18_A1_Dataset")

    @Test
    fun testEditDistance() {
        val tool = StringEditDistanceSCPDT()
        test(tool, root)
    }

    @Test
    fun testTiling() {
        val tool = StringTilingSCPDT()
        test(tool, root)
    }
}
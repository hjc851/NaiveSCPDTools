import me.haydencheers.nscpdt.token.TokenEditDistanceSCPDT
import me.haydencheers.nscpdt.token.TokenTilingSCPDT
import org.junit.Test
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Semaphore
import java.util.concurrent.TimeUnit
import kotlin.streams.toList

class TokenSimilarityTest: AbstractNaiveSCPDTTestCase() {
    @Test
    fun testTiling() {
        val tool = TokenTilingSCPDT()
        val root = Paths.get("/home/haydencheers/Desktop/PhD Data Sets/COMP2240 2018 A1 A2 A3/COMP2240_18_A1_Dataset")
        test(tool, root)
    }

    @Test
    fun testEditDistance() {
        val tool = TokenEditDistanceSCPDT()
        val root = Paths.get("/home/haydencheers/Desktop/PhD Data Sets/COMP2240 2018 A1 A2 A3/COMP2240_18_A1_Dataset")
        test(tool, root)
    }
}
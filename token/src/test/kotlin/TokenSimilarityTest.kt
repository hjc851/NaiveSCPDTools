import me.haydencheers.nscpdt.token.TokenEditDistanceSCPDT
import me.haydencheers.nscpdt.token.TokenTilingSCPDT
import org.junit.Test
import java.nio.file.Paths

class TokenSimilarityTest : AbstractNaiveSCPDTTestCase() {

    val root = Paths.get("/home/haydencheers/Desktop/PhD Data Sets/SENG1110A12017_Seeded/All")
//        val root = Paths.get("/home/haydencheers/Desktop/PhD Data Sets/COMP2240 2018 A1 A2 A3/COMP2240_18_A1_Dataset")

    @Test
    fun testTiling() {
        val tool = TokenTilingSCPDT()
        test(tool, root)
    }

    @Test
    fun testEditDistance() {
        val tool = TokenEditDistanceSCPDT()
        test(tool, root)
    }
}
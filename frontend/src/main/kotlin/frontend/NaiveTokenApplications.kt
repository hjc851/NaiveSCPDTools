package frontend

import me.haydencheers.nscpdt.NaiveSCPDT
import me.haydencheers.nscpdt.token.TokenEditDistanceSCPDT
import me.haydencheers.nscpdt.token.TokenTilingSCPDT

object NaiveTokenEditDistance : AbstractApplicationFrontend() {

    override val tool: NaiveSCPDT
        get() = TokenEditDistanceSCPDT()

    @JvmStatic
    fun main(args: Array<String>) {
        run(args)
    }
}

object NaiveTokenTiling : AbstractApplicationFrontend() {

    override val tool: NaiveSCPDT
        get() {
            val threshold = System.getenv("THRESHOLD")?.toIntOrNull() ?: 20
            return TokenTilingSCPDT(threshold)
        }

    @JvmStatic
    fun main(args: Array<String>) {
        run(args)
    }
}
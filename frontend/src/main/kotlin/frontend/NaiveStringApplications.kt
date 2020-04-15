package frontend

import me.haydencheers.nscpdt.NaiveSCPDT
import me.haydencheers.nscpdt.string.StringEditDistanceSCPDT
import me.haydencheers.nscpdt.string.StringTilingSCPDT

object NaiveStringEditDistance : AbstractApplicationFrontend() {

    override val tool: NaiveSCPDT
        get() = StringEditDistanceSCPDT()

    @JvmStatic
    fun main(args: Array<String>) {
        run(args)
    }
}

object NaiveStringTiling : AbstractApplicationFrontend() {

    override val tool: NaiveSCPDT
        get() {
            val threshold = System.getenv("THRESHOLD")?.toIntOrNull() ?: 20
            return StringTilingSCPDT(threshold)
        }

    @JvmStatic
    fun main(args: Array<String>) {
        run(args)
    }
}

object FilewiseNaiveStringEditDistance : AbstractFilewiseApplicationFrontend() {

    override val tool: NaiveSCPDT
        get() = StringEditDistanceSCPDT()

    @JvmStatic
    fun main(args: Array<String>) {
        run(args)
    }
}

object FilewiseNaiveStringTiling : AbstractFilewiseApplicationFrontend() {

    override val tool: NaiveSCPDT
        get() {
            val threshold = System.getenv("THRESHOLD")?.toIntOrNull() ?: 20
            return StringTilingSCPDT(threshold)
        }

    @JvmStatic
    fun main(args: Array<String>) {
        run(args)
    }
}
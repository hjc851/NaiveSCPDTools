package frontend

import me.haydencheers.nscpdt.NaiveSCPDT
import me.haydencheers.nscpdt.tree.TreeEditDistanceSCPDT

object NaiveTreeEditDistance : AbstractApplicationFrontend() {
    override val tool: NaiveSCPDT
        get() = TreeEditDistanceSCPDT()

    @JvmStatic
    fun main(args: Array<String>) {
        run(args)
    }
}

object FilewiseNaiveTreeEditDistance : AbstractFilewiseApplicationFrontend() {
    override val tool: NaiveSCPDT
        get() = TreeEditDistanceSCPDT()

    @JvmStatic
    fun main(args: Array<String>) {
        run(args)
    }
}
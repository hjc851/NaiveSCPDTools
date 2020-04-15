package frontend

import me.haydencheers.nscpdt.NaiveSCPDT
import me.haydencheers.nscpdt.pdg.ProgramDependenceGraphSCPDT

object NaivePDGEditDistance: AbstractApplicationFrontend() {
    override val tool: NaiveSCPDT
        get() = ProgramDependenceGraphSCPDT()

    @JvmStatic
    fun main(args: Array<String>) {
        run(args)
    }
}

object FilewiseNaivePDFEditDistance: AbstractFilewiseApplicationFrontend() {
    override val tool: NaiveSCPDT
        get() = ProgramDependenceGraphSCPDT()

    @JvmStatic
    fun main(args: Array<String>) {
        NaivePDGEditDistance.run(args)
    }
}
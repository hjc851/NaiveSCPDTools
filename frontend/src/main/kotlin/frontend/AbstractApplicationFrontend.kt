package frontend

import me.haydencheers.nscpdt.NaiveSCPDT
import java.nio.file.Files
import java.nio.file.Paths

abstract class AbstractApplicationFrontend {
    abstract val tool: NaiveSCPDT

    fun run(args: Array<String>) {
        if (args.size != 2) throw IllegalArgumentException("Usage: ${this.javaClass.name} <submission 1> <submission 2>")

        val submission1 = Paths.get(args[0])
        val submission2 = Paths.get(args[1])

        if (!Files.exists(submission1)) throw IllegalArgumentException("Error: submission 1 does not exist")
        if (!Files.exists(submission2)) throw IllegalArgumentException("Error: submission 2 does not exist")

        val similarity = tool.evaluateSimilarity(submission1, submission2)
        println("SUCCESS")
        println("$submission1:$submission2:$similarity")
    }
}
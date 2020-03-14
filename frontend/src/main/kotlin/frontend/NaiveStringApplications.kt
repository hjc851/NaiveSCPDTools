package frontend

import me.haydencheers.nscpdt.string.StringEditDistanceSCPDT
import me.haydencheers.nscpdt.string.StringTilingSCPDT
import java.nio.file.Files
import java.nio.file.Paths

object NaiveStringEditDistance {
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.size != 2) throw IllegalArgumentException("Usage: frontend.NaiveStringEditDistance <submission 1> <submission 2>")

        val submission1 = Paths.get(args[0])
        val submission2 = Paths.get(args[1])

        if (!Files.exists(submission1)) throw IllegalArgumentException("Error: submission 1 does not exist")
        if (!Files.exists(submission2)) throw IllegalArgumentException("Error: submission 2 does not exist")

        val tool = StringEditDistanceSCPDT()

        val similarity = tool.evaluateSimilarity(submission1, submission2)
        println("$submission1:$submission2:$similarity")
    }
}

object NaiveStringTiling {
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.size != 2) throw IllegalArgumentException("Usage: frontend.NaiveStringTiling <submission 1> <submission 2>")

        val submission1 = Paths.get(args[0])
        val submission2 = Paths.get(args[1])

        if (!Files.exists(submission1)) throw IllegalArgumentException("Error: submission 1 does not exist")
        if (!Files.exists(submission2)) throw IllegalArgumentException("Error: submission 2 does not exist")

        val threshold = System.getenv("THRESHOLD")?.toIntOrNull() ?: 20
        val tool = StringTilingSCPDT(threshold)

        val similarity = tool.evaluateSimilarity(submission1, submission2)
        println("$submission1:$submission2:$similarity")
    }
}
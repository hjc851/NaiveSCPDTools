import me.haydencheers.nscpdt.NaiveSCPDT
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Semaphore
import java.util.concurrent.TimeUnit
import kotlin.streams.toList

abstract class AbstractNaiveSCPDTTestCase {
    protected fun test(tool: NaiveSCPDT, root: Path) {
        val submissions = Files.list(root)
            .filter { Files.isDirectory(it) }
            .use { it.toList() }

        val count = submissions.count().toDouble()
        val compcount = ((count / 2.0) * (count - 1)).toInt()
        val sem = Semaphore(compcount)

        var sum = 0.0

        val results = mutableListOf<Triple<Path, Path, Double>>()

        for (l in 0 until submissions.size) {
            val lsub = submissions[l]

            for (r in l + 1 until submissions.size) {
                val rsub = submissions[r]

                sem.acquire()

                CompletableFuture.runAsync {
                    val sim = tool.evaluateSimilarity(lsub, rsub)
                    sum += sim
                    results.add(Triple(lsub.fileName, rsub.fileName, sim))
                }.whenComplete { void, throwable ->
                    throwable?.printStackTrace()
                    sem.release()
                }
            }
        }

        println("Awaiting ${compcount - sem.availablePermits()} permits")
        while (!sem.tryAcquire(compcount, 5, TimeUnit.SECONDS)) {
            println("Awaiting ${compcount - sem.availablePermits()} permits")
        }

        results.sortedByDescending { it.third }
            .forEach { (l, r, score) ->
                println("$l:$r $score")
            }

        val avg = sum / compcount
        println("Average sim ${avg}")
    }
}
import com.github.javaparser.JavaParser
import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.body.TypeDeclaration
import me.haydencheers.nscpdt.ProjectListing
import me.haydencheers.nscpdt.pdg.PDGBuilder
import me.haydencheers.nscpdt.pdg.ProgramDependenceGraphSCPDT
import org.junit.Test
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Semaphore
import java.util.concurrent.TimeUnit
import kotlin.streams.toList

class PDGTest {

    val root = Paths.get("/media/haydencheers/Data/PrEP/datasets/SENG2050_A1_2020")
    val tool = ProgramDependenceGraphSCPDT()

    @Test
    fun test2() {
        val dirs = Files.list(root)
            .filter { Files.isDirectory(it) && !Files.isHidden(it) }
            .toList()

        for (l in 0 until dirs.size) {
            val ldir = dirs[l]
            for (r in l+1 until dirs.size) {
                val rdir = dirs[r]

                val sim = tool.evaluateSimilarity(ldir, rdir)
                println("$l x $r")
            }
        }
    }

    @Test
    fun testSim() {
        val submissions = Files.list(root)
            .filter { Files.isDirectory(it) }
            .filter { it.fileName.toString().contains("-L") }
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

    //    @Test
    fun test() {
        val submissions = Files.list(root)
            .filter { Files.isDirectory(it) && !Files.isHidden(it) }
            .map { ProjectListing.makeListing(it, ".java") }
            .use { it.toList() }

        val parser = JavaParser()
        parser.parserConfiguration.characterEncoding = Charset.forName("ISO-8859-1")

        for (sub in submissions) {
            for (file in sub.sources) {
                val cures = parser.parse(file)
                if (cures.result.isPresent) {
                    val cu = cures.result.get()
                    val types = findAllTypes(cu)

                    for (type in types) {

                        for (constructor in type.constructors) {
                            val graph = PDGBuilder.build(constructor)
//                            if (graph.nodeCount > 10) {
//                                graph.display().apply { closeFramePolicy = Viewer.CloseFramePolicy.CLOSE_VIEWER }
//                                print("press enter >")
//                                readLine()
//                            }
                        }

                        for (method in type.methods) {
                            val graph = PDGBuilder.build(method)
//                            if (graph.nodeCount > 10) {
//                                graph.display().apply { closeFramePolicy = Viewer.CloseFramePolicy.CLOSE_VIEWER }
//                                print("press enter >")
//                                readLine()
//                            }
                        }
                    }

                } else {
                    System.err.println("Cannot parse $file")
                }
            }
        }

    }

    fun findAllTypes(cu: CompilationUnit): List<TypeDeclaration<*>> {
        val toCheck = Stack<TypeDeclaration<*>>()
        val types = mutableListOf<TypeDeclaration<*>>()

        toCheck.addAll(cu.types)
        types.addAll(cu.types)

        while (toCheck.isNotEmpty()) {
            val type = toCheck.pop()

            val itypes = type.members.filterIsInstance<TypeDeclaration<*>>()
            toCheck.addAll(itypes)
            types.addAll(itypes)
        }

        return types
    }
}

fun main(args: Array<String>) {
    val test = PDGTest()
    test.test()
}
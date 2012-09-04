package de.learnscala.base

import org.specs2.reporter._
import org.specs2.specification._
import org.specs2.main.Arguments
import org.specs2.specification.ExecutedText
import org.specs2.specification.ExecutedSpecification
import org.specs2.execute._
import java.util.Date

class Export extends Exporter with Push {

    def export(implicit args: Arguments): ExecutingSpecification => ExecutedSpecification = (spec: ExecutingSpecification) => {
        start = new Date()
        val executed = spec.execute
        end = new Date()

        export2(executed.fragments)
        send()

        executed
    }

    case class Task(head: ExecutedFragment, results: List[ExecutedResult] = List())

    private def export2(fs: Seq[ExecutedFragment], res: Option[Task] = None)(implicit args: Arguments) {
        fs.headOption match {
            case Some(h) =>
                h match {
                    case f@ExecutedSpecStart(ss, _, _) =>
                        name = ss.name
                        export2(fs.tail, res)
                    case f@ExecutedText(t, _) =>
                        res.map(processTask(_)) // process last task
                        export2(fs.tail, Some(Task(f)))
                    case f: ExecutedResult =>
                        export2(fs.tail, res.map(r => r.copy(results = f :: r.results)))
                    case _ =>
                        export2(fs.tail, res)
                }
            case _ =>
                res.map(processTask(_)) // it's over, process last task
        }
    }

    private def processTask(task: Task) {
        println(task)
        val r: Int = task.results.foldLeft(0)((t, r) =>
            scala.math.max(valueOf(r.result), t)
        )
        result = r :: result
    }

    private def valueOf(r: AnyRef): Int =
        r match {
            case f: Failure => 2
            case e: Error => 2
            case p: Pending => 1
            case s: Skipped => 1
            case s: Success => 0
            case _ => -1
        }
}

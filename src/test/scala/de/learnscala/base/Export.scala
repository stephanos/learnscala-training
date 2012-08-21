package de.learnscala.base

import org.specs2.reporter._
import org.specs2.specification._
import org.specs2.main.Arguments

class Export extends Exporter with Push {

    def export(implicit args: Arguments): ExecutingSpecification => ExecutedSpecification = {
        (s: ExecutingSpecification) =>
            val res = s.execute
            res.fs foreach {
                _ match {
                    case r: ExecutedResult =>
                        val stats = r.statistics
                        println(stats)
                    /*case r: ExecutedBacktab =>
                        val stats = r.stats
                        println(stats)*/
                    case r =>
                        println(r)
                }
            }
            //send()
            res
    }

}

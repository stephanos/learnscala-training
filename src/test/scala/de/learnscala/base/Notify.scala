package de.learnscala.base

import org.specs2.reporter._
import org.specs2.execute.Details
import java.util.Date

class Notify extends Notifier with Push {

    def specStart(title: String, location: String) {
        name = title
        start = new Date
    }

    def specEnd(title: String, location: String) {
        end = new Date
        send()
    }

    def contextStart(text: String, location: String) {

    }

    def contextEnd(text: String, location: String) {

    }

    def text(text: String, location: String) {

    }

    def exampleStarted(name: String, location: String) {

    }

    def exampleSuccess(name: String, duration: Long) {
        success += 1
    }

    def exampleFailure(name: String, message: String, location: String, f: Throwable, details: Details, duration: Long) {
        //println(name)
        fail += 1
    }

    def exampleError(name: String, message: String, location: String, f: Throwable, duration: Long) {
        //println(name)
        error += 1
    }

    def exampleSkipped(name: String, message: String, duration: Long) {
        //println(name)
        skip += 1
    }

    def examplePending(name: String, message: String, duration: Long) {
        //println(name)
        pending += 1
    }
}

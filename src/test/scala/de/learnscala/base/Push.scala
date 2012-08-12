package de.learnscala.base

import org.specs2.reporter._
import org.specs2.execute.Details
import java.util.Date

class Push extends Notifier {

    var name: String = _

    var skip: Int = 0
    var fail: Int = 0
    var error: Int = 0
    var success: Int = 0
    var pending: Int = 0

    var start: Date = _
    var end: Date = _


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
        fail += 1
    }

    def exampleError(name: String, message: String, location: String, f: Throwable, duration: Long) {
        error += 1
    }

    def exampleSkipped(name: String, message: String, duration: Long) {
        skip += 1
    }

    def examplePending(name: String, message: String, duration: Long) {
        pending += 1
    }

    private def send() {

        if(name.startsWith("S")) {

            val data =
                <test name="{name}">
                    <start>
                        {start.getTime}
                    </start>
                    <end>
                        {end.getTime}
                    </end>
                    <fail>
                        {fail}
                    </fail>
                    <success>
                        {success}
                    </success>
                    <skip>
                        {skip}
                    </skip>
                    <error>
                        {error}
                    </error>
                    <pending>
                        {pending}
                    </pending>
                </test>.toString()

            import org.apache.http.entity._
            import org.apache.http.client.methods._
            import org.apache.http.impl.client._
            import org.apache.http.params._

            val params = new BasicHttpParams()
            val cparams = new HttpConnectionParamBean(params)
            cparams.setConnectionTimeout(1000)
            cparams.setSoTimeout(1000)
            val client = new DefaultHttpClient(params)

            try {
                val post = new HttpPost("http://STEPHAN-MAC:80/test/progress")
                post.setEntity(new StringEntity(data))
                client.execute(post)
            } catch {
                case t: Throwable => //println(t)
            }
        }
    }
}

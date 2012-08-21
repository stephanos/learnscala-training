package de.learnscala.base

import java.util.Date

trait Push {

    var name: String = _

    var skip: Int = 0
    var fail: Int = 0
    var error: Int = 0
    var success: Int = 0
    var pending: Int = 0

    var start: Date = _
    var end: Date = _

    protected def send() {

        if (name.startsWith("S")) {

            val uuid = {
              import java.net._
              val ip = InetAddress.getLocalHost
              val network = NetworkInterface.getByInetAddress(ip)
              val mac = network.getHardwareAddress
              mac.map("%02x".format(_)).mkString(":")
            }

            val data =
                <test id={name} user={uuid}>
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
                //println(data)
                val post = new HttpPost("http://Stephan-Mac:80/api/exercises/" + name)
                //val post = new HttpPost("http://127.0.0.1:9000/api/exercises/" + name)
                post.setEntity(new StringEntity(data, ContentType.TEXT_XML))
                val r = client.execute(post)
                //println(r)
                //println(scala.io.Source.fromInputStream(r.getEntity.getContent).getLines().mkString("\n"))
            } catch {
                case t: Throwable => //println(t)
            }
        }
    }
}

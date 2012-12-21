package de.learnscala.test.base

import java.util.Date

trait Push {

    var result = List[Int]()
    var name: String = _
    var start: Date = _
    var end: Date = _

    protected def send() {

        return

        //println(name)

        if (name != null && name.startsWith("Test")) {

            val code = name.tail

            val uuid = { // ERROR
                import java.net._
                try {
                    val ip = InetAddress.getLocalHost
                    val network = NetworkInterface.getByInetAddress(ip)
                    val mac = network.getHardwareAddress
                    mac.map("%02x".format(_)).mkString(":")
                } catch {
                    case e: Throwable =>
                        //println(e)
                        ""
                }
            }

            val taskRes = result.reverse.zipWithIndex
            val data =
                <test id={code} user={uuid}>
                    {
                        taskRes.map {
                            tr =>
                                <task num={tr._2.toString}>
                                    {tr._1}
                                </task>
                        }
                    }
                    <start>
                        {start.getTime}
                    </start>
                    <end>
                        {end.getTime}
                    </end>
                </test>.toString()

            val host = "Stephan-Mac"
            try {
                sendXML(code ,data, host + ".local") // OSX adds ".local" to host names
            } catch {
                case _: Throwable =>
                    try {
                        sendXML(code, data, host)
                    } catch {
                        case t: Throwable => // println(t)
                    }
            }
        }
    }

    private def sendXML(code: String, data: String, addr: String, port: String = "80") {
        import org.apache.http.entity._
        import org.apache.http.client.methods._
        import org.apache.http.impl.client._
        import org.apache.http.params._

        //println(data)

        val params = new BasicHttpParams()
        val cparams = new HttpConnectionParamBean(params)
        cparams.setConnectionTimeout(1000)
        cparams.setSoTimeout(1000)
        val client = new DefaultHttpClient(params)

        val post = new HttpPost("http://" + addr + ":" + port + "/api/exercises/" + code)
        post.setEntity(new StringEntity(data, ContentType.TEXT_XML))
        val r = client.execute(post)

        //println(r)
        //println(scala.io.Source.fromInputStream(r.getEntity.getContent).getLines().mkString("\n"))
    }
}

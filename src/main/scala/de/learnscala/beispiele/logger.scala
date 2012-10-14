package de.learnscala.beispiele

package object logger {

    abstract class LogMessage
    case class StringMessage(message: String) extends LogMessage
    case class ExceptionMessage(ex: Throwable) extends LogMessage
    case class BothMessage(message: String, ex: Throwable) extends LogMessage

    object Logger {

        def debug(l: LogMessage) =
            log(10, l)

        def info(l: LogMessage) =
            log(5, l)

        def error(l: LogMessage) =
            log(1, l)

        private def log(level: Int, lm: LogMessage) {
            lm match {
                case StringMessage(msg) => println(msg)
                case ExceptionMessage(ex: Error) => ex.printStackTrace()
                case ExceptionMessage(ex) if level < 5 => ex.printStackTrace()
                case ExceptionMessage(ex) => println(ex.toString)
                case BothMessage(msg, ex) => {
                    log(level, StringMessage(msg + "with exception:"))
                    log(level, ExceptionMessage(ex))
                }
            }
        }
    }
}

object Main extends App {

    import logger._

    Logger.info(StringMessage("Connecting to database"))
    Logger.debug(StringMessage("Using MySQL dialect"))
    Logger.error(BothMessage("Database connection failed", new RuntimeException("invalid password")))
}
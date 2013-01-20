package de.learnscala.beispiele
package interpol

object Main extends App {

  val name = "Dave"
  println(s"Hello, $name")


  val height = 1.79d
  println(f"$name is $height%2.2f meters tall")


  implicit class XMLHelper(val sc: StringContext) /* extends AnyVal */ {
    def xml(args: Any*) =
      scala.xml.XML.load(scala.xml.Source.fromString(sc.s(args: _*)))
  }

  println(xml"<person><name>$name</name></person>")

}
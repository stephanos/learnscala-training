package de.learnscala.beispiele
package meter

class Meters(val length: Double) extends AnyVal {

  def +(m: Meters): Meters = new Meters(length + m.length)
  def toFeet: Feet = new Feet(length * 3.28084)

  override def toString = s"$length meters"
}

class Feet(val length: Double) extends AnyVal {

  def +(f: Feet): Feet = new Feet(length + f.length)
  def toMeters: Meters = new Meters(length / 3.28084)

  override def toString = s"$length feet"
}

object Main extends App {

  implicit class toFeetMeters(d: Double) {
    def feet: Feet = new Feet(d)
    def meters: Meters = new Meters(d)
  }

  val m100 = 100.meters
  println(s"m100 equal ${m100.toFeet}")

}
package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_B22 extends Exercise with Help /* with Disabled */ {

  /**
   * Gesucht wird eine Klasse 'Bruch'
   *
   * Sie besitzt:
   * - eine Methode toString mit der Ausgabe der Form "z/n"
   * - eine Methode '*' zur Multiplikation
   * - eine Methode '/' zur Division
   * - eine Methode '!' zum Umdrehen von Zähler und Nenner
   *
   * ! Die Ausgabe via String sollte natürlich immer gekürzte Brüche ausgeben !
   *
   * Und nicht vergessen: Zur Division wird über Kreuz multipliziert.
   */


  // Als Arbeitserleichterung hier die Methode zur Berechnung des größten gemeinsamen Teilers:
  private def gcd(x: Int, y: Int): Int = {
    if (x == 0) y
    else if (x < 0) gcd(-x, y)
    else if (y < 0) -gcd(x, -y)
    else gcd(y % x, x)
  }


  /**
   * Aufgabe #1
   */

  def r1 = TODO // new Rational(1,2)

  // ===============================================================

  /**
   * Aufgabe #2
   */

  def r2 = TODO // (new Rational(1,2)) * (new Rational(1,2))

  // ===============================================================

  /**
   * Aufgabe #3
   */

  def r3 = TODO // (new Rational(1,8)) / (new Rational(1,2))

  // ===============================================================

  /**
   * Aufgabe #4
   */

  def r4 = TODO // (new Rational(7,8)) * (new Rational(2,3))

  // ===============================================================

  /**
   * Aufgabe #5
   */

  def r5 = TODO // !(new Rational(1,2))
}
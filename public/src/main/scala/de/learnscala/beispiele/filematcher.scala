package de.learnscala.beispiele
package filematcher

/**
 * Closure, Funktion höherer Ordnung
 */
class FileMatcher {

  private def filesHere = (new java.io.File(".")).listFiles

  private def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
    yield file

  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))

  def filesContaining(query: String) =
    filesMatching(_.contains(query))

  def filesRegex(query: String) =
    filesMatching(_.matches(query))
}


object Main extends App {

  val m = new FileMatcher()

  println(m.filesEnding(".scala"))
  println(m.filesContaining("scala"))
}
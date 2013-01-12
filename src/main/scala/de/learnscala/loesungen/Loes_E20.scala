package de.learnscala.loesungen

import de.learnscala.base.Solution
import xml.NodeSeq

class Loes_E20 extends Solution {

  task(1) {
    def movieToXml(title: String, director: String, actors: List[String]): NodeSeq =
      null
  }

  // ===============================================================

  task(2) {
    def releaseDateOfPsycho(xml: NodeSeq): Int = {
      println(xml)
      (xml \ "@year").text.toInt
    }
  }

  // ===============================================================

  task(3) {
    def releaseDateOfPsycho(xml: NodeSeq): List[String] =
      List()
  }

  // ===============================================================

  task(4) {
    def moviesFromThe40s(xml: NodeSeq): List[String] =
      List()
  }

  // ===============================================================

  task(5) {
    def moviesFromAlfredHitchcock(xml: NodeSeq): List[String] = {
      List()
    }
  }

  // ===============================================================

  task(6) {
    def moviesWithCaryGrant(xml: NodeSeq): List[String] = {
      List()
    }
  }

  // ===============================================================

  task(7) {
    def movieSequels(xml: NodeSeq): List[String] = {
      List()
    }
  }
}
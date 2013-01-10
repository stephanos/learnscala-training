package de.learnscala.loesungen

import de.learnscala.base.Solution
import xml.{NodeSeq, Node}

class Loes_E20 extends Solution {

    task(1) {
        def releaseDateOfPsycho(xml: NodeSeq): Int = {
            println(xml)
            (xml \ "@year").text.toInt
        }
    }

    // ===============================================================

    task(1) {
        def releaseDateOfPsycho(xml: NodeSeq): List[String] =
            List()
    }

    // ===============================================================

    task(2) {
        def moviesFromThe40s(xml: NodeSeq): List[String] =
            List()
    }

    // ===============================================================

    task(3) {
        def moviesFromAlfredHitchcock(xml: NodeSeq): List[String] = {
            List()
        }
    }

    // ===============================================================

    task(4) {
        def moviesWithCaryGrant(xml: NodeSeq): List[String] = {
            List()
        }
    }

    // ===============================================================

    task(5) {
        def movieSequels(xml: NodeSeq): List[String] = {
            List()
        }
    }
}
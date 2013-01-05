package de.learnscala.examples
package state

class State(val code: String, val desc: String, val loc: Symbol) {

    override def toString = desc
}

object Main extends App {

    val states = List(
        new State("DC", "District of Columbia", 'east),
        new State("VA", "Virginia", 'east),
        new State("MD", "Maryland", 'east),
        new State("CA", "California", 'west),
        new State("OK", "Oklahoma", 'midwest),
        new State("NE", "Nebraska", 'midwest),
        new State("AL", "Alabama", 'south)
    )

    // Which states are NOT on the east coast ?
    val noEastCoast =
        for {
            state <- states
            if state.loc != 'east
        } yield state

    println(noEastCoast)

    // Which pair of states are NOT in the same area ?
    val possibleSisters =
        for {
            state1 <- states
            state2 <- states
            if state1.loc != state2.loc
        } yield (state1, state2)

    println(possibleSisters)
}
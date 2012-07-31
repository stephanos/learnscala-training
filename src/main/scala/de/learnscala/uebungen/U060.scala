package de.learnscala.uebungen

import de.learnscala.base.Uebung

object U060 extends Uebung(enabled = true) {

    /**
     * Berechnet die Hälfte einer Zahl,
     * wirft jedoch eine Exception wenn die Zahl nicht ganzzahlig teilbar ist.
     */
    def half(n: Int) =
        if (n % 2 == 0)
            n / 2
        else
            throw new RuntimeException("n must be even")


    /**
     * Fragt den Namen eines Users ab.
     *
     * Bei 'RuntimeException' sollte 'connection not open' geloggt werden.
     * Bei 'IllegalArgumentException' sollte 'invalid user id' geloggt werden.
     * Bei 'NoSuchElementException' sollte 'no user found' geloggt werden.
     *
     * PS: Die Verbindung sollte am Ende geschlossen werden.
     *
     * @param c Datenbankverbindung
     * @param id ID des Users
     * @return Name des Users oder 'null' bei einem Fehler
     */
    def username(c: Connection, id: Long): String = {
        try {
            queryUserName(c, id)
        } catch {
            case e: IllegalArgumentException =>
                println("invalid user id")
                null
            case e: NoSuchElementException =>
                println("no user found")
                null
            case e: RuntimeException =>
                println("connection not open")
                null
        } finally {
            c.close()
        }
    }



    /***********************************************************************************************
    ** HELPERS
    ************************************************************************************************/
    class Connection(val db: String) {
        private var open = true
        def close(): Unit =  open = false
        def isOpen = if(db == "") false else open
    }

    private def queryUserName(conn: Connection, id: Long) = {
        if(id <= 0) throw new IllegalArgumentException()
        if(!conn.isOpen) throw new RuntimeException()
        if(id == 1) "Bob"
        else if(id == 2) "Jim"
        else throw new NoSuchElementException()
    }
}
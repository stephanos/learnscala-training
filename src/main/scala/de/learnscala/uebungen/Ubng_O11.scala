package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_O11 extends Exercise with Help /* with Disabled */ {

    /**
     * Produkte eines Supermarktes.
     *
     * Gesucht werden die fehlenden Klassen aus dem unteren Beispielen.
     */

    // ===============================================================
    // TESTS
    // ===============================================================

    /**
     * Einfaches Produkt 'Butter'
     */
    def butter =
        TODO //new SimpleItem(.95f, "Butter")

    /**
     * Reduziertes Produkt 'Milch'
     */
    def milk =
        TODO //new ReducedItem(.99f, 5, "Milk")

    /**
     * Gebündeltes Produkt 'Butter' und 'Milch'
     */
    def butterAndMilk =
        TODO //new Bundle(butter, milk)

    /**
     * Gewichtetes Produkt 'Äpfel'
     */
    def apple5kg =
        TODO //new WeightedItem(5, 0.2f, "Apples")

    /**
     * Gebündeltes Produkt 'Butter' und 'Milch' und 'Äpfel'
     */
    def butterMilkAndApples =
        TODO //new Bundle(apple5kg, butterAndMilk)
}
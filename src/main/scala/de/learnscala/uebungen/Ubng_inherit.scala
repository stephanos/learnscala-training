package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_inherit extends Exercise with Help /* with Disabled */ {


  /**
   * Produkte eines Supermarktes.
   *
   * @todo Bringen Sie die Tests zum Laufen!
   *
   * @note Die Tests verwenden 'toString' zum Vergleichen.
   * @note Nutzen Sie geschickt Vererbung, um Redundanzen zu vermeiden!
   *
   * @note "%.2f".format(1f) == "1.00"
   * @note eine abstrakte Basisklasse ist sicher hilfreich!
   */

  TODO


  // ===============================================================
  // TESTS
  // ===============================================================

  task {
    /**
     * Einfaches Produkt 'Butter'
     */
    def butter = TODO //new SimpleItem(.95f, "Butter")

    /**
     * Prozentual reduziertes Produkt 'Milch'
     */
    def milk = TODO //new ReducedItem(1.0f, 5, "Milk")

    /**
     * Gebündeltes Produkt 'Butter' und 'Milch'
     */
    def butterAndMilk = TODO //new Bundle(butter, milk)

    /**
     * Gewichtetes (kg) Produkt 'Äpfel'
     */
    def apple5kg = TODO //new WeightedItem(0.2f, 5, "Apples")

    /**
     * Gebündeltes Produkt 'Butter' und 'Milch' und 'Äpfel'
     */
    def butterMilkAndApples = TODO //new Bundle(apple5kg, butterAndMilk)
  }
}
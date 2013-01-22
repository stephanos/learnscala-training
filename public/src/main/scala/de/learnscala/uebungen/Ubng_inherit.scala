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

  INSERT_SOLUTION_HERE


  // ===============================================================
  // TESTS
  // ===============================================================

  task {
    /**
     * Einfaches Produkt 'Butter'
     */
    def butter = MAKE_THIS_TEST_PASS // with this: new SimpleItem(.95f, "Butter")

    /**
     * Prozentual reduziertes Produkt 'Milch'
     */
    def milk = MAKE_THIS_TEST_PASS // with this: new ReducedItem(1.0f, 5, "Milk")

    /**
     * Gebündeltes Produkt 'Butter' und 'Milch'
     */
    def butterAndMilk = MAKE_THIS_TEST_PASS // with this: new Bundle(butter, milk)

    /**
     * Gewichtetes (kg) Produkt 'Äpfel'
     */
    def apple5kg = MAKE_THIS_TEST_PASS // with this: new WeightedItem(0.2f, 5, "Apples")

    /**
     * Gebündeltes Produkt 'Butter' und 'Milch' und 'Äpfel'
     */
    def butterMilkAndApples = MAKE_THIS_TEST_PASS // with this: new Bundle(apple5kg, butterAndMilk)
  }
}
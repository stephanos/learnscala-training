package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_O11 extends Solution {

  task {

    abstract class Item {
      def price: Float
      def description: String

      override def toString =
        description + " for " + price + "€"
    }

    class SimpleItem(val price: Float,
                     val description: String) extends Item

    class ReducedItem(val basePrice: Float,
                      val reducedBy: Int,
                      val description: String) extends Item {

      val price =
        basePrice * (1 + reducedBy / 100)
    }

    class WeightedItem(val kilos: Int,
                       val pricePerKilo: Float,
                       val baseDescription: String) extends Item {

      val price =
        kilos * pricePerKilo

      val description =
        kilos + "kg " + baseDescription
    }

    class Bundle(item1: Item, item2: Item) extends Item {

      val price =
        item1.price + item2.price

      val description =
        item1.description + " & " + item2.description
    }

    // ===============================================================
    // TESTS
    // ===============================================================

    def butter = new SimpleItem(.95f, "Butter")

    def milk = new ReducedItem(1f, 5, "Milk")

    def butterAndMilk = new Bundle(butter, milk)

    def apple5kg = new WeightedItem(5, 0.2f, "Apples")

    def butterMilkAndApples = new Bundle(apple5kg, butterAndMilk)

  }
}
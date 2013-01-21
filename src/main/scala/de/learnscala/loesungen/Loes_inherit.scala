package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_inherit extends Solution {

  abstract class Item {
    def price: Float
    def description: String

    override def toString =
      description + " for " + "%.2f".format(price) + "€"
  }

  class SimpleItem(val price: Float,
                   val description: String) extends Item

  class ReducedItem(val basePrice: Float,
                    val reducedBy: Int,
                    val description: String) extends Item {

    val price =
      basePrice * (100 - reducedBy) / 100
  }

  class WeightedItem(val pricePerKilo: Float,
                     val kilos: Int,
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

  task {
    def butter = new SimpleItem(.95f, "Butter")

    def milk = new ReducedItem(1.0f, 5, "Milk")

    def butterAndMilk = new Bundle(butter, milk)

    def apple5kg = new WeightedItem(0.2f, 5, "Apples")

    def butterMilkAndApples = new Bundle(apple5kg, butterAndMilk)
  }
}
package de.learnscala.specs

import de.learnscala.uebungen.U130._
import de.learnscala.base.BaseTest

class S130 extends BaseTest {

    spec("U130", enabled) {

        "butter" >> {
            butter must not(beNull)

            "must have price 0.95 €" >> {
                butter.price === 0.95f
            }
            "must have description 'Butter'" >> {
                butter.description === "Butter"
            }
        }

        "milk" >> {
            milk must not(beNull)

            "must have correct price" >> {
                milk.price === 0.99f
            }
            "must have correct description" >> {
                milk.description === "Milk"
            }
        }

        "butterAndMilk" >> {
            butterAndMilk must not(beNull)

            "must have correct price" >> {
                butterAndMilk.price === 1.94f
            }
            "must have correct description" >> {
                butterAndMilk.description === "Butter & Milk"
            }
        }

        "apple5kg" >> {
            apple5kg must not(beNull)

            "must have correct price" >> {
                apple5kg.price === 1.00f
            }
            "must have correct description" >> {
                apple5kg.description === "5kg Apples"
            }
        }

        "butterMilkAndApples" >> {
            butterMilkAndApples must not(beNull)

            "must have correct price" >> {
                butterMilkAndApples.price === 2.94f
            }
            "must have correct description" >> {
                butterMilkAndApples.description === "5kg Apples & Butter & Milk"
            }
        }
    }
}
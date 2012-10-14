package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_O11[T: TypeTag] extends BaseTest[T] {

    //        "butter" >> {
    //            checkType[Item](butter, "butter", enabled) {
    //                item =>
    //                    "must have price 0.95 €" >> {
    //                        item.price === 0.95f
    //                    }
    //                    "must have description 'Butter'" >> {
    //                        item.description === "Butter"
    //                    }
    //            }
    //        }
    //
    //        "milk" >> {
    //            checkType[Item](milk, "milk", enabled) {
    //                item =>
    //                    "must have correct price" >> {
    //                        item.price === 0.99f
    //                    }
    //                    "must have correct description" >> {
    //                        item.description === "Milk"
    //                    }
    //            }
    //        }
    //
    //        "butterAndMilk" >> {
    //            checkType[Item](butterAndMilk, "butterAndMilk", enabled) {
    //                item =>
    //                    "must have correct price" >> {
    //                        item.price === 1.94f
    //                    }
    //                    "must have correct description" >> {
    //                        item.description === "Butter & Milk"
    //                    }
    //            }
    //        }
    //
    //        "apple5kg" >> {
    //            checkType[Item](apple5kg, "apple5kg", enabled) {
    //                item =>
    //                    "must have correct price" >> {
    //                        item.price === 1.00f
    //                    }
    //                    "must have correct description" >> {
    //                        item.description === "5kg Apples"
    //                    }
    //            }
    //        }
    //
    //        "butterMilkAndApples" >> {
    //            checkType[Item](butterMilkAndApples, "butterMilkAndApples", enabled) {
    //                item =>
    //                    "must have correct price" >> {
    //                        item.price === 2.94f
    //                    }
    //                    "must have correct description" >> {
    //                        item.description === "5kg Apples & Butter & Milk"
    //                    }
    //            }
    //        }
    //    }
}


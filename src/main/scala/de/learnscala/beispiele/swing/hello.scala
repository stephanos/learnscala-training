package de.learnscala.beispiele
package swing

import scala.swing._

object Main extends SimpleSwingApplication {

    def top = new MainFrame {
        title = "Hello, World!"
        contents = new Button {
            text = "Click Me!"
        }
    }
}
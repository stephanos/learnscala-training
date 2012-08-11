package de.learnscala.base

trait Target {

    self: Reflect =>


    val code: String

    def path =
        "de.learnscala.exercises"

    def name =
        code

    def fullPath =
        path + "." + name

    final lazy val target =
        try {
            getObject(fullPath).get
        } catch {
            case _: Throwable =>
                sys.error("Unable to find target '" + fullPath + "'")
        }
}
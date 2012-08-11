package de.learnscala.base

trait Target {

    self: Reflect =>


    val code: String

    def path =
        "de.learnscala.exercises"

    def fullPath =
        path + code

    final lazy val target =
        getObject(fullPath)
}
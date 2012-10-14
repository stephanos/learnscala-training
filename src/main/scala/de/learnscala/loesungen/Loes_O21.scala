package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_O21 extends Solution {

    /**
     * Gehaltsabrechnung.
     *
     * - jeder normale Angestellte verdient 50.000€ im Jahr
     * - ist er mit dem Manager bedfreundet, bekommt er das doppelte
     * - ist er jedoch illegaler Einwanderer, halbiert sich sein Lohn
     * - ist er Teil des Aufsichtsrats ist er automatisch Freund des Managers
     * - der Manager bekommt das 5x eines normalen Angestellten
     */

    trait Employee {

        def salary = 50000
    }

    class Manager extends Employee {

        override def salary = super.salary * 5
    }

    class BoardMember extends Employee with FriendOfManager

    class Clerk extends Employee


    trait FriendOfManager extends Employee {

        override def salary = super.salary * 2
    }

    trait IllegalImmigrant extends Employee {

        override def salary = super.salary / 2
    }


    /**
     * Aufgabe #1
     */
    def salaryForClerk =
        (new Clerk).salary

    // ===============================================================

    /**
     * Aufgabe #2
     */
    def salaryForManager =
        (new Manager).salary

    // ===============================================================

    /**
     * Aufgabe #3
     */
    def salaryForBoardMember =
        (new BoardMember).salary

    // ===============================================================

    /**
     * Aufgabe #4
     */
    def salaryForfriendOfManagerClerk =
        (new Clerk with FriendOfManager).salary

    // ===============================================================

    /**
     * Aufgabe #5
     */
    def salaryForIllegalImmigrantClerk =
        (new Clerk with IllegalImmigrant).salary

    // ===============================================================

    /**
     * Aufgabe #6
     */
    def salaryForIllegalImmigrantManager =
        (new Manager with IllegalImmigrant).salary

    // ===============================================================

    /**
     * Aufgabe #7
     */
    def salaryForIllegalImmigrantBoardMember =
        (new BoardMember with IllegalImmigrant).salary
}
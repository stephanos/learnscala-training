package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_O21 extends Solution {

    trait Employee {
        def salary = 50000
    }

    trait FriendOfManager extends Employee {
        override def salary = super.salary * 2
    }

    trait IllegalImmigrant extends Employee {
        override def salary = super.salary / 2
    }


    class Manager extends Employee {
        override def salary = super.salary * 5
    }

    class BoardMember extends Employee with FriendOfManager

    class Clerk extends Employee

    // ===============================================================
    // TESTS
    // ===============================================================

    def salaryForClerk =
        (new Clerk).salary

    def salaryForManager =
        (new Manager).salary

    def salaryForBoardMember =
        (new BoardMember).salary

    def salaryForFriendOfManagerClerk =
        (new Clerk with FriendOfManager).salary

    def salaryForIllegalImmigrantClerk =
        (new Clerk with IllegalImmigrant).salary

    def salaryForIllegalImmigrantManager =
        (new Manager with IllegalImmigrant).salary

    def salaryForIllegalImmigrantBoardMember =
        (new BoardMember with IllegalImmigrant).salary
}
package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_F24_2 extends Solution {

  task {

    /*
    def getFriends(id: Long): List[User] =
      friends filter {
        _._1 == id || _._2 == id
      }

    def completeNameOfUsersWithMiddleName =
      for {
        users <- u
      } yield
        println(u.first)
    */
  }


  // ===============================================================
  // API
  // ===============================================================

  def getUser(id: Long): Option[User] =
    users get id

  def getCompany(id: Long): Option[Company] =
    companies get id


  // ===============================================================
  // DATA
  // ===============================================================

  case class User(firstName: String,
                  lastName: String,
                  middleName: Option[String] = None)

  case class Company(name: String,
                     stockSymbol: Option[String] = None)

  val companies = Map(
    1L -> Company("Microsoft", Some("MSFT")),
    2L -> Company("Google", Some("GOOG")),
    3L -> Company("Apple", Some("AAPL")),
    4L -> Company("Typesafe"),
    5L -> Company("Facebook", Some("FB")),
    6L -> Company("Oracle", Some("ORCL")),
    7L -> Company("Berkshire Hathaway", Some("BRK.B"))
  )

  val userToCompany = List(
    1L -> 1L, // User #1 works at Company #1
    2L -> 7L,
    3L -> 2L,
    4L -> 2L,
    5L -> 6L,
    6L -> 3L,
    7L -> 5L,
    8L -> 3L,
    9L -> 4L,
    10L -> 2L
  )

  val friends = List(
    1L -> 2L, // User #1 is friends with User #2
    3L -> 4L,
    1L -> 7L,
    8L -> 6L,
    8L -> 5L
  )

  val users = Map(
    1L -> User("Bill", "Gates", Some("Henry")),
    2L -> User("Warren", "Buffet"),
    3L -> User("Larry", "Page"),
    4L -> User("Sergey", "Brin"),
    5L -> User("Larry", "Ellison", Some("Joseph")),
    6L -> User("Tim", "Cook"),
    7L -> User("Mark", "Zuckerberg", Some("Elliot")),
    8L -> User("Steve", "Jobs"),
    9L -> User("Martin", "Odersky"),
    10L -> User("Erich", "Schmidt", Some("Emerson"))
  )

}

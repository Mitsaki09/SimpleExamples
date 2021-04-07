package daoexamples.dao

import daoexamples.model.{InnerClass, TestClass}
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._

class TestDAO {

  import daoexamples.TestModel.testClasses

  // ---------------------------GET-------------------------------------------

  // метод ищит по id и возвращает весь класс
  def findById(id: Int): DBIO[Option[TestClass]] = {
    testClasses.filter(_.id === id)
      .result.headOption
  }

  def findSomeStringById(id: Int): DBIO[Option[String]] = {
    testClasses.filter(_.id === id)
      .map(_.someString) // метод достает поле someString
      .result.headOption
  }

  def findSomeOptionStringById(id: Int): DBIO[Option[String]] = {
    testClasses.filter(_.id === id)
      .map(_.someOptionString) // метод достает поле someString
      .result.headOption
  }

  def findInnerClassById(id: Int): DBIO[Option[InnerClass]] = {
    testClasses.filter(_.id === id)
      .map(_.innerClass) // метод достает поле innerClass - внутренний класс
      .result.headOption
  }

  // ---------------------------UPDATE-------------------------------------------

  def updateById(id: Int, testClass: TestClass): DBIO[Int] = {
    testClasses.filter(_.id === id)
      .update(testClass) //обновляет весь класс
  }

  def updateSomeStringId(id: Int, newSomeString: String): DBIO[Int] = {
    testClasses.filter(_.id === id)
      .map(_.someString) // выбираем что обновить
      .update(newSomeString) //обновляет только someString
  }
  def updatesomeOptionStringId(id: Int, newSomeOptionString: Option[String]): DBIO[Int] = {
    testClasses.filter(_.id === id)
      .map(_.someOptionString) // выбираем что обновить
      .update(newSomeOptionString) //обновляет только someString
  }
}

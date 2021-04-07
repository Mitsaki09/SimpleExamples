package daoexamples
import daoexamples.model.{InnerClass, TestClass}
import slick.jdbc.PostgresProfile.api._
import slick.lifted.Tag

object TestModel {

  class TestClassTable(tag: Tag) extends Table[TestClass](tag, "TestClass") {
    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
    def someString=column[String]("some_string")
    def someOptionString=column[Option[String]]("some_option_string")


    def innerClass_a=column[Int]("inner_class_a")
    def innerClass_b=column[Int]("inner_class_b")

    def a_option=column[Option[Int]]("a_option")
    def b_option=column[Option[Int]]("b_option")

    def innerClass = (innerClass_a, innerClass_b).mapTo[InnerClass]
    def optionInnerClass = (a_option, b_option).mapTo[Option[InnerClass]]


    override def * = (id,someString,someOptionString,innerClass,optionInnerClass).mapTo[TestClass]
  }
  val testClasses = TableQuery[TestClassTable]
}

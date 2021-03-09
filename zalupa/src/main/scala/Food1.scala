object Food1 extends App {

  abstract class Food(val calories: Short)

  class Potato(calories: Short) extends Food(calories: Short)
  class Egg(calories: Short) extends Food(calories: Short)
  class Cucumber(calories: Short) extends Food(calories: Short)

  class Salad(val potato: Potato,val egg: Egg,val cucumber: Cucumber,calories: Short) extends Food(calories: Short){

    def sumCal: Unit= {

     val SaladKalorii: Int = (potato.calories+egg.calories+cucumber.calories)

      println(SaladKalorii)

    }
  }
val potato = new Potato ( 12)
  val egg = new Egg (13)
  val cucumber = new Cucumber(132)

val SaladKalorii = new Salad (potato,egg,cucumber,47)

}

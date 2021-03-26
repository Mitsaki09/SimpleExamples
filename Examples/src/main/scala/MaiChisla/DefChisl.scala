package MaiChisla

object DefChisl extends App {

  implicit class SumYes(myNumbersA: MyNumbersA) {

    def sumPlus: Int = {
      myNumbersA.a + myNumbersA.b}
    def sumMinus: Int = {
      myNumbersA.a - myNumbersA.b}
    def sumUmn: Int = {
      myNumbersA.a * myNumbersA.b}
    def sumDilenie: Int = {
      myNumbersA.a / myNumbersA.b}

  }
 val m = MyNumbersA(12,2)
 println( m.sumPlus)}



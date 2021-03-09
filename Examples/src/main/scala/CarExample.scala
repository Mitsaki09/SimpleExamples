object CarExample extends App{

  sealed class ColorVar
  case object Blue extends ColorVar
  case object Yellow extends ColorVar
  case object Green extends ColorVar

  class Car(color:ColorVar,brand:String,price:Int){

    def getcolor: ColorVar={
      color}
    def getprice: Int={
      price}
    def getbrand: String={
      brand}
    def namesupercar: String={
      "super " + brand}
    def getpref(prefix:String):String={
      prefix + brand}

  }



  val car1 = new Car(Blue,"BMW",1200000)
 println(car1.getbrand+car1.getcolor+car1.getpref("yes ")+car1.getprice+car1.namesupercar)

}

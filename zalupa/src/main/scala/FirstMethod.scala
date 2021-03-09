object FirstMethod extends App  {

  def sayHello(name:String)={
    println("Привет,"+name)
  }


sayHello("Амина")
sayHello("Родион")



  def sayAge(age:Int)= {
    println("тебе,"+age)

  }
  sayAge( 2 )
  sayAge( 3 )



  def sayHelloAndAge(name:String,age:Int)={
    println("Привет,"+name)
    println("тебе,"+age)

  }
  sayHelloAndAge ("Амина",2)
  sayHelloAndAge ("Родион",3)
}



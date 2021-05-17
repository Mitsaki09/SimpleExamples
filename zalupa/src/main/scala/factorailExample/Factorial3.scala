package factorailExample

import scala.annotation.tailrec

object Factorial3 extends App {

/*  def ghoul(startNumber: Int, numberToMinus: Int): Unit = {
    if (startNumber <= 0) println("Я гуль")
    else {
      println(startNumber + " - " + numberToMinus)
      ghoul(startNumber - numberToMinus, numberToMinus)
    }
  }
  println(ghoul(1000,7))

  */

/*
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Calculating factorial of " + n + " - Need to know the factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Factorial of: " + n)
      result
    }

  println(factorial(100000))*/

def improvedFactorial(n: Int): BigInt = {
  @tailrec
  def factHelper(x: Int, accumulator: BigInt): BigInt =
  if (x <= 1) accumulator
  else factHelper(x-1, x * accumulator)

  factHelper(n, 1)
  }

  println(improvedFactorial(96000))
  }
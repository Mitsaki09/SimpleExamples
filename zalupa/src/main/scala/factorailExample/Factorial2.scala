package factorailExample

object Factorial2 extends App {
def addString(mainString: String, newStringPart: String, countToAdd: Int): String = {
  if (countToAdd == 0) mainString
  else addString(mainString, newStringPart, countToAdd -1) + newStringPart
  }
  println(addString("CS go", "Jopa", 4))
  }

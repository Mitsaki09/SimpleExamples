object ClassWithClassProba {

  sealed class Razmer
  case object big extends Razmer
  case object  low extends Razmer


  sealed class NadoLi
  case object da extends NadoLi
  case object net  extends NadoLi



  class Hilka (val price: Double , val size: Razmer, val nado: NadoLi )
  class Eda (val price: Double , val size: Razmer, val nado: NadoLi)
  class Armor ( val price: Double , val size: Razmer, val nado: NadoLi)


  class Invent (val hilka : Hilka , val eda: Eda, val armor: Armor)


  val zelle = new Hilka ( 214, low, da)
  val eda = new Eda ( 14, big,net)
  val armor = new Armor ( 14, low, da)




}

object WeaponExample extends App {


  sealed class TypeCartridges
  object TypeCartridges {
    case object ordinary extends TypeCartridges
    case object explosive extends TypeCartridges
    case object armorPiercing extends TypeCartridges
  }



  class Vintovka(name: String, countCartridges: Int, typeCartridges: Option[TypeCartridges]) {


    def StrName: String = {

      name

    }

    def StrCountCartridges: Int = {


      countCartridges
    }

    def StrTypeCartridges: Option[TypeCartridges] = {

      typeCartridges

    }

    def HelpCartridgesPrint: Unit= {
      typeCartridges match {
      case None => println ("Сегодня не постреляем")
      case Some (TypeCartridges.ordinary) => println ("Ща жахну")
      case Some (TypeCartridges.explosive) => println ("вам пиздец")
      case Some (TypeCartridges.armorPiercing) => println ("хана броне")

    }}

    def HelpCartridges: String= {
      typeCartridges match {
        case None => "Сегодня не постреляем"
        case Some (TypeCartridges.ordinary) => "Ща жахну"
        case Some (TypeCartridges.explosive) => "вам пиздец"
        case Some (TypeCartridges.armorPiercing) => "хана броне"
      }}

  }







}

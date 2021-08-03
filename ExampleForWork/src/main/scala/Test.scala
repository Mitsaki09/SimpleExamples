object Test extends App {

  trait Building {
    def floors: Int

    def area: Double
  }

  trait Hospital {
    this: Building =>
  }

  trait School {
    this: Building =>
  }

  trait Jail {
    this: Building =>
  }

  class Occupant(val dick: Boolean)

  class Sick(dick: Boolean) extends Occupant(dick)

  class Schoolboy(dick: Boolean) extends Occupant(dick)

  class Criminal(dick: Boolean) extends Occupant(dick)


  class MainSchool(val sp:Seq[Schoolboy],val criminal: Criminal) extends School with Building{
    override def floors: Int = ???

    override def area: Double = ???
  }
  class MainHospital(val sp1:Seq[Sick], val sp2:Seq[Schoolboy]) extends Hospital with Building{
    override def floors: Int = ???

    override def area: Double = ???
  }

  class MainJail(val sp:Seq[Criminal]) extends Jail with Building{
    override def floors: Int = ???

    override def area: Double = ???
  }
}
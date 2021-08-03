import com.typesafe.config.ConfigFactory

object ConfigsExample extends App {

  val config = ConfigFactory.load() // Автоматически загружает src/main/resources/application.conf . Если надо загрузить, то надо указать в параметрах путь

  println(config.getInt("example.a"))

  case class StrInt(str:String,in:Int)
  val strInt = StrInt(config.getString("example.b"),config.getInt("example.a"))
  val strInt2 = StrInt(config.getString("example2.b"),config.getInt("example2.a"))



}

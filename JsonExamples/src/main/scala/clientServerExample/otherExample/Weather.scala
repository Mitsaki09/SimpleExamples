package clientServerExample.otherExample

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpMethods, HttpRequest, HttpResponse}
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.ActorMaterializer
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object GetWeather extends App {

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()


  val request = HttpRequest(
    method = HttpMethods.GET,
    uri = "http://api.openweathermap.org/data/2.5/weather?q=Kharkiv,UA&appid=ca0befed849f89da86234c4b27b9569b"
  )

  val resultFuture: Future[HttpResponse] = Http().singleRequest(request)
  val result: HttpResponse = Await.result(resultFuture, Duration.Inf)

  println(result)
  println("code: " + result.status)

  val classFuture: Future[Info] = Unmarshal(result.entity).to[Info]
  val info = Await.result(classFuture, Duration.Inf)
  println(info)


}
//               НА ЭТОТ JSON МЫ ДЕЛАЕМ ВСЁ , обрати внимание, некоторые строки выглядят как кейс классы, то есть ты можешь увидеть что идёт название, а снизу пишется поля пример ниже
//{                                           пример1
//	"coord": {                начало
//		"lon": 36.25,            case class coord(lon:Double,lat:Int)  вот как выглядит это по нашему
//		"lat": 50
//	},                       конец
//	"weather": [{
//		"id": 800,
//		"main": "Clear",
//		"description": "clear sky",
//		"icon": "01d"
//	}],                                      пример2
//	"base": "stations",             val base:String    целая строка, вот как это выглядит у нас
//	"main": {
//		"temp": 287.14,
//		"feels_like": 285.59,
//		"temp_min": 287.14,
//		"temp_max": 287.14,
//		"pressure": 1030,
//		"humidity": 38
//	},
//	"visibility": 10000,
//	"wind": {
//		"speed": 2,
//		"deg": 320
//	},
//	"clouds": {
//		"all": 0
//	},
//	"dt": 1631002320,
//	"sys": {
//		"type": 1,
//		"id": 8905,
//		"country": "UA",
//		"sunrise": 1630983543,
//		"sunset": 1631030844
//	},
//	"timezone": 10800,
//	"id": 706483,
//	"name": "Kharkiv",
//	"cod": 200
//
            // почему мы не создаём кейс класс для поля name?Потому что это поле, у которого есть тип
//           почему мы делаем кейс классы ?В json привычные нам кейс классы выглядят как в первом примере выше , чтобы их использовать в скала, мы должны для них создать НАШИ КЕЙС КЛАССЫ И УКАЗАТЬ ПОЛЯ
case class CoordInfo(lon:Double,lat:Double)
case class WeatherInfo(id: Long, main: String, description: String)   // ЭТО КЕЙС КЛАСС weather В JSON(смотри выше)
case class MainInfo(temp:Double,feels_like:Double,temp_min:Double,temp_max:Double,pressure:Long,humidity:Long)
case class WindInfo (speed:Long,deg:Long)
case class CloudsInfo(all:Long)
case class SysInfo(`type`:Long,id:Long,country:String,sunrise:Long,sunset:Long)


object CoordInfo {
  implicit val encoder: Encoder[CoordInfo] = deriveEncoder[CoordInfo]
  implicit val decoder: Decoder[CoordInfo] = deriveDecoder[CoordInfo]
}
object WeatherInfo {
  implicit val encoder: Encoder[WeatherInfo] = deriveEncoder[WeatherInfo]
  implicit val decoder: Decoder[WeatherInfo] = deriveDecoder[WeatherInfo]
}
object MainInfo {
  implicit val encoder: Encoder[MainInfo] = deriveEncoder[MainInfo]
  implicit val decoder: Decoder[MainInfo] = deriveDecoder[MainInfo]
}
object WindInfo {
  implicit val encoder: Encoder[WindInfo] = deriveEncoder[WindInfo]
  implicit val decoder: Decoder[WindInfo] = deriveDecoder[WindInfo]
}
object CloudsInfo {
  implicit val encoder: Encoder[CloudsInfo] = deriveEncoder[CloudsInfo]
  implicit val decoder: Decoder[CloudsInfo] = deriveDecoder[CloudsInfo]
}
object SysInfo {
  implicit val encoder: Encoder[SysInfo] = deriveEncoder[SysInfo]
  implicit val decoder: Decoder[SysInfo] = deriveDecoder[SysInfo]
}

case class Info(coord:CoordInfo,weather: Seq[WeatherInfo],base:String,main:MainInfo,visibility:Long,wind:WindInfo,clouds:CloudsInfo, dt:Long,sys:SysInfo,timezone:Long,id:Long,name: String,cod:Long)//в этот кейс класс мы вставляем поля,классы
//которые хотим увидеть.Если мы сюда запишем поле, кейс класс, то мы его увидем. Если мы не указали поле name, то оно не будет отображаться

object Info {
  implicit val encoder: Encoder[Info] = deriveEncoder[Info]
  implicit val decoder: Decoder[Info] = deriveDecoder[Info]
}

// https://openweathermap.org/api
// https://blog.rockthejvm.com/a-5-minute-akka-http-client/
// https://jsonlint.com/
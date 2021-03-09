object Time extends  App {
  import java.time.{ZonedDateTime, ZoneOffset}
  import java.time.format.DateTimeFormatter

  val datetime = ZonedDateTime.now(ZoneOffset.UTC)
  val formatter = DateTimeFormatter.RFC_1123_DATE_TIME

  datetime.format(formatter)

  println(datetime)
}

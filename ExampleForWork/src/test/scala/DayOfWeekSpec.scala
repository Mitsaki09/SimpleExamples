import exampleForTest.DayOfWeek
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class DayOfWeekSpec extends AnyFlatSpec with Matchers {

  "dayOfWeek1" should "проверяем что Понедельник" in new TestDayOfWeek {


    val expectedResult = "Понедельник"
    val result = testDayOfWeek.week(1)

    result shouldBe expectedResult
  }


  "dayOfWeek2" should "проверяем что Вторник" in new TestDayOfWeek {


    val expectedResult = "Вторник"
    val result = testDayOfWeek.week(2)

    result shouldBe expectedResult
  }
  "dayOfWeek3" should "проверяем что Среда" in new TestDayOfWeek {


    val expectedResult = "Среда"
    val result = testDayOfWeek.week(3)

    result shouldBe expectedResult
  }
  "dayOfWeek4" should "проверяем что Четверг" in new TestDayOfWeek {


    val expectedResult = "Четверг"
    val result = testDayOfWeek.week(4)

    result shouldBe expectedResult
  }
  "dayOfWeek5" should "проверяем что Пятница" in new TestDayOfWeek {


    val expectedResult = "Пятница"
    val result = testDayOfWeek.week(5)

    result shouldBe expectedResult
  }
  "dayOfWeek6" should "проверяем что Суббота" in new TestDayOfWeek {


    val expectedResult = "Суббота"
    val result = testDayOfWeek.week(6)

    result shouldBe expectedResult
  }
  "dayOfWeek7" should "проверяем что Воскресенье" in new TestDayOfWeek {


    val expectedResult = "Воскресенье"
    val result = testDayOfWeek.week(7)

    result shouldBe expectedResult
  }

  class TestDayOfWeek {
    val testDayOfWeek = new DayOfWeek

  }
}


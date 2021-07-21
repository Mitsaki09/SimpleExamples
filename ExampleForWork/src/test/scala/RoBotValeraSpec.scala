import exampleForTest.RoBotValera
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RoBotValeraSpec extends AnyFlatSpec with Matchers {
  "name" should "имя Валера" in new TestWiring {
    val expectedResult = "Valera"
    val result = roBotValera.name
    result shouldBe expectedResult
  }
  "doYouLike" should "v = Баунти" in new TestWiring {
    val expectedResult = "Баунти"
    val result = false
    expectedResult shouldBe result
  }
  "doYouLike" should "v = Смазка" in new TestWiring {
    val expectedResult = "Смазка"
    val result = true
    expectedResult shouldBe result
  }
  "isLexa" should "LEXA" in new TestWiring {

    val expectedResult = "имя по умолчанию"
    val result = roBotValera.isLexa(None)
    result shouldBe expectedResult
  }
  "doYouKnowMe" should "по итогу Привет Свин Свиновский Свинович" in new TestWiring {

    val expectedResult = Some("Привет Свин Свиновский Свинович")
    val result = roBotValera.doYouKnowMe(Some("Свин"),Some("Свиновский"),Some("Свинович"))
    result shouldBe expectedResult
  }

    class TestWiring {
    val roBotValera = new RoBotValera


}
}
import exampleForTest.{ForTesting, Snikers}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SnikersSpec extends AnyFlatSpec with Matchers {

  "stepenVKvadrate" should "Првоеряем что в итоге у метода выйдет 10" in new WriteClassWithPackageSnikers {
    val stepenVKvadrateResult = 25
    val result1 = forTesting.stepenVKvadrate(5)
    result1 shouldBe stepenVKvadrateResult
  }

  "idToName" should "Првоеряем что id 200" in new WriteClassWithPackageSnikers {
    val idToNameResult = forTesting.idToName(200)
    idToNameResult shouldBe Some("John")
  }


  "eatOneCandyFromSnikers" should "Првоеряем что снмкерсво больше 1 " in new WriteClassWithPackageSnikers {
    val eatOneCandyFromSnikersResult = forTesting.eatOneCandyFromSnikers(snikers)
    eatOneCandyFromSnikersResult shouldBe Snikers(1)
  }



  }

class WriteClassWithPackageSnikers{

val forTesting = new ForTesting
  val snikers = Snikers(2)

}
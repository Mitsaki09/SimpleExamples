import org.scalatest.flatspec.AnyFlatSpec
import exampleForTest.GiveMoney
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
class GiveMoneySpec extends AnyFlatSpec {
  "isReadyForMoney1" should "Проверяем что имя Sakura" in new WriteClassWithOtherFile {

    val isReadyForMoneyResult = "Sakura"
    val result1 = giveMoneyName(isReadyForMoneyResult)
    result1 shouldBe true
  }
  "isReadyForMoney2" should "Проверяем что имя JoJo" in new WriteClassWithOtherFile {

    val isReadyForMoneyResult = "Jojo"
    val result2 = giveMoneyName(isReadyForMoneyResult)
    result2 shouldBe true
  }
  "isReadyForMoney3" should "Проверяем что имя Валера" in new WriteClassWithOtherFile {

    val isReadyForMoneyResult = "Валера"
    val result3 = giveMoneyName(isReadyForMoneyResult)
    result3 shouldBe false
  }


  "getDmgToHero" should "Проверяем что хп есть" in new WriteClassWithOtherFile {


    val result4 = getDmgToHero(heroHp,dmgs)
    result4 shouldBe 79
  }

  "getDmgToAliveHero" should "Проверяем что хп больше 0" in new WriteClassWithOtherFile {


    val result5 = giveMoney.getDmgToAliveHero(heroHp,dmgs)
    result5 shouldBe 79
  }


}


class WriteClassWithOtherFile {
  val giveMoney = new GiveMoney
  val giveMoneyName = giveMoney.isReadyForMoney(_)
  val getDmgToHero = giveMoney.getDmgToHero(_,_)
  val getDmgToAliveHero = giveMoney.getDmgToAliveHero(_,_)
  val heroHp = 100
  val dmgs = Seq(1,2,3,4,5,6)


}
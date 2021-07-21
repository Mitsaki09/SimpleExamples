import exampleForTest.{ForExtraTesting}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ExtraTestingSpec extends AnyFlatSpec with Matchers {
  "ubratProbelu" should "Првоеряем что вначале и в конце нет пробелов" in new ForExtraTestingDef {

    val str1 = " Амина любит картошку"

    val ubratProbeluResult1 = "Амина любит картошку"
    val forExtraTestingWork1 = forExtraTesting.ubratProbelu(str1)
    forExtraTestingWork1 shouldBe ubratProbeluResult1
  }

  "sBolsheiBUkvu" should "Првоеряем что toUpperCase" in new ForExtraTestingDef {

    val str2 = "Амина любит картошку"

    val sBolsheiBUkvu2 = "АМИНА ЛЮБИТ КАРТОШКУ"
    val forExtraTestingWork2 = forExtraTesting.sBolsheiBUkvu(str2)
    forExtraTestingWork2 shouldBe sBolsheiBUkvu2
  }
  "maxFromSeq" should "Првоеряем что  передаёт макс значение" in new ForExtraTestingDef {

    val str3 = Seq(1, 2, 3, 4)

    val maxFromSeqResult3 = Some(4)
    val forExtraTestingWork3 = forExtraTesting.maxFromSeq(str3)
    forExtraTestingWork3 shouldBe maxFromSeqResult3
  }
  "givePoZubamgivePoZubamLongName" should "Првоеряем что значение > или = 6" in new ForExtraTestingDef {

    val str4 = forExtraTesting.givePoZubam("Оруспуджуджу")
    val forExtraTestingWork3 = "Тебе повезло Оруспуджуджу , ты не Джамшут"
    val ubratProbeluResult3 = forExtraTesting.givePoZubam(str4)
    forExtraTestingWork3 shouldBe ubratProbeluResult3
  }

  class ForExtraTestingDef {
    val forExtraTesting = new ForExtraTesting
  }
}
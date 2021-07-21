import exampleForTest.{Computer, Summator}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
//AnyFlatSpec - ключевое слово для создания Тестового файла (тоже самое что и App)

class SummatorSpec extends AnyFlatSpec with Matchers {

  "sum" should "складывать два числа" in new TestWiring { // первое что мы пишем в "" это название теста ,
    // should - ключевое слово, после которого мы в "" пишем отметкой для себя что долежн делать тест

    val expectedResult = 30 // тут мы создаём тело в котором пишем итог
    val result = summator.sum(10, 20) // тут мы пишем каким образом должно пойти вычисление на итог

    result shouldBe expectedResult // первым делом мы пишем каким образом должно пойти вычисление, дальше ключевым словом shouldBe(что означает должно быть как) показываем чему оно ровняется по итогу
  }

  it should "складывать два числа с негативным значением" in new TestWiring {// если мы хотим соединить два разных результата на тест в одном, то мы пишем it should далее пишем в ""
    // заметку для себя что тест должен сделать  , ключевое слово in(относится) new(новое) название теста к которому относится
    val expectedResult = -30 // что должно быть в итоге
    val result = summator.sum(-10, -20) // каким образом это получаем

    result shouldBe expectedResult // создание рещения сравниваем с ответом
  }

  "createComputer" should "создавать экземпляр класса exampleForTest.Computer" in new TestWiring {// первое что мы пишем в "" это название теста ,
    // should - ключевое слово, после которого мы в "" пишем отметкой для себя что долежн делать тест

    //если у нас есть несколько переменных ,у которых одинаковое значение, мы можем создать переменную, которая хранит это повторяющееся значение ( пример с computerName и computerPrice)

    val computerName = "Apple"//повторяющееся значение
    val computerPrice = 2000.0//повторяющееся значение

    val expectedResult = Computer(computerName, computerPrice) // пример того, как мы можем использовать повторяющееся значение
    val result = summator.createComputer(computerName, computerPrice)

    result shouldBe expectedResult
  }


  // мы создали класс TestWiring внутри которого находится класс из другого файла( нажми ctrl + левый клик на exampleForTest.Summator снизу)  чтобы мы могли его добавлять во все тесты выше
  // когда писали in new TestWiring
  class TestWiring {
    val summator = new Summator()
  }

}
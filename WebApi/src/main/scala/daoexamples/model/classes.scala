package daoexamples.model

case class InnerClass(a: Int, b: String)


case class TestClass(id: Option[Int],
                     someString: String,
                     someOptionString: Option[String],
                     innerClass: InnerClass, // если у нас есть класс внутри класса, то мыдолжны сохранить поля класса с какой-то припискеой
                    // inner_class_a
                    // inner_class_b
                     optionInnerClass: Option[InnerClass])
                    // option_inner_class_b
                    // option_inner_class_a

object OperationType  {
sealed class Oper
  case object addition extends Oper
  case object subtraction extends Oper
  case object division extends Oper
  case object multiplication extends Oper
}

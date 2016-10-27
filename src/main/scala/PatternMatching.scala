
//** Scala’s pattern matching statement is most useful for matching on algebraic types expressed via case classes.

object MatchTest1 extends App {

  def matchTest(x: Int):String = x match{
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

  println(matchTest(3))

  def matchTest2(x: Any): Any = x match{
    case 1 => "one"
    case "two" => 2
    case y:Int => "scala.Int"
  }

  println(matchTest2(1))

}

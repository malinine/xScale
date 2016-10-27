

//** The apply method is not necessary for pattern matching.It is only used to mimick a constructor.
//** The pattern case Twice(n) will cause an invocation of Twice.unapply
object Twice {
  def apply(x: Int): Int = x * 2
  def unapply(z: Int): Option[Int] = if(z%2 == 0) Some(z/2) else None
}

object TwiceTest extends App {
  val x = Twice(21)
  x match {
    case Twice(n) => Console.println(n)
  }
}




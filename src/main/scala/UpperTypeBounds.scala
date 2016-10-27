
//** upper type bound limit a type to a subtype of another type.
trait Similar{
  def isSimilar(x: Any): Boolean
}

//** Use the asInstanceOf method to cast an instance to the desired type.
//** It is equivalent to the following JAVA code:
//** Recognize recognizer = (Recognize) cm.lookup("recognizer")
case class MyInt(x: Int) extends Similar{
  override def isSimilar(m: Any): Boolean =
    m.isInstanceOf[MyInt] && m.asInstanceOf[MyInt].x == x
}

//** An upper type bound T <: A declares that type variable T refer to
//** a subtype of type A.
//** Without the upper type bound annotation it would not be possible to call
//** method isSimilar in method findSimilar.
object UpperTypeBoundTest extends App {
  def findSimilar[T <: Similar](e: T, xs: List[T]): Boolean =
    if (xs.isEmpty) false
    else if (e.isSimilar(xs.head)) true
    else findSimilar[T](e, xs.tail)
  val list: List[MyInt] = List(MyInt(1), MyInt(2), MyInt(3))
  println(findSimilar[MyInt](MyInt(4),list))
  println(findSimilar[MyInt](MyInt(2),list))
}


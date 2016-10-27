
//** Abstract Types are types whose identity is not precisely known.
//** In Scala, type parameters and abstract types may be constrained by a type bound.
trait Buffer {
  type T
  val element: T
}

abstract class SeqBuffer extends Buffer {
  type U
  type T <: Seq[U]
  def length = element.length
}

abstract class IntSeqBuffer extends SeqBuffer{
  //type U = Int
}

//** You cannot directly instantiate an abstract class,
//** but you can create an anonymous class when there is no concrete class.
object AbstractTypeTest1 extends App {
  def newIntSeqBuf(elem1: String, elem2: String): IntSeqBuffer =
    new IntSeqBuffer {
      type U = String
      type T = List[U]
      val element = List(elem1,elem2)
    }
  val buf = newIntSeqBuf("7","8")
  println("length = "+buf.length)
  println("content = "+buf.element)
}


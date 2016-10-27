package test

// ** Singleton objects are sort of a shorthand for defining a single-use class,which can't directly be instantiated
// ** A singleton object can extend classes and traits.
// ** Most singleton objects do not stand alone, but instead are associated with a class of the same name.

// ** In fact, a case class with no type parameters will by default create a singleton object of the same name.

object Blah {
  def sum(l: List[Int]): Int = l.sum
}

class IntPair(val x: Int, val y: Int)

object IntPair{
  import math.Ordered

  implicit def ipord: Ordering[IntPair] =
    Ordering.by(ip => (ip.x, ip.y))
}
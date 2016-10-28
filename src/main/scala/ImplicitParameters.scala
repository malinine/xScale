

//** The implicit keyword indicates that We can implicitly find whichever val or object
//** in the current scope.
abstract class SemiGroup[A]{
  def add(x: A,y: A): A
}

abstract class Monoid[A] extends SemiGroup[A]{
  def unit: A
}

object ImplicitTest extends App{

  implicit object StringMonoid extends Monoid[String]{
    def unit: String = ""
    def add(x: String, y: String): String = x concat y
  }


  implicit object IntMonoid extends Monoid[Int]{
    def unit: Int = 0
    def add(x: Int,y: Int): Int = x + y
  }

  def sum[A](xs: List[A])(implicit m: Monoid[A]): A =
    if (xs.isEmpty) m.unit
    else m.add(xs.head,sum(xs.tail))

  println(sum(List(1,2,3)))
  println(sum(List("a","b","c")))

}


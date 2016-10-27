
// ** Higher-Order Functions are functions that take other function as parameter,
// ** or whose result is a functions.

class Decorator(left: String, right: String){
  def layout[A](x: A) = left + x.toString + right
}

object FuncTest extends App {
  def apply(f: Int => String, v: Int) = f(v)
  val decorator = new Decorator("[","]")
  println(apply(decorator layout,7) )
}

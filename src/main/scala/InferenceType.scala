
//** In scala not necessary specify the type of a variable, since the compiler can deduce
//** the type from the initialization expression of the variable. Also return types of
//** method

object InferenceType extends App {
  val x = 1 + 2 *3
  val y = x.toString
  def succ(x: Int) = x + 1
  println(succ(10))
}

//** For recursive methods, the compiler is not able to infer a result type.
//object InferenceTest2 {
//  def fac(n: Int) = if (n == 0) 1 else n * fac (n - 1)
//}


//** As the following line shows, the programmer is not required to give actual type parameters explicitly

object PolymophicMethodTest extends App {

  def dup[T](x: T,n: Int): List[T] = {
    if(n == 0)
      Nil
    else
      x :: dup(x,n-1)
  }

  println(dup[Int](3,4))
  println(dup("three",3))

}

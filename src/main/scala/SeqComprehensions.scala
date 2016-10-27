
//** Comprehensions have the form for (enumerator) yield e ,
//** where enumerator refer to a semicolon-separated list of enumerators.

object SeqComprehensionsTest extends App {
  def even(from: Int, to: Int): List[Int] =
    for (i <- List.range(from,to) if i%2 == 0) yield i
  println(even(0,20))
}

//** There is also a special form of sequence comprehension which returns Unit.
//** Here the bindings that are created from the list of generators and filters are used to perform side-effects.

object SeqComprehensionsTest2 extends App {
  def foo(n: Int, v: Int) =
    for (i <- 0 until n;
         j <- i until n if i + j == v)
    yield (i,j)
  foo(20,32) foreach {
    case (i,j) => println(s"($i,$j)")
  }
}

object SeqComprehensionsTest3 extends App {
  for (i <- Iterator.range(0,20);
       j <- Iterator.range(i,20) if i+j == 32 )
  println(s"($i,$j)")
}

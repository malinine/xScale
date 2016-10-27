
//** In object-oriented programming languages,
//** a mixin is a class that contains a combination of methods from other classes.
//** How such a combination is done depends on the language.
//** If a combination contains all methods of combined classes,
//** it is equivalent to multiple inheritance.

abstract class AbsIterator{
  type T
  def hasNext: Boolean
  def next: T
}

trait RichIterator extends AbsIterator{
  def foreach(f: T => Unit){ while(hasNext) f(next) }
}

class StringIterator(s: String) extends AbsIterator {
  type T = Char
  private var i =0
  def hasNext = i < s.length()
  def next = { val ch = s charAt i; i += 1; ch }
}

object StringIteratorTest {
  def main(args: Array[String]): Unit ={

    //** The first parent is called the superclass of Iter,
    //** whereas the second (and every other, if present) parent is called a mixin.

    class Iter extends StringIterator(args(0)) with RichIterator
    val iter = new Iter

    iter foreach println
  }

  StringIteratorTest.main(Array("Testing"))
}

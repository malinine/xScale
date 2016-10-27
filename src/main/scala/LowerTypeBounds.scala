
//** Lower type bounds declare a type to be a supertype of another.
case class ListNode[+T](h: T,t: ListNode[T]){
  def head: T = h
  def tail: ListNode[T] = t
  def prepend[U >: T](elem: U): ListNode[U] = ListNode(elem, this)
}

//** case class ListNode[+T](h: T, t: ListNode[T]) { ... }
//** this program does not compile,because a covariance annotation is only possible
//** if the type variable is used only in covariant position

object LowerTypeBoundsTest extends App {
  val empty: ListNode[Null] = ListNode(null, null)
  var strList: ListNode[String] = empty.prepend("hello")
                                        .prepend("world")
  var anyList: ListNode[Any] = strList.prepend(12345)

  //println(S)

}

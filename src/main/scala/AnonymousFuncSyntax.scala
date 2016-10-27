


object AnonymousFuncSyntax {

    val function0 = (x: Int) => x + 1
    new Function1[Int,Int]{
      def apply(x :Int): Int = x +1
    }
    var function2 = () => println("12345")


    def main(args: Array[String]): Unit = {
      println(function0(5))
      println(function2())
    }

}

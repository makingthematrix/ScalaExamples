package upforgrabs

case class Foo(n: Int)

object SCL24374 {
  def add(n: Int, arg1: Foo, arg2: Int => Foo, p: Int): Int = n + p

  @main def main(): Unit = {
    // 1. add a second parameter, e.g. add(1, 2)
    // 2. Show context actions
    // 3. A new context action should add the parameter with its inferred type to the method
    val r = (x: Int) => Foo(x)
    val res = add(1, Foo(1), r, 2)

    println(res)
  }
}

package upforgrabs

// Inspection: use placeholder syntax for anonymous function
// https://youtrack.jetbrains.com/issue/SCL-10330/Inspection-use-placeholder-syntax-for-anonymous-function
object SCL10330 {
  def f(n: Int, x: Int): Int = n + x
  def f(x: Int): Int = x
  case class A(b: Int)

  def foo(): Unit = {
    val seq: Seq[A] = Seq(A(1))
    seq.map(a => a.b) // to _.b

    val f1: A => Int = a => a.b // to _.b
    val f2: ((Int, Int) => String) = (x, y) => x.toString + y.toString
    val f3: (Int => Int) = x => f(1, x) // to f(1, _)
    val f4: (Int => Int) = x => f(x) // to f(_)
  }
}

import scala.util.Random

object LazyVal:
  lazy val foo: Int = Random.nextInt(10)

  def main(): Unit = {
    val bar = foo + foo
    assert(bar / foo == 2)
    println(bar)
  }

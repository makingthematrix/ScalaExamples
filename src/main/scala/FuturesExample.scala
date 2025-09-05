import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object FuturesExample:
  private var attempt = 0

  def main(): Unit =
    val f = asyncComputation()
    f.foreach(printResult)
    Thread.sleep(1000)

  private def computeSomething(): String =
    val fail = attempt < 3

    if (fail) then
      attempt += 1
      throw new Exception("oops")
    else "Hooray!" //set breakpoint here

  private def asyncComputation(): Future[String] =
    val f1 = Future(computeSomething())
    f1.recoverWith:
      case _: Throwable =>
        asyncComputation()

  private def printResult(s: String): Unit =
    println(s) //or here

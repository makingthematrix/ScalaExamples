import scala.concurrent.duration.*
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.Random

object FutureExample:
  given ExecutionContext = scala.concurrent.ExecutionContext.global

  private def generateASequence(n: Int): Seq[(Int, Int)] =
    (0 to n)
      .map: i =>
        (Random.between(50, 250), Random.nextInt(100))

  private def delay(millis: Long): Future[Unit] =
    Future:
      Thread.sleep(millis)

  def main(): Unit =
    val seqShort = generateASequence(5).zipWithIndex
    var sumShort: Int = 0
    val seqLong = generateASequence(15).zipWithIndex
    var sumLong: Int = 0

    val offset = System.currentTimeMillis()

    val runShort = Future.traverse(seqShort) { case ((d, n), i) =>
      val f = delay(d * 2).map(_ => (i, n))
      f.foreach: (i, n) =>
        println(s"Short run #${i + 1} at ${System.currentTimeMillis() - offset}: $sumShort + $n = ${sumShort + n}")
        sumShort += n
      f
    }

    val runLong = Future.traverse(seqLong) { case ((d, n), i) =>
      val f = delay(d).map(_ => (i, n))
      f.foreach: (i, n) =>
        println(s"Long run #${i + 1} at ${System.currentTimeMillis() - offset}: $sumLong + $n = ${sumLong + n}")
        sumLong += n
      f
    }

    val run = for {
      _ <- runShort
      _ <- runLong
    } yield ()

    Await.ready(run, 5.minutes)

    println(s"sumShort: $sumShort")
    println(s"sumLong: $sumLong")

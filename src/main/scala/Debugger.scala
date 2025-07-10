import scala.annotation.tailrec

@tailrec
def printAndProcess(n: Int, f: Int => Int): Unit = {
  println(n)
  if n > 1 then printAndProcess(f(n), f)
}

/*@main
def main(): Unit =
  printAndProcess(

    5,
    { n => if n % 2 == 0 then n / 2 else n + 3 }
  )*/







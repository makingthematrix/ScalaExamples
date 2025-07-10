package releasenotes

class PrintInt (n: Int):
  def print: Unit = println(s"int $n")

extension (n: Int)
  def fff = PrintInt(n)
  export fff.print

@main def main(): Unit =
  1.print


object InlayHints {
  // Parameter name hints
  private def parameter(enabled: Boolean): Unit =
    setParameterInDB(Map(("enabled", enabled)))

  parameter(true)
  parameter(false)

  private def setParameterInDB(map: Map[String, Boolean]): Unit =
    map.foreach {
      (name, b) => println(s"$name -> $b")
    }
    
  class Foo(a: Int, b: String) {
    def this(a: Int) = this(a, "bar")
    private val c = 1
  }

  def main(): Unit = {
    val foo = Foo(1, "1")
    println(foo)
  }
    
  // Type hints
  private val foo = 1 + 2 // Field
  Seq(1, 2, 3).map(x => x + 1)       // Lambda parameter
  Seq(1, 2, 3).map(_ + 1)            // Lambda placeholder
  private val (x, y) = (1, 2)        // Variable pattern
  val sum: Int = (foo, x, y) match { // Pattern matching
      case (a, b, c) => a + b + c
  }

  private val words = Seq("a", "sequence", "of", "words")

  words
    .view
    .map(_.length)
    .filter(_ > InlayHints.sum)
    .toSeq
    .distinct
    .headOption
    .getOrElse(0)
  
  enum Numbers {
    case One, Two, Three
  }
  
  import Numbers.*
  given Ordering[Numbers] = (x: Numbers, y: Numbers) =>
    if x == y then 0 else x match {
      case One             => -1
      case Two if y == One => 1
      case Two             => -1
      case Three           => 1
    }

  Seq(Two, Three, One).sorted
  
  // By-name argument hints
  private def inReadAction[A](code: => A): A = code
  inReadAction(println("foo"))


}

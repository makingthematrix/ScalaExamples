package upforgrabs

// Desugar for-comprehension with new changes results in broken code
// https://youtrack.jetbrains.com/issue/SCL-23361/Desugar-for-comprehension-with-new-changes-results-in-broken-code
object SCL23361 {
  def foo(): Unit = {
    val e = List("3", 5, 3)
    val e1 = List("1", 5, 7)

    // Mark the whole for/yield, right-click, choose "Desugar the code" from the bottom of the popup menu
    for case p: Int <- e
        case p1: Int <- e1
    yield (p, p1)
  }
}

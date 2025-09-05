package upforgrabs

// Inspection: convert anonymous function to method value
// https://youtrack.jetbrains.com/issue/SCL-10362/Inspection-convert-anonymous-function-to-method-value
class SCL10362 {
  def f(x: Int): Int = x + 1
  def f(x: Int, y: Int): Int = x + y

  def foo(): Unit = {
    // Write intention actions to convert the following:
    val a = x => f(x) // to f _ or to f (when expected type matches)
    val b = f(_) //  to f _ or to f (placeholder syntax)
    val c = (x, y) => f(x, y) // to f(_, _) and f
  }
}

package upforgrabs

// Single character variable name expanded with "{}" in interpolated string (expected: no "{}")
// https://youtrack.jetbrains.com/issue/SCL-22406/Single-character-variable-name-expanded-with-in-interpolated-string
object SCL22406 {
  private def validator(c: Char): Boolean = true
  private def bad(str: String): Unit = println(str)

  def foo(): Unit = {
    val c: Char = 'x'
    // put the caret just after $c, hit Ctrl+Space, choose `c`.
    if !validator(c) then bad("Unexpected character '$c'.")
  }
}

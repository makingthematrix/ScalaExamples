package upforgrabs

// Extract Variable broken for return values.
// https://youtrack.jetbrains.com/issue/SCL-10365/Extract-Variable-broken-for-return-values.
object SCL10365 {
  class Test {
    def foo: Int = {
      val x = {
        1 + 2 // mark "1 + 2", choose Extract | Variable from the popup
              // error: It introduces `val i = ` but doesn't add `i` in the next line - the code is broken
      }
      x
    }
  }
}

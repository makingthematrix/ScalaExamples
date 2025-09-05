package upforgrabs

// Wrong display of links in ScalaDoc for parameter documentation
// https://youtrack.jetbrains.com/issue/SCL-23082/Wrong-display-of-links-in-ScalaDoc-for-parameter-documentation
object SCL23082 {
  /**
   * @param x see [[B]]
   *
   */
  case class C(x: String)
  // Set the caret after `x`, hit Ctrl+J to open doc popup
  // The link will be generated before "see" - should be after

  class B {
    def b(s: Int): String = {
      s.toString
    }
  }
}

package upforgrabs

// Wrong "Unnecessary parentheses" is shown in a type pattern with function literal
//https://youtrack.jetbrains.com/issue/SCL-21577/Wrong-Unnecessary-parentheses-is-shown-it-type-pattern-with-function-literal
object SCL21577 {
  class A {
    null match {
      case _: (String => String) => // these parentheses are not in fact unnecessary
        1
      case _ =>
        2
    }
  }
}

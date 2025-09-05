package upforgrabs

// handle triple quotes content when pasting into raw string
// https://youtrack.jetbrains.com/issue/SCL-18618/handle-triple-quotes-content-when-pasting-into-raw-string
object SCL18618 {
  val x = """text"""
  // copy the line above and paste it in the middle of each of triple and single quotes below
  """"""
  s""""""
  raw""""""

  ""
  s""
  raw""


}

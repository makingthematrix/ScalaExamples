package upforgrabs

// Highlight substring(0), take(0), drop(0), filter(_ => true) as unused
// https://youtrack.jetbrains.com/issue/SCL-15810/Highlight-substring0-take0-drop0-filter-true-as-unused
object SCL15810 {
  def foo(): Unit = {
    val str: String = "Lorem ipsum"
    val sub = str.substring(0)

    val list: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil
    val a = list.take(0)
    val b = list.drop(0)

    val booleans: List[Boolean] = true :: false :: Nil
    booleans.filter(_ => true)
  }
}

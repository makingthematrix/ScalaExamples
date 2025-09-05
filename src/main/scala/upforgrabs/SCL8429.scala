package upforgrabs

/**
 * take a look at [[SCL20453]]
 */
object SCL8429 {
  def foo(): Unit = {
    val option: Option[Int] = Some(1)
    // 1. Write an inspection that recognizes this
    val res = option.map(it => Seq(it)).getOrElse(Seq.empty)
    // 2. Write an intention action that replaces it with option.toSeq
    // 3. Add the intention action as a quickfix to the inspection
  }
}

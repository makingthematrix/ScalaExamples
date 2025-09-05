package upforgrabs

/**
 * take a look at [[SCL8429]]
 */
object SCL20453{
  def foo(): Unit = {
    val option: Option[Int] = Some(1)
    // 1. Write an inspection that recognizes this
    val res = option.fold(Set.empty)(x => Set(x))
    // 2. Write an intention action that replaces it with option.toSet
    // 3. Add the intention action as a quickfix to the inspection
  }

}

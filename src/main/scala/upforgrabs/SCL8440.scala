package upforgrabs

// Collection inspection: replace take & drop with splitAt
// https://youtrack.jetbrains.com/issue/SCL-8440/Collection-inspection-replace-take-drop-with-splitAt
object SCL8440 {
  def foo(): Unit = {
    val seq: Seq[Int] = Seq(1, 2, 3)
    val n = 2
    // 1. Write an inspection that recognizes such situations as the one below:
    val seq1 = seq.take(n)
    val seq2 = seq.drop(n)
    // 2. Write an intention action to refactor the above into:
    val (seq3, seq4) = seq.splitAt(n)
    // 3. Propose the action as a quickfix in the inspection popup
  }
}

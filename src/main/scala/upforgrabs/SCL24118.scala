package upforgrabs

// Error: A generic parameter changes to Any after the signature refactor
// https://youtrack.jetbrains.com/issue/SCL-24118/Change-generic-parameter-to-Any-after-change-signature-refactor
object SCL24118 {
  trait TraitA[T]

  trait TraitB {
    def method[T](traitA: TraitA[T]): Unit
  }

  /*
  1. Put the caret at `method`, right-click, choose Refactor | Change Signature
  2. Change the return type to `Option[TraitA[T]]`
  3. Click Refactor
   */
}

package upforgrabs

// Enums: Intention for switching between separate cases and one case for all
// https://youtrack.jetbrains.com/issue/SCL-23027/Enums-Intention-for-switching-between-separate-cases-and-one-case-for-all
object SCL23027 {
  enum WeekDay {
    case Mon, Tue, Wed, Thu, Fri, Sat, Sun
  }

  /*
  Implement an intention action to turn the enum above into:
  enum WeekDay {
    case Mon
    case Tue
    case Wed
    case Thu
    case Fri
    case Sat
    case Sun
  }
   */
}

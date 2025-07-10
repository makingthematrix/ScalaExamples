
enum WeekDay(val label: String) extends java.lang.Enum[WeekDay]:
  case Mon extends WeekDay("Monday")
  case Tue extends WeekDay("Tuesday")
  case Wed extends WeekDay("Wednesday")
  case Thu extends WeekDay("Thursday")
  case Fri extends WeekDay("Friday")
  case Sat extends WeekDay("Saturday")
  case Sun extends WeekDay("Sunday")

  def isOnWeekend: Boolean = this == Sat || this == Sun

object WeekDay:
  def hasRInName(day: WeekDay): Boolean = day.label.contains('r')
package releasenotes

import releasenotes.WeekDay.*

enum WeekDay:
  case Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday

def foo(): Unit =
  val day: WeekDay = Monday

  val weekends = Seq(Saturday, Sunday)
  weekends.contains(Tuesday)

  def canParty(day: WeekDay): Boolean = day != Monday
  canParty(Thursday)












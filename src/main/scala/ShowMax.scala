trait Show[A]:
	def asString(a: A): String

trait A:
	def showMax[X : Ordering : Show](x: X, y: X): String = showMax2(x, y)
	def showMax2[X : {Ordering, Show}](x: X, y: X): String

class B extends A:
	def showMax2[X : {Ordering as ordering, Show as show}](x: X, y: X): String =
		show.asString(ordering.max(x, y))
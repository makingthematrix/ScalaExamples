object ContextBounds:
	def foo[T](x: T): T = x





	trait SemiGroup[A]:
		extension (x: A) def combine(y: A): A

	trait Monoid[A] extends SemiGroup[A]:
		def unit: A

	def reduce[A: Monoid as m](xs: List[A]): A =
		xs.foldLeft(m.unit){ (acc, a) => acc.combine(a) }







	trait Show[X]:
		def asString(x: X): String

	trait A:
		def showMax[X: {Ordering, Show}](x: X, y: X): String

	class B extends A:
		def showMax[X: {Ordering as ordering, Show as show}](x: X, y: X): String =
			show.asString(ordering.max(x, y))






	trait Parser[P]:
		type Input
		type Result

	object Parser:
		def run[P : Parser as p](in: p.Input): p.Result = ??? // new syntax
		//def run[P](x: p.Input)(using p: Parser[P]): p.Result  // old syntax




		// The old syntax version does not work, because `x: p.Input` is used before the declaration of `p` in the `using` clause













trait SemiGroup[A]:
	extension (x: A) def combine(y: A): A

trait Monoid[A] extends SemiGroup[A]:
	def unit: A

object Monoid:
	def unit[A](using m: Monoid[A]): A = m.unit

	def reduce[A: Monoid](xs: List[A]): A =
		xs.foldLeft(summon[Monoid[A]].unit) { (acc, x) => acc.combine(x) }

	def reduce2[A](xs: List[A])(using m: Monoid[A]): A =
		xs.foldLeft(m.unit){ (acc, x) => acc.combine(x) }

	def reduce3[A: Monoid](xs: List[A]): A =
		xs.foldLeft(Monoid.unit) { (acc, x) => acc.combine(x) }

	def reduce4[A: Monoid as m](xs: List[A]): A =
		xs.foldLeft(m.unit){ (acc, x) => acc.combine(x) }



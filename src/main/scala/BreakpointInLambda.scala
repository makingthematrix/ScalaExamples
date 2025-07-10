import BreakpointInLambda.{Bar, Foo}

object BreakpointInLambda:
	trait Identifiable[A]:
		def id: A
		def compareWith[B](that: Identifiable[B], compare: (A, B) => Int): Int =
			if this == that then 0 else compare(this.id, that.id)

	class Foo(val id: String) extends Identifiable[String]
	class Bar(val id: Int) extends Identifiable[Int]

	def main(): Unit =
		val res = Foo("foo").compareWith(
			Bar(1),
			(a: String, b: Int) =>
				println("breakpoint")
				a.compareTo(b.toString)
		)
		println(res)






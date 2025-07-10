object XRay:
	class Foo(n: Int, str: String)
	object Foo:
		def apply(str: String): Foo = new Foo(str.length, str)

	def main(args: Array[String]): Unit =
		val hello = "Hello"
		val foo1 = Foo(hello)
		val five = 5
		val foo2 = new Foo(five, hello)

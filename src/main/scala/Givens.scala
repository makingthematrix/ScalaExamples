object Givens:
	trait Ord[T]:
		def compare(x: T, y: T): Int
	end Ord

	class IntOrd extends Ord[Int]:
		override def compare(x: Int, y: Int): Int = math.signum(x - y)
	end IntOrd

	class ListOrd[A](using ord: Ord[A]) extends Ord[List[A]]:
		override def compare(x: List[A], y: List[A]): Int = math.signum(x.size - y.size)
	end ListOrd

	// Simple typeclass
	given intOrd: Ord[Int]:
		def compare(x: Int, y: Int): Int = ???

	// Parameterized typeclass with context bound
	given listOrd: [A: Ord] => Ord[List[A]]:
		def compare(x: List[A], y: List[A]): Int = ???

	// Parameterized typeclass with context parameter
	given listOrd2: [A] => Ord[A] => Ord[List[A]]:
		def compare(x: List[A], y: List[A]): Int = ???

	// Parameterized typeclass with named context parameter
	given listOrd3: [A] => (ord: Ord[A]) => Ord[List[A]]:
		def compare(x: List[A], y: List[A]): Int = ???

	// Simple alias
	//given intOrd: Ord[Int] = IntOrd()

	// Parameterized alias with context bound
	given listOrd4: [A: Ord] => Ord[List[A]] = ListOrd[A]

	// Parameterized alias with context parameter
	given listOrd5: [A] => Ord[A] => Ord[List[A]] = ListOrd[A]

	// By-name given
	given context2: () => Ord[Int] = IntOrd()


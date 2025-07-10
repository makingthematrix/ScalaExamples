object ForComprehensions:

	@main def main(): Unit =
		val xss = List(List(1, 2), Nil, List(3, 4)) // xss is a list of lists
		for {
			case y :: ys <- xss // for each list in xss, y is its first element
		}
			println(y) // we print out only the first elements of each list in xss


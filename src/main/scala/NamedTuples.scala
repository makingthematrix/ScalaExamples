object NamedTuples:
	private type PersonTuple = (name: String, age: Int)
	private val bob: PersonTuple = (name = "Bob", age = 33)
	val janice: (name: String, age: Int, hairColor: String) = ("Janice", 25, "black")
	private val alice: PersonTuple = (name = "Alice", age = 50)

	private val persons: List[PersonTuple] = List(bob, alice)

	persons.foreach(person => println(s"${person.name} is ${person.age} years old."))
	persons.foreach { case (name, age) => println(s"$name is $age years old.") }

	val (name, age) = bob
	println(s"$name is $age years old.")

	private def register(person: PersonTuple): Unit = {}

	register(alice)
	register(bob)
	register((name = "Carl", age = 40))

	persons.foreach:
		case (name = "Bob") => println(s"It's Bob")
		case (name = n) => println(s"It's $n")
	//case (name, _)      => println(s"It's $name")

	bob match
		case (name = "Bob") => println("It's Bob")
		case (name = n) => println(s"It's $n")

	case class PersonClass(name: String, age: Int)

	private object PersonClass:
		def unapply_old(person: PersonClass): (String, Int) =
			(person.name, person.age)

		def unapply_new(person: PersonClass): PersonTuple =
			(name = person.name, age = person.age)

		def unapply_new2(person: PersonClass): Option[(name: String, age: Int)] =
			Some((person.name, person.age))

	private val bobClass = PersonClass("Bob", 33)
	bobClass match
		case PersonClass(bobName, _) => println(bobName) // old syntax for extracting the field `name` as `bobName`
		case bob@PersonClass(_, _) => println(bob.name) // another way
		case PersonClass(name = "Alice") => println("It's Alice")
		case PersonClass(name = bobName) => println(bobName) // new syntax for the same thing (the old ones still work)
	
	


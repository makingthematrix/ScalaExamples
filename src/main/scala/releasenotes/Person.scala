package releasenotes




case class Person (name: String, age: Int, address: AnyRef, children: Seq[Person])

object Person:
  def newPerson(name: String, age: Int, address: AnyRef, children: Seq[Person]): Person = ???

  val Nadia = newPerson(n)

package finished

import SuperpowerLevel.*

enum SuperpowerLevel (val name: String):
	case WEAK extends SuperpowerLevel("weak")
	case MEDIUM extends SuperpowerLevel("medium")
	case STRONG extends SuperpowerLevel("strong")
	case HULK extends SuperpowerLevel("hulk")

object SuperpowerLevel:
	def hasRInName(level: SuperpowerLevel): Boolean = level.name.contains("r")

case class Superhero(name: String, powerLevel: SuperpowerLevel)

def levelUp(hero: Superhero): Option[Superhero] =
	val newLevel =
		if hero.name == "The Hulk" then
			Some(WEAK)
		else
			hero.powerLevel match
				case WEAK   => Some(MEDIUM)
				case MEDIUM => Some(STRONG)
				case STRONG => Some(HULK)
				case HULK   => None
	end newLevel
	newLevel.map:
		powerLevel => Superhero(name = s"Better ${hero.name}", powerLevel = powerLevel)
end levelUp

given Ordering[SuperpowerLevel] with
	override def compare(x: SuperpowerLevel, y: SuperpowerLevel): Int =
		if x == y then 0
		else (x, y) match
			case (WEAK, _) => -1
			case (MEDIUM, STRONG) => -1
			case (MEDIUM, HULK) => -1
			case (STRONG, HULK) => -1
			case _ => 1

type HeroTuple = (name: String, level: SuperpowerLevel)

def register(hero: HeroTuple): Unit = {}

case class HeroClass (name: String, level: SuperpowerLevel):
	transparent inline def customUnapply(inline nameOrPower: Boolean): Any =
		if nameOrPower then name else level

/*object HeroClass:
	def unapply(hero: HeroClass): Option[(String, SuperpowerLevel)] =
		Some((hero.name, hero.level))*/


def main(): Unit =
	val ironMan = Superhero("Iron Man", MEDIUM)
	SuperpowerLevel.values.sorted
	println(ironMan)
	levelUp(ironMan).foreach:
		hero => println(hero)

	val bob: HeroTuple = ("Bob", STRONG)
	val bucky: HeroTuple = ("James Barnes", MEDIUM)
	val yelena: (name: String, level: SuperpowerLevel) = ("Yelena", MEDIUM)
	val heroes: Seq[HeroTuple] = Seq(bob, bucky, yelena)

	register(bob)
	register((name = "Carl", level = STRONG))

	heroes.foreach:
		case (name = "Bob") => println(s"It's Bob")
		case (name, level) => println(s"$name is $level")

	val bobClass = HeroClass("Bob", MEDIUM)
	bobClass match
		case HeroClass(name = "Bob") => println("It's Bob")
		case _ => println("It's not Bob")

	val name = bobClass.customUnapply(nameOrPower = true)
	val power = bobClass.customUnapply(nameOrPower = false)
end main
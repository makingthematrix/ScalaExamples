import SuperpowerLevel.*

@main
def main(): Unit =
	val hero      = Superhero("Iron Man", Medium)
	val leveledUp = levelUp(hero)
	leveledUp.foreach: hero =>
		println(hero)

def levelUp(hero: Superhero): Option[Superhero] =
	val newLevel =
		if hero.name == "The Hulk" then
			Some(Weak)
		else
			hero.level match
				case Weak   => Some(Medium)
				case Medium => Some(Strong)
				case Strong => Some(Hulk)
				case Hulk   => None
	end newLevel
	newLevel.map: level =>
		Superhero(name = s"Better ${hero.name}", level = level)
end levelUp

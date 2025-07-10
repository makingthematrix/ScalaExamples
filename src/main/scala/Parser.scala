trait Parser[P]:
	type Input
	type Result

object Parser:
	//def run_fail[P : Parser](in: p.Input)(using p: Parser[P]): p.Result = ???
	def run[P : Parser as p](in: p.Input): p.Result = ???

package releasenotes

import scala.util.matching.Regex

val keyValPattern1: Regex = """^([0-9a-zA-Z- ]+):\\s+([0-9a-zA-Z-#()/. ]+)$""".r
val keyValPattern2: Regex = Regex("""^([0-9a-zA-Z- ]+):\\s+([0-9a-zA-Z-#()/. ]+)$""")










val keyValPattern: Regex = 
  Regex("""^\/([0-9a-zA-Z- ]+):\\s+([0-9a-zA-Z-#()/. ]+)$""")
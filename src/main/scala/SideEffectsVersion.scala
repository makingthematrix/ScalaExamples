import java.nio.file.{Files, Path}
import scala.jdk.CollectionConverters.*

object SideEffectsVersion {
  @main def main(): Unit = {
    val lines = read(Protagonist.FilePath)
    val protagonists = lines.map(Protagonist.fromLine)
    val n = askForUpdate()
    val updated = protagonists.map(updateAge(_, n))
    val newLines = updated.map(_.toLine)
    write(Protagonist.FilePath, newLines)
  }

  private def read(path: Path): List[String] =
    Files.readAllLines(path).asScala.toList

  private def askForUpdate(): Int = {
    println("By how much should I update the age?")
    val answer = scala.io.StdIn.readLine()
    answer.toInt
  }

  private def updateAge(p: Protagonist, n: Int): Protagonist =
    p.copy(age = p.age + n)

  private def write(path: Path, lines: List[String]): Unit =
    Files.writeString(path, lines.mkString("\n"))
}
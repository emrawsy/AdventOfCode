package Day2

import scala.io.Source

object Day2 extends App {

  val input = Source.fromResource("day2.txt").mkString

  def myTournamentResultTakeTwo(result: String): Int = {
    winLoseDrawScore(replaceB(lettersToTupleList(result))).sum
  }

  def myTournamentResultTakeOne(result: String): Int = {
    winLoseDrawScore(lettersToTupleList(result)).sum
  }

  def winLoseDrawScore(result: Array[(String, String)]): Array[Int] = {
    result.map(x => (x._1.toInt, x._2.toInt))
      .map({
        case (a, b) if b == 1 && a == 3 => b + 6
        case (a, b) if a == 1 && b == 3 => b + 0
        case (a, b) if b < a => b + 0
        case (a, b) if a == b => b + 3
        case (a, b) if a < b => b + 6
      })
  }

  def replaceB(result: Array[(String, String)]): Array[(String, String)] = {
    result.map({
      case (a, b) if a == "1" && b == "1" => (a, b.replace(b, "3"))
      case (a, b) if a == "2" && b == "1" => (a, b.replace(b, "1"))
      case (a, b) if a == "3" && b == "1" => (a, b.replace(b, "2"))
      case (a, b) if a == "1" && b == "2" => (a, b.replace(b, "1"))
      case (a, b) if a == "2" && b == "2" => (a, b.replace(b, "2"))
      case (a, b) if a == "3" && b == "2" => (a, b.replace(b, "3"))
      case (a, b) if a == "1" && b == "3" => (a, b.replace(b, "2"))
      case (a, b) if a == "2" && b == "3" => (a, b.replace(b, "3"))
      case (a, b) if a == "3" && b == "3" => (a, b.replace(b, "1"))
    })
  }

  def lettersToTupleList(result: String): Array[(String, String)] = {
    replaceLettersWithNumbers(result)
      .split("\n")
      .map(_.split(" "))
      .map(l => (l(0), l(1)))
  }

  def replaceLettersWithNumbers(letters: String): String = {
    letters
      .replace("A", "1")
      .replace("B", "2")
      .replace("C", "3")
      .replace("X", "1")
      .replace("Y", "2")
      .replace("Z", "3")
  }
}


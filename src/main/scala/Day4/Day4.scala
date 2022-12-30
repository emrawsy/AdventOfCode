package Day4

import scala.io.Source

object Day4 extends App {

  val input = Source.fromResource("day4.txt").mkString

  def countFullOverlap(tasks: String): Int = {
    splitUp(tasks).count {
      pair =>
        val start1 = pair(0)(0).toInt
        val end1 = pair(0)(1).toInt

        val start2 = pair(1)(0).toInt
        val end2 = pair(1)(1).toInt

        (start1 <= start2 && end1 >= end2) ||
        (start2 <= start1 && end2 >= end1)
    }

  }

  def countAnyOverlap(tasks: String): Int = {
    splitUp(tasks).count {
      pair =>
        val start1 = pair(0)(0).toInt
        val end1 = pair(0)(1).toInt

        val start2 = pair(1)(0).toInt
        val end2 = pair(1)(1).toInt

        (start1 <= start2 && end1 >= end2) ||
        (start2 <= start1 && end2 >= end1) ||
        (start1 < start2 && end1 > start2) ||
        (start2 < start1 && end2 > start1) ||
        (start1 == end2) ||
        (start2 == end1)

    }
  }

  def splitUp(tasks: String) = {
    tasks
      .split("\n")
      .map(_.split(",")
        .map(_.split("-")))
  }

  println(countAnyOverlap(input))
}

package Day1

import scala.io.Source

object Day1 extends App {

  val input = Source.fromResource("day1.txt").mkString


  def countBiggest(calories: String) = {
    calories
      .split("\n\n")
      .map(_.split("\n")
      .map(_.toInt))
      .map(_.sum)
      .max
  }

  def countBiggestThree(calories: String): Int = {
    calories
      .split("\n\n")
      .map(_.split("\n")
      .map(_.toInt))
      .map(_.sum)
      .sorted
      .takeRight(3)
      .sum
  }

  print(countBiggestThree(input))
}


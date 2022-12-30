package Day3

import scala.io.Source

object Day3 extends App {

  val input = Source.fromResource("day3.txt").mkString

  def priorityItem(items: String) = {
    items
      .split("\n")
      .grouped(3)
      .map(bag => (
        convertLettersToNumbers(bag(0)),
        convertLettersToNumbers(bag(1)),
        convertLettersToNumbers(bag(2))))
      .map(b => b._1.intersect(b._2.intersect(b._3)).head)
      .sum
  }

  def rucksackItems(items: String): Int = {
    items
      .split("\n")
      .map(rucksack => splitInMiddle(rucksack))
      .map(sections => (convertLettersToNumbers(sections._1), convertLettersToNumbers(sections._2)))
      .map(side => side._1.intersect(side._2).head).sum
  }

  def splitInMiddle(items: String): (String, String) = {
    val middle = items.length / 2
    (items.substring(0, middle), items.substring(middle))
  }

  def convertLettersToNumbers(item: String): Array[Int] = {
      item.toCharArray.map {
        case letter if letter >= 'a' && letter <= 'z' => letter - 'a' + 1
        case letter if letter >= 'A' && letter <= 'Z' => letter - 'A' + 27
      }
  }

  println(priorityItem(input))


}


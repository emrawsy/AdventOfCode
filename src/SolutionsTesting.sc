
//def input: String = io.Source.fromResource("Day1/day1.txt").mkString
//
//
//def caloriesToList(calories: String): List[String] =
//  calories.split(" ").toList
//
//  //calories.linesIterator.map(_.toInt).toSeq
//
//def countCaloriesPerElf(caloriesList: List[String]) = {
//  caloriesList
//    .map(_.toInt).sliding(1).map(_.sum).toList
//
//  //caloriesList.sliding(gap).map(_.sum).zipWithIndex.count({ case (a, b) => a < b})
//}

val input = io.Source.fromResource("/day1.txt").getLines

def countBiggest(calories: Iterator[String], gap: Int = 1) = {
  val caloriesList = calories.map(_.toInt).toList
  caloriesList
    .sliding(gap)
    .map(_.sum)
    .zipWithIndex
    .count({
      case (a, b) => b < a
    })
}

println(countBiggest(input))
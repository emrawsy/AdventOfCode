package Day3
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import org.scalatest.verbs.MustVerb

class Day3Spec extends AnyFreeSpec with Matchers {

 private val rucksackItems =
  """vJrwpWtwJgWrhcsFMMfFFhFp
    |jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
    |PmmdzqPrVvPwwTWBwg
    |wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
    |ttgJtRGJQctTZtZT
    |CrZsJsPPZsGzwwsLwLmpwMDw""".stripMargin

 "The Rucksack Items" - {
  "part 1 should give total of the repeated items in each rucksack" in {
   Day3.rucksackItems(rucksackItems) mustEqual 157
  }
  "part 2 should give the total of the priority item" in {
   Day3.priorityItem(rucksackItems) mustEqual 70
  }
 }
}

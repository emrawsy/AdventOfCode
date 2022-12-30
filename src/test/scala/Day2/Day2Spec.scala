package Day2
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.verbs.MustVerb

class Day2Spec extends AnyFreeSpec with MustVerb {

  private val input =
    """A Y
      |B X
      |C Z
      |A Z""".stripMargin

  "myTournamentResultTakeOne" - {
    "Should give correct total when given input" in {
      Day2.myTournamentResultTakeOne(input) equals 18
    }
  }
  "replaceLettersWithNumbers" - {
    "should replace letters with corresponding numbers" in {
      Day2.replaceLettersWithNumbers(input) equals
        """1 2
          |2 1
          |3 3
          |1 3""".stripMargin
    }
  }
  "myTournamentResultTakeTwo" - {
    "should give me correct total of actual results" in {
      Day2.myTournamentResultTakeTwo(input) equals 20
      println(s"${Day2.myTournamentResultTakeTwo(input)}")
    }
  }
}

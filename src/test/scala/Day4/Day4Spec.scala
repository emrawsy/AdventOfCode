package Day4

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

class Day4Spec extends AnyFreeSpec with Matchers {

  private val tasks = """2-4,6-8
                        |2-3,4-5
                        |5-7,7-9
                        |2-8,3-7
                        |6-6,4-6
                        |2-6,4-8""".stripMargin
  "cleanUp" - {
    "give correct number for pair full overlap" in {
      Day4.countFullOverlap(tasks) mustEqual 2
    }
    "give correct number of any overlap" in {
      Day4.countAnyOverlap(tasks) mustEqual 4
    }
}

}

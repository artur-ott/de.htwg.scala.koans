package de.htwg.scala.exercises

import org.codetask.koanlib.CodeTaskSuite

class Ex14_Range extends CodeTaskSuite("Range",14) {

  koan("Range are not inclusive at end of range") {
    val someNumbers = Range(0, 10)

    someNumbers.size should be(10)
  }

  koan("Range can specify a step for an increment") {
    val someNumbers = Range(2, 10, 3)

    someNumbers.size should be(3)
  }

  koan("Range doed not include the last item, even in a step increment") {
    val someNumbers = Range(0, 34, 2)
    someNumbers.contains(33) should be(false)
    someNumbers.contains(32) should be(true)
    someNumbers.contains(34) should be(false)
  }

  koan("Range can specify to include the last value") {
    val someNumbers = Range(0, 34).inclusive

    someNumbers.contains(34) should be(true)
  }

}

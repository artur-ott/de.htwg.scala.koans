package de.htwg.scala.exercises

import org.codetask.koanlib.CodeTaskSuite

/**
 * AboutByNameParameter
 * Koan to help understand by name parameters in Scala
 * Prerequisites: AboutEither, AboutHigherOrderFunctions, AboutExceptions,
 *                About Pattern Matching, AboutApply
 */
class Ex34_ByNameParameter extends CodeTaskSuite("By-Name Parameters",34) {

  koan(
    """() => Int is a Function type that takes a Unit type and returns an Int.
      | Unit is known as 'void' to a Java programmer.
      | You can place this as a method parameter so that you can you use it as a block, but still
      | it doesn't look quite right.""") {

    def calc(x: () => Int): Either[Throwable, Int] = {
      try {
        Right(x()) //An explicit call to the x function
      } catch {
        case b: Throwable => Left(b)
      }
    }

    val y = calc {() => //Having explicitly declaring that Unit is a parameter with ()
      14 + 15
    }

    y should be (Right(29))
  }

  koan(
    """A by-name parameter does the same thing as a previous koan but there is no need to explicitly
      | handle Unit or (). This is used extensively in scala to create blocks.""") {

    def calc(x: => Int): Either[Throwable, Int] = {   //x is a call by name parameter
      try {
        Right(x)
      } catch {
        case b: Throwable => Left(b)
      }
    }

    val y = calc {                                    //This looks like a natural block
      println("Here we go!")                          //Some superfluous call
      val z = List(1, 2, 3, 4)                        //Another superfluous call
      49 + 20
    }

    y should be (Right(69))
  }

  koan("""By name parameters can also be used with an Object and apply to make interesting block-like calls""") {
    object PigLatinizer {
      def apply(x: => String) = x.tail + x.head + "ay"
    }

    val result = PigLatinizer {
      val x = "pret"
      val z = "zel"
      x ++ z //concatenate the strings
    }

    result should be ("retzelpay")
  }
}
package refTransparency

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import refTransparency.ReferentialTransparency.{giveMoneyTo, multiply}

class ReferentialTransparencyTest extends AnyFunSuite with Matchers {

  test("ref transparency") {

    val six = multiply(3, 2)
    val six_v2 = 2 + multiply(2, 2)
    val six_v3 = 6

    six.should(equal(six_v2))
    six.should(equal(six_v3))
  }

  test("not ref transparency") {
    //val giveToMario = giveMoneyTo(10, "Mario")
    val giveTwiceToMario = giveMoneyTo(10, "Mario") + giveMoneyTo(10, "Mario")

    //val giveTwiceToMario_V1 = giveToMario + giveToMario

  }
}
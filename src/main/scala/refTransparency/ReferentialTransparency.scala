package refTransparency

object ReferentialTransparency {

  // Referential transparent function
  def multiply(a: Int, b: Int) =
    a * b

  // NOT referential transparent function
  def giveMoneyTo(money: BigDecimal, name: String): BigDecimal = {
    println("I give: " + money + " to " + name)
    money
  }

  // Refactoring repeated code
  def sum(a: Int, b: Int): Int = a + b

  def repeatedCode() = {
    val firstSum = sum(1, 2)
    val secondSum = sum(1, 2)
    val thirdSum = sum(1, 2)

    firstSum + secondSum + thirdSum
  }

  def unrepeatedCode() = {
    val firstSum = sum(1, 2)
    firstSum + firstSum + firstSum
  }

  def bigProgram() = {

    sum(2, 3) + sum(300, 20) + sum(sum(2, 3), sum(300, 20)) + sum(2, 3)
  }
}

package functor

import scala.util.Try

object Functor {

  val aList = List(1, 2, 3)
  val aDoubledList = aList.map(_ * 2)

  val anOption = Option(2)
  val aDoubledOption = anOption.map(_ * 2)

  val aTry = Try(2)
  val aDoubledTry = aTry.map(_ * 2)

  // Functor -> map
  // C -> type argument(List, Option, Try). It's the Container!
  // map takes a container C[A], a function from A => B, and returns a new container C[B]
  trait Functor[C[_]] {
    def map[A, B](container: C[A])(f: A => B): C[B]
  }

  // an example of Functor implementation for list
  implicit val listFunctor: Functor[List] = new Functor[List] {
    override def map[A, B](container: List[A])(f: A => B): List[B] = container.map(f)
  }

  // let's generalize the "doubled" function
  def double[C[_]](container: C[Int])(implicit functor: Functor[C]) = functor.map(container)(_ * 2)

  trait Tree[+T]
  object Tree {
    def leaf[T](value: T): Tree[T] = Leaf(value)
    def branch[T](value: T, left: Tree[T], right: Tree[T]): Tree[T] = Branch(value, left, right)
  }

  case class Leaf[+T](value: T) extends Tree[T]
  case class Branch[+T](t: T, value: Functor.Tree[T], value1: Functor.Tree[T]) extends Tree[T]

  implicit val treeFunctor: Functor[Tree] = new Functor[Tree] {

    override def map[A, B](container: Tree[A])(f: A => B): Tree[B] = container match {
      case Leaf(value) => Leaf(f(value))
      case Branch(value, left, right) => Branch(f(value), map(left)(f), map(right)(f))
    }
  }



}

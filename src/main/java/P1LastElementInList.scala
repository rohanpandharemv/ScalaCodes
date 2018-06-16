import java.util.NoSuchElementException

/**
 * Created by rohanp on 3/18/17.
 * Solution to Problem
 * P01 (*) Find the last element of a list.
 * Example:
 *  scala> last(List(1, 1, 2, 3, 5, 8))
 *  res0: Int = 8
 */
class P1LastElementInList {
  def getEasyLast[A](list : List[A]) : A = {
    list match {
      case Nil => throw new scala.NoSuchElementException("List is Empty, please provide valid list")
      case _ => list.last
    }
  }

  def lastElementInList[A](list : List[A]) : A = {
    list.tail match {
      case Nil => list.head
      case _ => lastElementInList(list.tail)
    }
  }

  def last[A](list : List[A]) : A = {
    list match {
      case s :: Nil => s
      case _ :: tail => last(tail)
      case _ => throw new NoSuchElementException("List is either empty or something elese is wrong!!!")
    }
  }
}

object P1LastElementInList {

  val list = List(1,2,3,4,5,6,7,8,"Rohan")

  def main(args: Array[String]) {
    val a = new P1LastElementInList
    println(a.lastElementInList(list))
    println(a.last(List(1,2,3,List("1","3","4","5"))))
  }

}
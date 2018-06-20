package scala99


/**
 * Created by rohanp on 6/20/18.
 *
 * P01 (*) Find the last element of a list.
 *     Example:
 *    scala> last(List(1, 1, 2, 3, 5, 8))
 *     res0: Int = 8
 */

class Q1_LastElementInList {
  def getLastElement[A](lst : List[A]) : Option[A] = {
    lst match {
      case Nil => None
      case h :: Nil => Some(h)
      case _ :: t  => getLastElement(t)
    }
  }
}

object Q1_LastElementInList extends App{
  val obj = new Q1_LastElementInList
  //val lst = List[Int](1,2,3,4,5)
  val lst = List("rohan","Monika","Rahul","Nihanth")
  println(obj.getLastElement(lst))
}

/**
*  Other Solutions:
*  lst.last
*  lst(lst.size -1)
*  lst.reverse.head
**/
/**
 * Created by rohanp on 3/19/17.
 * 03 (*) Find the Kth element of a list.
 * By convention, the first element in the list is element 0.
 * Example:
 *  scala> nth(2, List(1, 1, 2, 3, 5, 8))
 *  res0: Int = 2
 */
class P3KthElementInList {
  def findKthElementInList[A](num : Int , list : List[A]) : A = {
    list match {
      case Nil if num < 0 => throw new NoSuchElementException("List is empty & num is less than zero")
      case lst if num < 0 => throw new NoSuchElementException("List is non-empty but num is less than zero")
      case lst if num > lst.length => throw new NoSuchElementException("List size is less than num")
      case lst if num > 0 => findKthElementInList( num - 1, list.tail )
      case lst if num == 0 => lst.head
    }
  }
}

object P3KthElementInList {
  def main(args : Array[String]): Unit = {
    val a =  new P3KthElementInList
    val list = List(1, 1, 2, 3, 5, 8)
    println(a.findKthElementInList(7,list))
  }
}
/**
 * Created by rohanp on 3/19/17.
 * P05 (*) Reverse a list.
 * Example:
 * scala> reverse(List(1, 1, 2, 3, 5, 8))
 * res0: List[Int] = List(8, 5, 3, 2, 1, 1)
 **/

class P5ReversingList {
  //with Inbuilt function
  def inbuildReverse[A](list : List[A]) : List[A] = {
    list.reverse
  }

  //simple recursion
  def getReversedList[A]( list : List[A]) : List[A] = {
    list match {
      case Nil => Nil
      case h :: tail => getReversedList(tail) ::: List(h)
    }
  }

  //tailRecursion
  def getTailRecursiveReverseList[A](list : List[A]) : List[A] = {
    def reverseList[A](result : List[A], secList: List[A] ) : List[A] = secList match {
      case Nil => result
      case h :: tail => reverseList(h :: result, tail)
    }
    reverseList(Nil, list)
  }

  //fully functional
  def getFunctionalReverseOftheList[A](list : List[A]) : List[A] = {
   list.foldLeft(List[A]()){(h,r)=>r :: h}
  }
}

object P5ReversingList {
  def main (args: Array[String]){
       val list = List(1,2,3,4,5,"sdfs")
       val a = new P5ReversingList
       println(a.getReversedList(list))
  }
}
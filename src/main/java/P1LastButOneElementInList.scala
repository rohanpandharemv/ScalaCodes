/**
 * Created by rohanp on 3/18/17.
 *P02 (*) Find the last but one element of a list.
 * Example:
 *  scala> penultimate(List(1, 1, 2, 3, 5, 8))
 *  res0: Int = 5
 **/

class P1LastButOneElementInList {
  def secondLastElementInList[A](list : List[A]) : A = {
    (list != Nil) match {
      case true => list.tail match {
        case a :: b :: Nil => a
        case _ => secondLastElementInList(list.tail)
      }
      case false => throw new NoSuchElementException("List is empty, Enter valid list")
    }
  }

  def secondLastElementInListAnotherApproach[A](list : List[A]) : A = {
    list match {
      case Nil => throw new NoSuchElementException("List is empty, Enter valid list")
      case a :: _ :: Nil => a
      case _ => secondLastElementInListAnotherApproach(list.tail)
    }
  }
}

object P1LastButOneElementInList {
  def main(args: Array[String]) {
   val list = List(1,2,3,4,5,5,6,7,8,12,13,"Rohan","Bhajan")
   val a = new P1LastButOneElementInList
   println(a.secondLastElementInList(list))
   println(a.secondLastElementInListAnotherApproach(list))
  }
}
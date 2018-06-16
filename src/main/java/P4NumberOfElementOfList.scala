/**
 * Created by rohanp on 3/19/17.
 * P04 (*) Find the number of elements of a list.
 * Example:
 * scala> length(List(1, 1, 2, 3, 5, 8))
 * res0: Int = 6
 */
class P4NumberOfElementOfList {
  def numberOfElementOfList[A](list : List[A]) : Int = {
    var count = 0
    for( i <- list) {
      i match {
        case Nil => count
        case _ => count = count + 1
      }
    }
    count
  }
}

object P4NumberOfElementOfList {
  def main(args : Array[String]) : Unit = {
    val a = new P4NumberOfElementOfList
    val list = List(1,2,3,4,5,6)
    println(a.numberOfElementOfList(Nil))
  }
}
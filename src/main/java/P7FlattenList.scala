/*
 * Just updated the line...
 * Created by rohanp on 3/19/17.
 * P07 (**) Flatten a nested list structure.
 * Example:
 *  scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
 *  res0: List[Any] = List(1, 1, 2, 3, 5, 8)
 */

class P7FlattenList {
  //Iterative Way of flattening the nested list
  def getFlattenList[A](list : List[A]) : List[Any] = {
    def getFlatten[A](result:List[A],lst : List[A]) : List[Any] = lst match {
      case Nil => result ::: Nil
      case ls :: tail => ls match {
        case (l :: tail0) :: tail1 => getFlatten(result ::: (l :: tail0), tail1)
        case l :: tail1 => getFlatten(getFlatten(result :+ l, tail1),tail)
        case a => getFlatten(result :+ a,tail)
      }
    }
    getFlatten(Nil,list)
  }
}

object P7FlattenList {
  def main(args : Array[String]): Unit = {
    val a =  new P7FlattenList
    val list = List(1,2,3,List(4,5,List(6,7,List(8,9))),10,11)
    val list1 = List(List(List(1, 1), 2, List(3, List(5, 8))))
    println(a.getFlattenList(list))
  }
}

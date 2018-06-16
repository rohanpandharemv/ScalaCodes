/**
 * Created by rohanp on 3/20/17.
 * P08 (**) Eliminate consecutive duplicates of list elements.
 * If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
 * Example:
 * scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
 */
class P8RemoveConsucativeDuplicateElements {
  // recursive way of doing code
  def removeDuplicate[A](list : List[A]) : List[Any] = {
    def removeDup[A](result : List[A], list : List[A]) : List[Any] = {
      list match {
        case Nil => result
        case l :: tail if result.isEmpty => removeDup(result :+ l, tail)
        case l :: tail if result.last.equals(l) => removeDup(result, tail)
        case l :: tail if !result.last.equals(l) => removeDup(result :+ l, tail)
      }
    }
    removeDup(Nil, list)
  }

  def removeDup[A](list : List[A]) : List[Any] = list.distinct
}

object P8RemoveConsucativeDuplicateElements {
  def main(args : Array[String]): Unit = {
    val list = List(1,1,1,1,1,2,2,2,2,3,2,4,4,4,6,6,6,7,7,8,9,9,8)
    val a = new P8RemoveConsucativeDuplicateElements
    println(a.removeDuplicate(list))
    println(a.removeDup(list))//List of Distinct Elements
  }
}

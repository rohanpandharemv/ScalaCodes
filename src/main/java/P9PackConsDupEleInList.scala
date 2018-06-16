/**
 * Created by rohanp on 3/21/17.
 *
 * P09 (**) Pack consecutive duplicates of list elements into sublists.
 * If a list contains repeated elements they should be placed in separate sublists.
 * Example:
 * scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
 *
 */
class P9PackConsDupEleInList {

  /*def packElements(mList : List[Any]) = {
    var fList = List[Any]()
    mList.foldLeft(List[Any])((lst , i ) => {
      lst match {
        case Nil => lst +: List(i)
      }
    })
  }*/
}

object P9PackConsDupEleInList {
  /*def main(args: Array[String]) {
    val a = new P9PackConsDupEleInList
    val list = List(1,1,1,2,2,2,2,2,3,1,1,1)
    println(a.packElement(list))
  }*/
}
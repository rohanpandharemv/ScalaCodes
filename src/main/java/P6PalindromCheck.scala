/**
 * Created by rohanp on 3/19/17.
 *P06 (*) Find out whether a list is a palindrome.
 * Example:
 *  scala> isPalindrome(List(1, 2, 3, 2, 1))
 *  res0: Boolean = true
 **/
class P6PalindromCheck {
  def isPalindrom[A]( list : List[A]) : Boolean = {
    list == list.foldLeft(List[A]()){(h,t)=>t::h}
  }
}

object P6PalindromCheck {
  def main(args: Array[String]) {
    val list = List(1,2,1,2,1)
    val list1 = List(1,2,2,1)
    val list2 = List(1,2,1)
    val list3 = List(1,2,3,4,5)
    val a = new P6PalindromCheck
    println(a.isPalindrom(list3))
  }
}
package LearningScalaBookCodes

/**
 * Created by rohanp on 4/22/18.
 */

//How to pass a touple to function as arguments
class First20OddNumbers {
  def oddNumbersWithForLoop( limit : Int) : List[Int] = {
    var list : List[Int] = Nil
    for( i  <- 1 to 100){
        if(i%2 != 0 && list.size < limit) {
          list = list :+ i
        }
      }
      println(s"size : ${list.size}")
      list
    }

  def oddNumbersWithMap(limit : Int) : List[Int] = {
    (1 to limit*2).map{
      i =>
        i%2!=0 match {
          case true => i
          case _ => 0
        }
    }.toList.filterNot(_ == 0)
  }
}

object First20OddNumbers extends App {
  val obj = new First20OddNumbers
  println(obj.oddNumbersWithForLoop(20))
  println(obj.oddNumbersWithMap(20))
  val r = 1 to 40 by 2
  println(s"=>$r")
}

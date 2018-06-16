package InterviewCodes

/**
 * Created by rohanp on 6/9/18.
 */
class LongestConsecutiveSeq {

  def mklsts( arr : Array[Int] ) : Int = {
    var countList : List[Int] = List(0)
    var count = 0
    for(i <- 0 until arr.sorted.length - 1 ){
      if( arr(i)+1 == arr(i+1) ){
        count += 1
        countList = countList :+ count
      }else count = 0
    }
    println(s"====>$countList")
    countList.max
  }

  def getMaxConsecutiveSequence(arr : Array[Int]) : Int = {
    var count = 0;
    try count = arr.sliding(2).count(a => a(0) + 1 == a(1))
    catch {case e : ArrayIndexOutOfBoundsException => count = 1}
    count
  }

}

object LongestConsecutiveSeq extends App {
  val arr = Array[Int](500,501,1,2,3,4,150,151,152,1,2,3)
  //val arr = Array[Int](101)
  val obj = new LongestConsecutiveSeq
  //println(obj.mklsts(arr))
  println(obj.getMaxConsecutiveSequence(arr))
}
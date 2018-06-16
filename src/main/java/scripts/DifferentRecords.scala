package scripts

/**
 * Created by rohanp on 5/2/17.
 */
class DifferentRecords {

  def fileToMap(file: String): scala.collection.mutable.Map[String, String] = {
    var fileToMap = scala.collection.mutable.Map[String,String]()
    val fileInputString = scala.io.Source.fromFile(file)
    for (line <- fileInputString.getLines) {
      val columns = line.split(",").map(i => i.trim)
      fileToMap += (columns(0) -> columns(1))
    }
    fileToMap
  }
}

object DifferentRecords {
  def main(args : Array[String]) : Unit = {
    val a = new DifferentRecords
    val MysqlMap = a.fileToMap("/home/rohanp/MisMatchDocumentsFiles/fiveguys/fiveguysSentiment90Days.txt")
    val VerticaMap = a.fileToMap("/home/rohanp/MisMatchDocumentsFiles/fiveguys/fiveguysSentiment90Days_vertica.csv")
    val list = new scala.collection.mutable.ListBuffer[String]()

    for((k,v) <- MysqlMap) {
        val verticaValue = VerticaMap.get(k)
        verticaValue match {
          case None => list += v
           //println( "(" + k + "->" + v + ") != (" + k + "->" + verticaValue + ")")
          case Some(value) => if( v != value) list += v //println( "(" + k + "->" + v + ") != (" + k + "->" + value + ")")}
        }
    }
    println(list.toList.distinct)
    println(list.toList.distinct.size)
  }
}
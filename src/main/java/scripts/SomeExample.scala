package scripts

/**
 * Created by rohanp on 11/30/17.
 */

//pradeepert @pradeepert Nov 14 20:15
//any one please help me to understand how add function loads multiple values
class UsingGenericsForLinkedList[X] {
  private class Node[X](elem: X) {
    var next: Node[X] = _
    override def toString = elem.toString
  }
  private var head: Node[X] = _

  def add(elem: X) { //Add element in the linekd list
  val value = new Node(elem)
    value.next = head
    head = value
  }

  private def printNodes(value: Node[X]) { // prining value of the nodes
    if (value != null) {
      println(value)
      printNodes(value.next)
    }
  }
  def printAll() { printNodes(head) } //print all the node values at a time
}
object UsingGenericsForLinkedList {
  def main(args: Array[String]) {
    val ints = new UsingGenericsForLinkedList[Int]()
    ints.add(1)
    ints.add(2)
    ints.add(3)
    ints.add(4)
    ints.printAll()
  }
}

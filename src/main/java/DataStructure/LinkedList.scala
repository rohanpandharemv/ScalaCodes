package DataStructure

/**
 * Created by rohanp on 12/16/17.
 */
class LinkedListNode(num : Int) {
  var value = num
  var next : LinkedListNode  = null
  def addNode( root : LinkedListNode, value : Int ) = {
    val node = new LinkedListNode(value)
    var temp = root

    root == null match {
      case true =>
        root.value = node.value
      case false =>
        while(temp.next != null){
          temp = temp.next
        }
        temp.next = node
    }
  }
  def printNode(root : LinkedListNode) = {
    var temp : LinkedListNode = root
    root != null match {
      case false => println("Root is null")
      case true =>
        while(temp.next != null){
          println(temp.value)
          temp =  temp.next
        }
    }
  }
}

object LinkedListNode extends App {
  var root = new LinkedListNode(0)
  root.addNode(root, 5)
  root.addNode(root,4)
  //root.addNode(root,3)
  root.printNode(root)

}
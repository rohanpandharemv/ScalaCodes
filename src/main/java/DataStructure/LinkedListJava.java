package DataStructure;

/**
 * Created by rohanp on 12/16/17.
 */
public class LinkedListJava {

    Node root = null;
    public static void main(String args[]){
        Node node = new Node();
        //node.addNode(root,5);
    }

}

class Node {
    Integer value = null;
    Node next = null;

    public void addNode(Node root,Integer num) {
        Node node = new Node();
        node.value = num;
        if(root == null) {
            root = node;
        }else {
            while(root.next != null) {
                root = root.next;
            }
            root.next = node;
        }
    }

    public void printList(Node root) {
        while(root.next != null){
            System.out.print(root.value + "->");
            root = root.next;
        }
        System.out.print("null");
    }
}
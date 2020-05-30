package app.linkedList;

/**
 * Main class responsible to perform reversal of list.
 */
public class DoublyLLReverse {
  Node finalHead;
  Node temp;

  /**
   * Node class represent node of a list
   */
  class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
      super();
      this.data = data;
    }
  }

  /**
   * Method to create list of dummy data as per counter size
   */
  public void createTestList() {
    int counter = 5;
    Node tempHead = null;

    while (counter > 0) {
      Node node = new Node(counter);
      if (null == finalHead) {
        node.prev = null;
        finalHead = node;
        tempHead = node;
      } else {
        node.prev = tempHead;
        tempHead.next = node;
        tempHead = node;
      }
      counter--;
    }
  }

  /**
   * Method responsible to reverse the list. Idea is to swap prev and next of each node 
   * starting from head and finally setting last node as head.
   */
  public void reverseList() {
    Node tempSwap = null;
    Node currentNode = finalHead;
    while (currentNode != null) {
      //swap next and prev of node
      tempSwap = currentNode.prev;
      currentNode.prev = currentNode.next;
      currentNode.next = tempSwap;
      //store last node as head
      finalHead = currentNode;
      //Using prev since prev point to node which was earlier next.
      currentNode = currentNode.prev;
    }
  }

  /**
   * Method to print list.
   */
  public void printList() {
    Node temp = finalHead;
    while (temp != null) {
      System.out.print(temp.data);
      temp = temp.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    DoublyLLReverse reverseList = new DoublyLLReverse();
    reverseList.createTestList();
    reverseList.printList();
    reverseList.reverseList();
    reverseList.printList();
  }

}
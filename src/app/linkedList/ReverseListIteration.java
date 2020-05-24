package app.linkedList;

/**
 * Node class represent node of a list
 */
class Node {
  private int data;
  private Node next;

  public Node(int data) {
    super();
    this.data = data;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node node) {
    this.next = node;
  }
}

/**
 * Main class responsible to perform reversal of list.
 */
public class ReverseListIteration {
  Node head;
  Node temp;

  /**
   * Method to create list of dummy data as per counter size
   */
  public void createTestList() {
    int counter = 5;
    while (counter > 0) {
      Node node = new Node(counter);
      if (null == head) {
        head = node;
        temp = head;
      } else {
        temp.setNext(node);
        temp = temp.getNext();
      }
      counter--;
    }
  }

  /**
   * Method responsible to reverse the list.
   * Idea is to change the direction of link between two nodes starting from head and finally setting last curr node as head.
   */
  public void reverseList() {
    Node prev = null;
    Node curr = null;
    Node next = head;
    while (next != null) {
      curr = next;
      next = next.getNext();
      curr.setNext(prev);
      prev = curr;
    }
    head = curr;
  }

  /**
   * Method to print list.
   */
  public void printList(){
    Node temp = head;
    while(temp != null){
      System.out.print(temp.getData());
      temp = temp.getNext();
    }
    System.out.println();
  }

 public static void main(String[] args) {
   ReverseListIteration reverseList = new ReverseListIteration();
   reverseList.createTestList();
   reverseList.printList();
   reverseList.reverseList();
   reverseList.printList();
 }

}
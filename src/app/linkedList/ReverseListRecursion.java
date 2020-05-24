package app.linkedList;

/**
 * Node class represent node of a list
 */
class RecursiveNode {
  private int data;
  private RecursiveNode next;

  public RecursiveNode(int data) {
    super();
    this.data = data;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public RecursiveNode getNext() {
    return next;
  }

  public void setNext(RecursiveNode node) {
    this.next = node;
  }
}

/**
 * Main class responsible to perform reversal of list.
 */
public class ReverseListRecursion {
  static RecursiveNode head;

  /**
   * Method to create list of dummy data as per counter size
   */
  public void createTestList() {
    int counter = 5;
    RecursiveNode temp = null;
    while (counter > 0) {
      RecursiveNode node = new RecursiveNode(counter);
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
   * Method responsible to reverse the list. Idea is to change the direction of
   * link between two nodes starting from tail and setting last node as head.
   */
  public void reverseList(RecursiveNode currentNode) {
    if (currentNode == null) {
      return;
    }
    if (currentNode.getNext() == null) {
      head = currentNode;
      return;
    }
    reverseList(currentNode.getNext());
    //Changing the direction of link
    currentNode.getNext().setNext(currentNode);
    currentNode.setNext(null);
  }

  /**
   * Method to print list.
   */
  public void printList() {
    RecursiveNode temp = head;
    while (temp != null) {
      System.out.print(temp.getData());
      temp = temp.getNext();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ReverseListRecursion reverseList = new ReverseListRecursion();
    reverseList.createTestList();
    reverseList.printList();
    reverseList.reverseList(head);
    reverseList.printList();
  }

}
package app.linkedList;

public class DetectLoop {

  class Node {
    private int data;
    private Node next;

    public Node(int data) {
      super();
      this.data = data;
    }
  }

  /**
   * Method responsible to detect loop and find its starting node between two lists.
   */
  public Node detectLoop(Node list1) {
    Node temp1 = list1;
    Node temp2 = list1;
    Node head = list1;
    Node loopDetected = null;
    while (temp1 != null && temp2 != null) {
      temp1 = temp1.next;
      temp2 = temp2.next.next;
      if (temp1 == temp2) {
        loopDetected = temp1;
        break;
      }
    }
    while (head != loopDetected) {
      head = head.next;
      loopDetected = loopDetected.next;
    }
    return head;
  }

  public static void main(String[] args) {
    DetectLoop detectLoop = new DetectLoop();
    DetectLoop.Node node1 = detectLoop.new Node(1);
    DetectLoop.Node node2 = detectLoop.new Node(2);
    DetectLoop.Node node3 = detectLoop.new Node(3);
    DetectLoop.Node node4 = detectLoop.new Node(4);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node2;
    Node loopStartNode = detectLoop.detectLoop(node1);
    System.out.println("Loop started at node = " + loopStartNode.data);
  }
}
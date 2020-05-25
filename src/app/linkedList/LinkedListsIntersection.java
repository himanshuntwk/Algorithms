package app.linkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListsIntersection {
  
  class Node {
    private int data;
    private Node next;

    public Node(int data) {
      super();
      this.data = data;
    }
  }

  /**
   * Method responsible to find intesection node between two lists.
   */
  public Node findIntersection(Node list1, Node list2) {
    Set<Node> nodeSet = new HashSet<Node>();
    while(list1 != null) {
      nodeSet.add(list1);
      list1 = list1.next;
    }

    while(list2 != null) {
      if(nodeSet.contains(list2)) {
        return list2;
      }
      list2 = list2.next;
    }

    return null;
  }

  public static void main(String[] args) {
    LinkedListsIntersection linkedListsIntersection = new LinkedListsIntersection();
    LinkedListsIntersection.Node list1node1 = linkedListsIntersection.new Node(1);
    LinkedListsIntersection.Node list1node2 = linkedListsIntersection.new Node(2);
    LinkedListsIntersection.Node list1node3 = linkedListsIntersection.new Node(3);
    LinkedListsIntersection.Node list2node1 = linkedListsIntersection.new Node(4);
    list1node1.next = list1node2;
    list1node2.next = list1node3;
    list2node1.next = list1node2;
    Node intersection = linkedListsIntersection.findIntersection(list1node1, list2node1);
    System.out.println(intersection.data);
  }
}
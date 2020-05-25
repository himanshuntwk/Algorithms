package app.linkedList;

public class LinkedListsIntersection_2 {

  class Node {
    private int data;
    private Node next;

    public Node(int data) {
      super();
      this.data = data;
    }
  }

  /**
   * Method responsible to find intesection node between two lists without using set.
   * 1. Find length of both lists.
   * 2. Check last node is same else non-intersection.
   * 3. Whoever have larger length increment that list to be at same level as other lists.
   * 4. Iterate while you get an equal node, return the intersection node.
   */
  public Node findIntersection(Node list1, Node list2) {
    int length1 = 1;
    int length2 = 1;
    Node list1Head = list1;
    Node list2Head = list2;

    while (list1.next != null) {
      list1 = list1.next;
      length1++;
    }

    while (list2.next != null) {
      list2 = list2.next;
      length2++;
    }

    if(list1.data != list2.data) {
      return null;
    }

    if(length1 > length2) {
      while(length1 - length2 != 0) {
        list1Head = list1Head.next;
        length1--;
      }
    }else {
      while(length2 - length1 != 0) {
        list2Head = list2Head.next;
        length2--;
      }
    }

    while(list1Head != list2Head){
      list1Head = list1Head.next;
      list2Head = list2Head.next;
    }
    return list1Head;
  }

  public static void main(String[] args) {
    LinkedListsIntersection_2 linkedListsIntersection = new LinkedListsIntersection_2();
    LinkedListsIntersection_2.Node list1node1 = linkedListsIntersection.new Node(1);
    LinkedListsIntersection_2.Node list1node2 = linkedListsIntersection.new Node(2);
    LinkedListsIntersection_2.Node list1node3 = linkedListsIntersection.new Node(3);
    LinkedListsIntersection_2.Node list2node1 = linkedListsIntersection.new Node(4);
    list1node1.next = list1node2;
    list1node2.next = list1node3;
    list2node1.next = list1node2;
    Node intersection = linkedListsIntersection.findIntersection(list1node1, list2node1);
    System.out.println(intersection.data);
  }
}
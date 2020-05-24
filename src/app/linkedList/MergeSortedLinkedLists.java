package app.linkedList;

public class MergeSortedLinkedLists {
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
  }

  /**
   * Method to merge two lists based on their values.
   * 
   * @param list1
   * @param list2
   * @return
   */
  public Node mergeLists(Node list1, Node list2) {

    if(list1 == null) return list2;
    if(list2 == null) return list1;

    if(list1.data < list2.data) {
      list1.next = mergeLists(list1.next, list2);
      return list1;
    }else {
      list2.next = mergeLists(list1, list2.next);
      return list2;
    }
  }

  /**
   * Method to print finalList after merge.
   * 
   * @param list
   */
  public void printList(Node list) {
    while(list != null){
      System.out.print(list.data);
      list = list.next;
    }
    System.out.println();
  }

  /**
   * Main method to execute the process.
   */
  public static void main(String[] args) {
    MergeSortedLinkedLists mergeSortedLinkedLists = new MergeSortedLinkedLists();
    MergeSortedLinkedLists.Node list1node1 = mergeSortedLinkedLists.new Node(1);
    MergeSortedLinkedLists.Node list1node2 = mergeSortedLinkedLists.new Node(3);
    MergeSortedLinkedLists.Node list1node3 = mergeSortedLinkedLists.new Node(5);
    MergeSortedLinkedLists.Node list2node1 = mergeSortedLinkedLists.new Node(2);
    MergeSortedLinkedLists.Node list2node2 = mergeSortedLinkedLists.new Node(4);
    MergeSortedLinkedLists.Node list2node3 = mergeSortedLinkedLists.new Node(6);

    list1node1.next = list1node2;
    list1node2.next = list1node3;
    list2node1.next = list2node2;
    list2node2.next = list2node3;

    Node finalList = mergeSortedLinkedLists.mergeLists(list1node1,list2node1);
    mergeSortedLinkedLists.printList(finalList);
  }
}
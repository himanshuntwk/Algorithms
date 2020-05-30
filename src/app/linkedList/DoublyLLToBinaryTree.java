package app.linkedList;

public class DoublyLLToBinaryTree {
  class Node {
    int data;
    private Node next;
    private Node prev;

    public Node(int data) {
      this.data = data;
    }
  }

  Node prev;
  Node head;

  /**
   * Following in-order traversal
   */
  public Node convertToTree(int listSize) {

    if (listSize <= 0) {
      return null;
    }

    Node left = convertToTree(listSize / 2);
    Node root = head;
    root.prev = left;
    head = head.next;
    root.next = convertToTree(listSize - listSize/2 - 1);
    return root;

  }

  void preOrder(Node node) 
    { 
        if (node == null) 
            return; 
        System.out.print(node.data + " "); 
        preOrder(node.prev); 
        preOrder(node.next); 
    }

  public static void main(String[] args) {
    DoublyLLToBinaryTree mainObj = new DoublyLLToBinaryTree();
    DoublyLLToBinaryTree.Node list = mainObj.new Node(1);
    mainObj.head = list;
    list.prev = null;
    list.next = mainObj.new Node(2);
    list.next.next = mainObj.new Node(3);
    list.next.next.next = mainObj.new Node(4);
    list.next.next.next.next = mainObj.new Node(5);
    list.next.next.next.next.next = mainObj.new Node(6);
    list.next.next.next.next.next.next = mainObj.new Node(7);
    list.next.next.next.next.next.next.prev = list.next.next.next.next.next;
    list.next.next.next.next.next.prev = list.next.next.next.next;
    list.next.next.next.next.prev = list.next.next.next;
    list.next.next.next.prev = list.next.next;
    list.next.next.prev = list.next;
    list.next.prev = list;

    Node root = mainObj.convertToTree(7);
    mainObj.preOrder(root);
  }
}
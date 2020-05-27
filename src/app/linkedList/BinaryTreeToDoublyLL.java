package app.linkedList;

public class BinaryTreeToDoublyLL {
  class Node {
    int data;
    private Node left;
    private Node right;

    public Node(int data) {
      this.data = data;
    }
  }
  
  Node prev;
  Node head;

  /**
   * Following in-order traversal
   */
  public void convertToLL(Node root) {

    if(root == null) {
      return;
    }

    convertToLL(root.left);

    if(prev == null) {
      head = root; //maintaining the head of linked list.
    }else {
      root.left = prev;
      prev.right = root;
    }
    prev = root;
    convertToLL(root.right);
  }
  
  public static void main(String[] args) {
    BinaryTreeToDoublyLL mainObj = new BinaryTreeToDoublyLL();
    BinaryTreeToDoublyLL.Node tree = mainObj.new Node(1);
    tree.left = mainObj.new Node(2);
    tree.right = mainObj.new Node(3);
    tree.left.left = mainObj.new Node(4);
    tree.left.right = mainObj.new Node(5);
    tree.right.left = mainObj.new Node(6);
    tree.right.right = mainObj.new Node(7);

    mainObj.convertToLL(tree);
    //Iteration started from head of the linked list.
    while(mainObj.head != null) {
      System.out.println(mainObj.head.data + "<>");
      mainObj.head = mainObj.head.right;
    }
  }


}
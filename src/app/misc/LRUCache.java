package app.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to implement least recently used cache.
 */
public class LRUCache {

  Map<Integer, Node> cacheMap = new HashMap<>();
  int cacheSize = 5;
  Node list = null;

  class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
      this.data = data;
    }
  }

  /**
   * Method updates cache as per below scenario-<br>
   * Add newly accessed data in the map.<br>
   * Add newly accessed node in the front of the list.<br>
   * Check if list size increases greater than cacheSize remove last node.<br>
   * 
   * @param node
   */
  public void updateCache(Node node) {
    cacheMap.put(node.data, node);
    if (list == null) {
      list = node;
      return;
    }
    node.next = list;
    node.prev = null;
    list.prev = node;
    list = node;
    Node tempList = list;
    int count = 1;
    while (tempList.next != null && count <= 5) {
      tempList = tempList.next;
      count++;
    }
    if (count > cacheSize) {
      tempList.prev.next = null;
      tempList.prev = null;
      cacheMap.remove(tempList.data);
    }

  }

  /**
   * Method to print the cache.
   */
  public void printCache() {
    Node tempList = list;
    while (tempList != null) {
      System.out.print(tempList.data + ",");
      tempList = tempList.next;
    }
    System.out.println();
  }

  /**
   * Method invoked when page accessed.
   * 
   * @param data
   */
  public void pageAccess(int data) {
    updateCache(new Node(data));
  }

  public static void main(String[] args) {
    LRUCache obj = new LRUCache();
    obj.pageAccess(5);
    obj.pageAccess(4);
    obj.pageAccess(3);

    obj.printCache();

  }
}
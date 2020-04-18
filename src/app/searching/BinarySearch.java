package app.searching;

import java.util.Arrays;

/**
 * Class demonstrating Binary search.
 */
public class BinarySearch {

  long startTime;
  long endTime;
  int location = -1;

  /**
   * Main method to provide test data for searching algorithm.
   */
  public static void main(String[] args) throws Exception {
    int[] inputArray = { 12, 43, 5, 32, 34, 56, 2, 3, 6, 19 };
    int searchItem = 34;
    BinarySearch binarySearch = new BinarySearch();
    // Binary search work on sorted data.
    Arrays.sort(inputArray);
    // Iterative version
    binarySearch.binarySearch(inputArray, searchItem);
    // Recursive version
    // binarySearch.binarySearchRec(inputArray, searchItem, 0, inputArray.length-1);
    binarySearch.resultAndStats();
  }

  /**
   * Iterative version of binary search.
   * 
   * @param inputArray
   * @param searchItem
   */
  public void binarySearch(int[] inputArray, int searchItem) {
    startTime = System.nanoTime();
    int start = 0;
    int end = inputArray.length - 1;
    int mid;
    while (start <= end) {
      mid = (start + end) / 2;
      if (searchItem == inputArray[mid]) {
        location = mid;
        endTime = System.nanoTime();
        break;
      } else if (searchItem < inputArray[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
  }

  /**
   * Recursive version of binary search and it seems it is much faster than
   * iterative version.
   * 
   * @param inputArray
   * @param searchItem
   * @param start
   * @param end
   */
  public void binarySearchRec(int[] inputArray, int searchItem, int start, int end) {
    if (0 == startTime) {
      startTime = System.nanoTime();
    }
    if (start <= end) {
      int mid = (start + end) / 2;

      if (inputArray[mid] == searchItem) {
        location = mid;
        endTime = System.nanoTime();
      } else {
        if (searchItem < inputArray[mid]) {
          binarySearchRec(inputArray, searchItem, start, mid - 1);
        } else {
          binarySearchRec(inputArray, searchItem, mid + 1, end);
        }
      }
    }
  }

  /**
   * Method to provide result and stats about algorithm.<br>
   * Approximate time observed.<br>
   * Iterative: 1700 ns<br>
   * Recursive: 800 ns
   */
  public void resultAndStats() {
    System.out.println("=====================================");
    if (location != -1) {
      System.out.println("Item found at " + location);
      System.out.println("Total Time Taken (nanos)=" + (endTime - startTime));
    } else {
      System.out.println("Item not found.");
    }
    System.out.println("=====================================");
  }

}
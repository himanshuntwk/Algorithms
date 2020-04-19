package app.sorting;

import java.util.Arrays;

/**
 * Class demonstrating Bubble sort algorithm.<br>
 * Highest element is sorted first (right to left sorting).
 */
public class BubbleSort {

  long startTime, endTime;

  int[] inputArray = { 23, 34, 12, 5, 7, 82, 45 };

  /**
   * Main method to provide testing data for the algorithm.
   * 
   * @param args
   */
  public static void main(String[] args) {
    BubbleSort bubbleSort = new BubbleSort();
    bubbleSort.startTime = System.nanoTime();
    bubbleSort.bubbleSort();
    bubbleSort.endTime = System.nanoTime();
    bubbleSort.resultAndStats();
  }

  /**
   * Method performing Bubble sort to sort the given array.
   * 
   * @param inputArray
   */
  public void bubbleSort() {
    int swapCounter = -1;
    int lastIndex = inputArray.length - 1;
    while (swapCounter != 0) {
      swapCounter = 0;
      for (int i = 0; i < lastIndex; i++) {
        if (inputArray[i] > inputArray[i + 1]) {
          swapValues(i, i + 1);
          swapCounter = swapCounter + 1;
        }
      }
      lastIndex = lastIndex - 1;
    }
  }

  /**
   * Method to provide result and stats about algorithm. Approximate time
   * observed: 4400 ns
   */
  public void resultAndStats() {
    System.out.println("=====================================");
    System.out.println("Sorted Array => " + Arrays.toString(inputArray));
    System.out.println("Total Time Taken (nanos) => " + (endTime - startTime));
    System.out.println("=====================================");
  }

  /**
   * Swap values in the array as per provided indices.
   * 
   * @param firstIndex
   * @param secondIndex
   * @param inputArray
   */
  private void swapValues(int firstIndex, int secondIndex) {
    int temp = inputArray[firstIndex];
    inputArray[firstIndex] = inputArray[secondIndex];
    inputArray[secondIndex] = temp;
  }
}
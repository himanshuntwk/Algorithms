package app.sorting;

import java.util.Arrays;

/**
 * Class demonstrating Insertion sort algorithm.<br>
 * First element is considered sorted and then next element is picked to be
 * correctly placed on left sorted array.
 */
public class InsertionSort {

  long startTime, endTime;

  int[] inputArray = { 23, 34, 12, 5, 7, 82, 45 };

  /**
   * Main method to provide testing data for the algorithm.
   * 
   * @param args
   */
  public static void main(String[] args) {
    InsertionSort insertionSort = new InsertionSort();
    insertionSort.startTime = System.nanoTime();
    insertionSort.insertionSort();
    insertionSort.endTime = System.nanoTime();
    insertionSort.resultAndStats();
  }

  /**
   * Method performing Insertion sort to sort the given array.
   * 
   * @param inputArray
   */
  public void insertionSort() {
    int currentValue;
    for (int i = 1; i < inputArray.length; i++) {
      currentValue = inputArray[i];
      for (int j = i - 1; j >= 0; j--) {
        if (currentValue < inputArray[j]) {
          swapValues(j, j + 1);
        }
      }
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
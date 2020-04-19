package app.sorting;

import java.util.Arrays;

/**
 * Class demonstrating Selection sort algorithm.<br>
 * Lowest element is sorted first (left to right sorting).
 */
public class SelectionSort {

  long startTime, endTime;
  int[] inputArray = { 23, 34, 12, 5, 7, 82, 45 };

  /**
   * Main method to provide testing data for the algorithm.
   * 
   * @param args
   */
  public static void main(String[] args) {
    SelectionSort selectionSort = new SelectionSort();
    selectionSort.startTime = System.nanoTime();
    selectionSort.selectionSort();
    selectionSort.endTime = System.nanoTime();
    selectionSort.resultAndStats();
  }

  /**
   * Method performing selection sort to sort the given array.
   * 
   * @param inputArray
   */
  public void selectionSort() {
    int min, minIndex = 0;
    for (int i = 0; i < inputArray.length; i++) {
      min = inputArray[i];
      minIndex = i;
      for (int j = i + 1; j < inputArray.length; j++) {
        // update the minimum if found in the j loop.
        if (min > inputArray[j]) {
          min = inputArray[j];
          minIndex = j;
        }
      }
      // swapping only happen if j loop finds value less than i loop value.
      if (minIndex != i) {
        swapValues(i, minIndex);
      }
    }
  }

  /**
   * Method to provide result and stats about algorithm. Approximate time
   * observed: 4700 ns
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
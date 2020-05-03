package app.sorting;

import java.util.Arrays;

/**
 * Class demonstrating Shell sort algorithm.<br>
 * Its an extension of insertion sort which considers sorting h spaced elements.
 * Example:
 * Considering h = 1,4,13,40...
 * an array of 9 elements iterations are -
 * 4 spaced elements are sorted among themselves.
 * 1 spaced elements are sorted among themselves.
 */
public class ShellSort {

  long startTime, endTime;

  int[] inputArray = { 23, 34, 12, 5, 7, 82, 45 };

  /**
   * Main method to provide testing data for the algorithm.
   * 
   * @param args
   */
  public static void main(String[] args) {
    ShellSort shellSort = new ShellSort();
    shellSort.startTime = System.nanoTime();
    shellSort.shellSort();
    shellSort.endTime = System.nanoTime();
    shellSort.resultAndStats();
  }

  /**
   * Method performing Shell sort to sort the given array.
   * 
   * @param inputArray
   */
  public void shellSort() {
    int arraySize = inputArray.length;
    int h = 1;
    int currentValue;
    while (h < arraySize / 3) {
      h = 3*h + 1;
    }
    while(h >= 1) {
      for (int i = h; i < arraySize; i++) {
        currentValue = inputArray[i];
        for (int j = i; j>=h; j=j - h) {
          if (currentValue < inputArray[j-h]) {
            swapValues(j, j - h);
          }
        }
      }
      h = h/3;
    }
    
    
  }

  /**
   * Method to provide result and stats about algorithm. Approximate time
   * observed: 6600 ns
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
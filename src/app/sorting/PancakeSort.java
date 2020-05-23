package app.sorting;

import java.util.Arrays;

/**
 * Class demonstrating Pancake sort algorithm.<br>
 * Highest element is sorted first (right to left sorting).
 */
public class PancakeSort {

  long startTime, endTime;
  int[] inputArray = { 23, 34, 12, 5, 7, 82, 45 };

  /**
   * Main method to provide testing data for the algorithm.
   * 
   * @param args
   */
  public static void main(String[] args) {
    PancakeSort pancakeSort = new PancakeSort();
    pancakeSort.startTime = System.nanoTime();
    pancakeSort.pancakeSort();
    pancakeSort.endTime = System.nanoTime();
    pancakeSort.resultAndStats();
  }

  /**
   * Method performing pancake sort to sort the given array.
   * 
   * @param inputArray
   */
  public void pancakeSort() {
    for (int i = inputArray.length - 1; i > 0; i--) {
      int maxIndex = getMaxValueIndex(i);
      if (maxIndex != i) {
        if (maxIndex != 0) {
          flipArray(maxIndex);
        }
        flipArray(i);
      }
    }
  }

  /**
   * Method to flip the array elements starting from 0 to end provided.
   * @param end
   */
  public void flipArray(int end) {
    int start = 0;
    while (start < end) {
      swapValues(start, end);
      start++;
      end--;
    }
  }

  /**
   * Method to return index of maximum value in the array starting from 0 to end provided.
   * @param end
   * @return
   */
  public int getMaxValueIndex(int end) {
    int maxIndex = 0;
    for (int i = 1; i <= end; i++) {
      if (inputArray[maxIndex] < inputArray[i]) {
        maxIndex = i;
      }
    }
    return maxIndex;
  }

  /**
   * Method to provide result and stats about algorithm. Approximate time
   * observed: 10126 ns
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
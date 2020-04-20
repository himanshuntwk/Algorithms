package app.sorting;

import java.util.Arrays;

/**
 * Class demonstrating Merge sort algorithm.<br>
 * Array is split into two halves left and right recursively and will get merge as per their values.
 */
public class MergeSort {

  long startTime, endTime;

  int[] inputArray = { 23, 34, 12, 5, 7, 82, 45 };

  /**
   * Main method to provide testing data for the algorithm.
   * 
   * @param args
   */
  public static void main(String[] args) {
    MergeSort mergeSort = new MergeSort();
    mergeSort.startTime = System.nanoTime();
    mergeSort.mergeSort(0, mergeSort.inputArray.length - 1);
    mergeSort.endTime = System.nanoTime();
    mergeSort.resultAndStats();
  }

  /**
   * Method performing Merge sort to sort the given array.
   * 
   * @param inputArray
   */
  public void mergeSort(int start, int end) {

    if (start < end) {
      int mid = (start + end) / 2;
      mergeSort(start, mid);
      mergeSort(mid + 1, end);
      mergeLeftRight(start, end);
    }
  }
  /**
   * Method performing merging of two arrays.
   */
  public void mergeLeftRight(int start, int end) {
    int mid = (start + end) / 2;
    int leftArraySize = mid - start + 1; //adding 1 since left array will be inclusive of mid index value.
    int rightArraySize = end - mid;
    int[] leftArray = new int[leftArraySize];
    int[] rightArray = new int[rightArraySize];

    for(int i=0;i < leftArraySize;i++) {
      leftArray[i] = inputArray[start + i];
    }
    for(int i=0;i < rightArraySize;i++) {
      rightArray[i] = inputArray[mid + i + 1]; //adding 1 since right array will be exclusive of mid index value.
    }

    int i=0,j=0;
    int k = start;
    while(i < leftArraySize && j < rightArraySize){
      if(leftArray[i] <= rightArray[j]) {
        inputArray[k] = leftArray[i];
        i++;
      }else {
        inputArray[k] = rightArray[j];
        j++;
      }
      k++;
    }

    while(i < leftArraySize) {
      inputArray[k] = leftArray[i];
      i++;
      k++;
    }

    while(j < rightArraySize) {
      inputArray[k] = rightArray[j];
      j++;
      k++;
    }
  }

  /**
   * Method to provide result and stats about algorithm. Approximate time
   * observed: 9600 ns
   */
  public void resultAndStats() {
    System.out.println("=====================================");
    System.out.println("Sorted Array => " + Arrays.toString(inputArray));
    System.out.println("Total Time Taken (nanos) => " + (endTime - startTime));
    System.out.println("=====================================");
  }
}
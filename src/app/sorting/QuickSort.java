package app.sorting;

import java.util.Arrays;

public class QuickSort {

  static int[] inputArray = { 1, 2, 4, 5, 6, 0, 7, 8 };

  static int partition(int start, int end) {
    int i = start, j = end;
    int value = inputArray[start];
    while (true) {
      //iterate until you get array element greater than "value"
      while (inputArray[i] < value) {
        i = i + 1;
      }
      //iterate until you get array element less than "value"
      while (inputArray[j] > value) {
        j = j - 1;
      }
      if (i >= j) {
        break;
      } else {
        exchange(i, j);
      }
    }
    //Update the value of j index with the pratitioned "value".
    inputArray[j] = value;
    return j;
  }

  public static void sort(int start, int end) {
    if (start < end) {
      int j = partition(start, end);
      sort(start, j - 1);
      sort(j + 1, end);
    }
  }

  public static void main(String[] args) {
    String str="abc";
    System.out.println(str.substring(0, 2));
    System.out.println(Arrays.toString(inputArray));
    sort(0, inputArray.length - 1);
    System.out.println(Arrays.toString(inputArray));
  }

  private static void exchange(int i, int j) {
    int temp = inputArray[i];
    inputArray[i] = inputArray[j];
    inputArray[j] = temp;
  }
}
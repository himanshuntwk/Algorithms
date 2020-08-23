package app.arrays;

import java.util.Arrays;

public class ElementsFrequency {

  public static void main(String[] args) {
    int[] inputArray = { 2, 3, 3, 2, 5 };
    int[] tempArr = { 0, 0, 0, 0, 0, 0 };

    for (int i = 0; i < inputArray.length; i++) {
      tempArr[inputArray[i]] = tempArr[inputArray[i]] + 1;
    }

    System.out.println(Arrays.toString(tempArr));
  }
}
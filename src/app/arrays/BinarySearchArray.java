package app.arrays;

public class BinarySearchArray {

  public void findElement(int[] arr, int element, int start, int end) {
    int mid = (start + end) / 2;

    if (arr[mid] == element) {
      System.out.println("Result>>>" + mid);
    } else {
      if (arr[mid] < element) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
      findElement(arr, element, start, end);
    }

  }

  public static void main(String[] args) {
    int array[] = { 21, 32, 43, 74, 75, 86, 97, 108, 149 };
    int element = 97;
    BinarySearchArray obj = new BinarySearchArray();
    obj.findElement(array, element, 0, array.length - 1);
  }
}
package app.searching;

/**
 * Class demonstrating linear search.
 */
public class LinearSearch {

  long startTime;
  long endTime;
  int location = -1;

  /**
   * Main method to provide test data for searching algorithm.
   */
  public static void main(String[] args) throws Exception {
    int[] inputArray = { 12, 43, 5, 32, 34, 56, 2, 3, 6, 19 };
    int searchItem = 349;
    LinearSearch linearSearch = new LinearSearch();
    linearSearch.linearSearch(inputArray, searchItem);
    linearSearch.resultAndStats();
  }

  /**
   * Method performing linear search to find an item in given array.
   * 
   * @param inputArray
   * @param searchItem
   */
  public void linearSearch(int[] inputArray, int searchItem) {
    startTime = System.nanoTime();
    for (int i = 0; i < inputArray.length; i++) {
      if (inputArray[i] == searchItem) {
        endTime = System.nanoTime();
        location = i;
      }
    }
  }

  /**
   * Method to provide result and stats about algorithm.
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
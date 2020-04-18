package app;

public class LinearSearch {

  public int linearSearch(int[] inputArray, int searchItem) {
    for(int i=0; i<inputArray.length; i++) {
      if(inputArray[i] == searchItem) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) throws Exception {
    int[] inputArray = {12,43,5,32,34,56,2,3,6,19};
    int searchItem = 34;
    LinearSearch linearSearch = new LinearSearch();
    long startTime = System.nanoTime();
    int location = linearSearch.linearSearch(inputArray, searchItem);
    long endTime = System.nanoTime();
    System.out.println("Item found at " + location);
    System.out.println("Total Time Taken (nanos)=" + (endTime-startTime));
  }
}
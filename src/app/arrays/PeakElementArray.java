package app.arrays;

public class PeakElementArray {
  
  public void findPeak(int[] array) {
    int i=1;
    while(i<=array.length-2) {
      if(array[i] >= array[i-1] && array[i] >= array[i+1]) {
        System.out.println(array[i]);
        i=i++;
      }
      i++;
    }
  }

  public static void main(String[] args) {
    int[] array = {1,4,3,6,7,5};
    PeakElementArray obj = new PeakElementArray();
    obj.findPeak(array);
  }

}
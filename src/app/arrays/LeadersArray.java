package app.arrays;

public class LeadersArray {

  public void findLeaders(int[] array) {
    int currentLeader = array[array.length - 1];
    System.out.println(currentLeader);
    for (int i = array.length - 2; i >= 0; i--) {
      if (array[i] > currentLeader) {
        currentLeader = array[i];
        System.out.println(currentLeader);
      }
    }
  }

  public static void main(String[] args) {
    int[] array = { 98, 23, 54, 12, 20, 7, 27 };
    LeadersArray obj = new LeadersArray();
    obj.findLeaders(array);
  }
}
package app.arrays;

import java.util.HashSet;

public class StringPermutationSet {

  /**
   * Store first character.<br>
   * Iterate over remaining permutations.<br>
   * Add first character in all positions of all words.<br>
   * 
   * @param str
   * @return
   */
  private HashSet<String> getAllPermutations(String str) {
    HashSet<String> permutations = new HashSet<>();

    if (str == null || str.length() == 0) {
      permutations.add("");
      return permutations;
    }

    char first = str.charAt(0);
    String remainderString = str.substring(1);
    HashSet<String> words = getAllPermutations(remainderString);
    for (String word : words) {
      for (int i = 0; i <= word.length(); i++) {
        String prefix = word.substring(0, i);
        String suffix = word.substring(i);
        permutations.add(prefix + first + suffix);
      }
    }
    return permutations;
  }

  public static void main(String[] args) {
    String str = "ABC";
    StringPermutationSet obj = new StringPermutationSet();
    HashSet<String> permutations = obj.getAllPermutations(str);
    System.out.println(permutations.toString());
  }
}
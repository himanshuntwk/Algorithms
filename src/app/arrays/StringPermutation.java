package app.arrays;

public class StringPermutation {

  private void permute(String str, int l, int r) {
    System.out.println("6>>>" + str + "<<l>>" + l + "<<r>>" + r);
    if (l == r) {
      System.out.println(str);
    } else {
      for (int i = l; i <= r; i++) {
        System.out.println("i>>" + i + "<<l>>" + l + "<<r>>" + r);
        str = swap(str, l, i);
        System.out.println("str1>>" + str);
        permute(str, l + 1, r);
        str = swap(str, l, i);
        System.out.println("str2>>" + str);
      }
    }
  }

  public String swap(String a, int i, int j) {
    char temp;
    char[] charArray = a.toCharArray();
    temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
    return String.valueOf(charArray);
  }

  public static void main(String[] args) {
    String str = "ABC";
    int n = str.length();
    StringPermutation obj = new StringPermutation();
    obj.permute(str, 0, n - 1);

  }
}
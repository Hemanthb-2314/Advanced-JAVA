import java.util.Arrays;
import java.util.Scanner;
public class Anagram
{
  public static void main(String args[])
  {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter first word");
      String word1=sc.next();
      System.out.println("Enter second word");
      String word2=sc.next();
      word2=word2.toLowerCase();
      word1=word1.toLowerCase();
      char[] w1=word1.toCharArray();
      char[] w2=word2.toCharArray();
      Arrays.sort(w1);
      Arrays.sort(w2);
      String sw1=new String(w1);
      String sw2=new String(w2);
      if(sw1.equals(sw2))
          System.out.println("They are anagrams");
      else
          System.out.println("Not anagrams");

  }
}

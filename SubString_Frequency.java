import java.util.Scanner;
public class FreqString
{
    public static void main(String args[])
    {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the string");
     String string = sc.nextLine();
     System.out.println("Enter the substring");
     String subString=sc.next();
     int count=0;
     int i=0;
     while((i=string.indexOf(subString,i))!=-1)
     {
         count++;
         i+=subString.length();
     }
     System.out.println("The frequency of "+subString+" is "+count);
    }
}

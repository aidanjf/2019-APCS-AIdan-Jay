import java.util.*;

public class HelloWorld {
   public static void main(String[] args) {
      //String[] b = {"stampede", "zebra", "zigzag", "canary"};
      //f(b);
      //System.out.print(Arrays.toString(b));
      System.out.print(f());
   }
   
   public static int f() {
      String[] a = {"stampede", "zebra", "zigzag", "canary"};
      String[] b = {"stampede", "fdsaf"};
      int i = 0;
      if (a[0].equals(b[0])) {
         i++;
      }
      return Math.min(a.length, b.length);
   }
}
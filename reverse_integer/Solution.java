package reverse_integer;

public class Solution {
   public int reverse(int x) {
      StringBuilder intStrBld = new StringBuilder();
      
     boolean neg = (x < 0);
     int tempX = neg ? -x : x;
      
      while (tempX != 0) {
          int digit = tempX % 10;
          intStrBld.append(digit);
          tempX /= 10;
      }
      
      String s = intStrBld.toString();
      
      int rev;
      try {
          rev = Integer.parseInt(s);
      } catch (Exception e) {
          return 0;
      }
      
      return neg ? -rev : rev;
   }
}
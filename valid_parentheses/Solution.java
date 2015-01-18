package valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

   public static boolean isValid(String s) {
      Deque<Character> dq = new ArrayDeque();
      for (int i = 0; i < s.length(); i++) {
         switch (s.charAt(i)) {
            case '(':
               dq.push(')');
               break;
            case '{':
               dq.push('}');
               break;
            case '[':
               dq.push(']');
               break;
            case ')':
               if (dq.isEmpty() || dq.pop() != ')')
                  return false;
               break;
            case '}':
               if (dq.isEmpty() || dq.pop() != '}')
                  return false;
               break;
            case ']':
               if (dq.isEmpty() || dq.pop() != ']')
                  return false;
               break;
            default:
               return false;
         }
      }

      if (!dq.isEmpty())
         return false;
      return true;
   }

   public static void main(String[] args) {
      String s = "[";
      System.out.println(isValid(s));
   }

}

package remove_duplicates_from_sorted_array;

public class Solution {
   public static int removeDuplicates(int[] A) {
      if (A.length == 0) return 0;
      if (A.length == 1) return 1;
      
      int newLen = 1;
      int slowIndex = 0;
      int fastIndex = 0;
      while (fastIndex < A.length - 1) {
         if (A[fastIndex] != A[fastIndex + 1]) {
            A[++slowIndex] = A[fastIndex + 1];
            newLen++;
         }
         fastIndex++;
      }
      return newLen;
   }
   
   public static void main (String[] args) {
      int[] arr = {1,1};
      int newLen = removeDuplicates(arr);
      for (int i = 0; i < newLen; i++)
         System.out.println(arr[i]);
   }
}

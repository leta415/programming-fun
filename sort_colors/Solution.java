package sort_colors;

import java.util.Arrays;

/* Given an array with n objects colored red, white or blue, sort them so that objects of the same
 * color are adjacent, with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue
 * respectively. */
public class Solution {
   private static void sortColors(int[] A) {
      int zeroPointer = -1;
      int onePointer = -1;
      int twoPointer = -1;

      for (int i = 0; i < A.length; i++) {
         if (A[i] == 0) {
            A[++zeroPointer] = 0;

            if (onePointer > -1) {
               A[++onePointer] = 1;
            }
            if (twoPointer > -1) {
               A[++twoPointer] = 2;
            }

         } else if (A[i] == 1) {
            onePointer = onePointer < 0 ? zeroPointer + 1 : onePointer + 1;
            A[onePointer] = 1;

            if (twoPointer > -1) {
               A[++twoPointer] = 2;
            }
         } else if (A[i] == 2) {
            twoPointer = twoPointer < 0 ? Math.max(onePointer + 1, zeroPointer + 1)
                  : twoPointer + 1;
            A[twoPointer] = 2;

         }
      }
   }

   public static void main(String[] args) {
      int[] arr = new int[] { 0, 2 };
      sortColors(arr);
      System.out.println(Arrays.toString(arr));
   }
}

package three_sum_closest;

import java.util.Arrays;

/* Leetcode problem -- 3Sum Closest: Given an array S of n integers, find three integers in S such
 * that the sum is closest to a given number, target. Return the sum of the three integers. You may
 * assume that each input would have exactly one solution. */
public class Solution {
   public static int threeSumClosest(int[] num, int target) {
      Integer currentClosestSum = null;
      Arrays.sort(num);

      for (int i = 0; i < num.length - 2; i++) {
         if (i > 0 && num[i] == num[i - 1]) {
            continue;
         }

         int leftPointer = i + 1;
         int rightPointer = num.length - 1;

         while (leftPointer < rightPointer) {
            int sum = num[i] + num[leftPointer] + num[rightPointer];

            if (sum == target) {
               return sum;
            }

            if (sum < target) {
               leftPointer++;
            } else if (sum > target) {
               rightPointer--;
            }

            if (currentClosestSum != null) {
               int diffPrevious = Math.abs(target - currentClosestSum);
               int diff = Math.abs(target - sum);
               if (diff < diffPrevious) {
                  currentClosestSum = sum;
               }
            } else {
               currentClosestSum = sum;
            }
         } // end of while

      } // end of for loop

      return currentClosestSum;
   }

   public static void main(String[] args) {
      int[] arr = new int[] { 0, 0, 0 };
      int target = 1;

      System.out.println(threeSumClosest(arr, target));
   }
}

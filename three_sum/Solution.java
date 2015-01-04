package three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Leetcode problem -- 3Sum: Given an array S of n integers, are there elements a, b, c in S such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero. */
public class Solution {
   public static List<List<Integer>> threeSum(int[] num) {
      List<List<Integer>> triplets = new ArrayList<List<Integer>>();
      if (num.length < 3) {
         return triplets;
      }
      Arrays.sort(num);

      for (int i = 0; i < num.length - 2; i++) {
         if (i > 0 && num[i] == num[i - 1]) {
            continue;
         }

         int leftPointer = i + 1;
         int rightPointer = num.length - 1;

         while (leftPointer < rightPointer) {
            while (leftPointer < num.length && leftPointer > i + 1
                  && num[leftPointer] == num[leftPointer - 1]) {
               leftPointer++;
            }
            while (rightPointer >= 0 && rightPointer < num.length - 1
                  && num[rightPointer] == num[rightPointer + 1]) {
               rightPointer--;
            }

            if (leftPointer >= rightPointer || leftPointer >= num.length || rightPointer < 0) {
               continue;
            }

            int sum = num[i] + num[leftPointer] + num[rightPointer];

            if (sum < 0) {
               leftPointer++;
            } else if (sum > 0) {
               rightPointer--;
            } else {
               List<Integer> li = new ArrayList<Integer>();
               li.add(num[i]);
               li.add(num[leftPointer]);
               li.add(num[rightPointer]);
               triplets.add(li);
               leftPointer++;
            }
         }

      }

      return triplets;
   }

   public static void main(String[] args) {
      int[] arr = new int[] { 0, 0, 0, 0 };
      // -1, -1, 1, 1
      List<List<Integer>> answer = threeSum(arr);

      for (List<Integer> li : answer) {
         System.out.println(li.toString());
      }
   }
}
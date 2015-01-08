package two_sum;

import java.util.HashMap;
import java.util.Map;

/* Leetcode problem -- Two Sum: Given an array of integers, find two numbers such that they add up
 * to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and
 * index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution. */
public class Solution {
   public static int[] twoSum(int[] numbers, int target) {
      Map<Integer, Integer> mapComplementToIndex = new HashMap<Integer, Integer>();
      for (int i = 0; i < numbers.length; i++) {
         if (mapComplementToIndex.containsKey(numbers[i])) {
            return new int[]{mapComplementToIndex.get(numbers[i]) + 1, i + 1};
         }
         mapComplementToIndex.put(target - numbers[i], i);
      }

      return null;
   }

   public static void main(String[] args) {
      int[] nums = new int[] { 3,2,4 };
      int target = 6;
      int[] ans = twoSum(nums, target);
      System.out.println(ans[0] + ", " + ans[1]);
   }
}

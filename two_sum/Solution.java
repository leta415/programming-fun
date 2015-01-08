package two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* Given an array of integers, find two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and
 * index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution. */
public class Solution {
   public static int[] twoSum(int[] numbers, int target) {
      Map<Integer, Queue<Integer>> indexMap = new HashMap<Integer, Queue<Integer>>();
      for (int i = 0; i < numbers.length; i++) {
         Queue<Integer> q = indexMap.containsKey(numbers[i]) ? indexMap.get(numbers[i]) : new LinkedList<Integer>();
         q.add(i);
         indexMap.put(numbers[i], q);
      }
      
      Arrays.sort(numbers);
            
      int leftPointer = 0;
      int rightPointer = numbers.length - 1;
      
      while (leftPointer < rightPointer) {
         int sum = numbers[leftPointer] + numbers[rightPointer];
         
         if (sum == target) {
            int[] ans = new int[]{indexMap.get(numbers[leftPointer]).poll() + 1, indexMap.get(numbers[rightPointer]).poll() + 1};
            Arrays.sort(ans);
            return ans;
         }
         
         if (sum < target) {
            leftPointer++;
         } else {
            rightPointer--;
         }
      }

      return null;
   }
   
   public static void main (String[] args) {
      int[] nums = new int[]{5,75,25};
      int target = 100;
      int[] ans = twoSum(nums, target);
      System.out.println(ans[0] + ", " + ans[1]);
   }
}

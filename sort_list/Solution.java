 /* Definition for singly-linked list.*/
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

/* Sort a linked list in O(n log n) time using constant space complexity. */
public class Solution {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(midNext);

        return merge(left, right);
    }

    // Find and return middle element in a list.
    private static ListNode findMid(ListNode head) {
        // System.out.println("inside findMid()");
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            fast = fast.next;

            if (fast != null) {
                fast = fast.next;
            } else {
                break;
            }

            if (fast == null) {
                break;
            }

            slow = slow.next;
        }

        return slow;
    }


    private static ListNode merge(ListNode head1, ListNode head2) {
        // System.out.println("inside merge()");
        ListNode left = head1;
        ListNode right = head2;
        ListNode merged = null;
        ListNode head = null;

        while (left != null && right != null) {
            int val;

            // which list to take from
            if (left.val < right.val) {
                val = left.val;
                left = left.next;
            } else {
                val = right.val;
                right = right.next;
            }

            // add chosen value to merged list
            if (merged == null) {
                head = new ListNode(val);
                merged = head;
            } else {
                merged.next = new ListNode(val);
                merged = merged.next;
            }
        }

        // take care of leftovers
        while (left != null) {
            if (merged == null) {
                head = new ListNode(left.val);
                merged = head;
            } else {
                merged.next = new ListNode(left.val);
                merged = merged.next;
            }
            left = left.next;
        }

        while (right != null) {
            if (merged == null) {
                head = new ListNode(right.val);
                merged = head;
            } else {
                merged.next = new ListNode(right.val);
                merged = merged.next;
            }
            right = right.next;
        }

        return head;
    }

    public static void print(ListNode head) {
        ListNode n = head;

        while(n != null) {
            System.out.print(n.val + ", ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(6);
        ListNode test2 = new ListNode(4);
        // ListNode test3 = new ListNode(5);
        // ListNode test4 = new ListNode(1);
        test.next = test2;
        // test2.next = test3;
        // test3.next = test4;

        System.out.println("\nSorting...");
        print(test);
        System.out.println("\nSorted list:");
        print(sortList(test));


    }
}
package LinkedLists;

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

/**
 * Class that represents a singly linked list. 
 */
public class SinglyLinkedList {
   protected Node head = null;
   public Node getHead() {
       return head;
   }
   int size = 0;

   /** Class to represent each element in a SinglyLinkedList. */
   public static class Node {
      int data;
      Node next = null;

      Node (int data) {
         this.data = data;
      }

      public String toString() {
         return "" + this.data;
      }
   }

   /** CONSTRUCTORS */
   public SinglyLinkedList() {
   }
   public SinglyLinkedList(int headData) {
      this.head = new Node(headData);
   }
   public SinglyLinkedList(Node head) {
      this.head = head;

      Node n = head;
      while (n != null) {
         this.size++;
         n = n.next;
      }
   }

   /**  Standard methods */
   public Node insert(int data) {
      Node insertNode = new Node (data);

      // If list is empty
      if (this.head == null) {
         this.head = insertNode;
         return insertNode;
      }

      Node current = this.head;
      while (current.next != null) {
         current = current.next;
      }

      current.next = insertNode;
      this.size++;
      return insertNode;
   }

   public Node find(int data) {
      Node current = this.head;
      while (current != null) {
         if (current.data == data) {
            return current;
         }
         current = current.next;
      }
      return current;
   }

   /** Delete first Node found that contains given data */
   public void delete(int data) {
      Node current = this.head;
      Node previous = null;
      while (current != null) {
         if (current.data == data) {
            //Found at head
            if (previous != null) {
               previous.next = current.next;
            }
            else {
               this.head = current.next;
            } 
            current = null;
            return;
         }
         previous = current;
         current = current.next;
      }
   }

   /** Add a Node to front of the list */
   public void insertAsHead(int data) {
      Node insertNode = new Node(data);
      if (this.head != null)  insertNode.next = this.head;
      this.head = insertNode;
      this.size++;
   }

   public void insertAsHead(Node n) {
      if (this.head != null)  n.next = this.head;
      this.head = n;
      this.size++;
   }

   public String toString () {
      String s = "";

      if (this.head == null) {
         return s;
      }

      Node current = this.head;
      while (current != null) {
         s += current.data + ", ";
         current = current.next;
      }

      return s;
   }


   /** OTHER METHODS */

   /** Remove all duplcates in a linked list */
   public void removeDuplicates1() {
      Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
      Node current = this.head; 
      Node prev = null;
      while (current != null) {
         Node n;
         Node traverse = current.next;
         Node previous = current;
         while (traverse != null) {
            if (traverse.data == current.data) {
               if (previous != null) {
                  previous.next = traverse.next;
               }
               else {
                  this.head = traverse.next;
               } 
               n = traverse;   
            } else {
               previous = traverse;
            }
            traverse = traverse.next;
            n = null;
         }

         prev = current;
         current = current.next;
      }
   }

   /** Remove all duplcates in a linked list with hash map */
   public void removeDuplicates2() {
      Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
      Node current = this.head; 
      Node previous = null;
      while (current != null) {
         Node n = current;
         if (map.containsKey(current.data)) {
            if (previous != null) {
               previous.next = current.next;
            }
            else {
               this.head = current.next;
            }   
         } else {
            map.put(current.data, false);
            previous = current;
         }
         current = current.next;
         n = null;
      }
   }

   /** Find k-th to last element of a linked list */
   public Node kthToLast1 (int k) {
      int size = 0;
      Node current = this.head;
      while (current != null) {
         size++;
         current = current.next;
      }

      int nth = 0;
      current = this.head;
      while (current != null) {
         if (size-nth == k) {
            return current;
         }
         nth++;
         current = current.next;
      }
      return null;
   }

   public Node kthToLast2 (int k) {
      Node current = this.head;
      while (current != null) {
         if (fromLast(current)==k) {
            return current;
         }
         current = current.next;
      }
      return null;
   }
   public int fromLast (Node n) {
      if (n.next == null) {
         return 1;
      }
      return 1 + fromLast(n.next);
   }

   public Node kthToLast3 (int k) {
      Node leftPointer = this.head;
      Node rightPointer = this.head;

      //Move rightPointer to be k nodes after leftPointer.
      //If rightPointer hits the end before going k nodes, return.
      int i = 0;
      while (i < k) {
         if (rightPointer == null) {
            return null;
         }
         rightPointer = rightPointer.next;
         i++;
      }

      //Move both left and right pointers together til right pointer hits the end.
      //At this point retun left pointer.
      while (rightPointer != null) {
         leftPointer = leftPointer.next;
         rightPointer = rightPointer.next;
      }

      return leftPointer;
   }

   /** Delete middle node, assuming odd number of nodes, and you're only given reference to that node. */
   public void deleteMiddleNode (Node n) {
      //If node is the only one in the list
      if (n.next == null) {
         this.head = null;
         return;
      }

      while (n.next.next != null) {
         n.data = n.next.data;
         n = n.next;
      }
      n.data = n.next.data;
      n.next = null;
   }

   /** Partition a linked list around a value x, where all data less than x comes before all data greater than x. */
   public Node partition (int x) {
      Node left = null, right = null; 
      Node leftHead = null, rightHead = null;
      Node current = this.head;

      while (current != null) {
         Node n = current;
         if (current.data <= x) {
            if (left == null) {
               left = n;
               leftHead = n;
            } else {
               left.next = n;
               left = left.next;
            }
         } else {
            if (right == null) {
               right = n;
               rightHead = n;
            } else {
               right.next = n;
               right = right.next;
            }
         }       
         current = current.next;
         n.next = null;
      }

      //Append tail of left to head of right
      if (left != null) left.next = rightHead;
      return leftHead;
   }

   /**
    * Given 2 numbers represented by 2 backwards linked lists, return sum of the 2 numbers in the same form.
    * Preconditions: l1 and l2 are both not null. 
    */
   public static SinglyLinkedList sumBackwards (SinglyLinkedList l1, SinglyLinkedList l2) {
      Node current1 = l1.head;
      Node current2 = l2.head;
      int carry = 0;
      SinglyLinkedList sumList = new SinglyLinkedList();

      while (current1 != null  ||  current2 != null) {
         //Get digits to add
         int digit1 = current1 == null ? 0 : current1.data;
         int digit2 = current2 == null ? 0 : current2.data;

         //Add digits plus carry
         int sum = digit1 + digit2 + carry;
         sumList.insert(sum % 10);
         carry = sum / 10;

         if (current1 != null)   current1 = current1.next;
         if (current2 != null)   current2 = current2.next;
      }

      //Add carry if exists
      if (carry > 0) {
         sumList.insert(carry);
      }

      return sumList;
   }
   public static SinglyLinkedList sumBackwardsRecursive (SinglyLinkedList l1, SinglyLinkedList l2) {
      SinglyLinkedList sumList = new SinglyLinkedList();
      sumBackwardsRecursiveHelper(l1.head, l2.head, 0, sumList);
      return sumList;
   }
   private static void sumBackwardsRecursiveHelper (Node h1, Node h2, int carry, SinglyLinkedList sumList) {
      if (h1 == null  &&  h2 == null) {
         return;
      } 

      int digit1 = h1 == null ? 0 : h1.data;
      int digit2 = h2 == null ? 0 : h2.data;

      int sum = digit1 + digit2 + carry;
      sumList.insert(sum % 10);

      sumBackwardsRecursiveHelper (h1.next, h2.next, sum / 10, sumList);
   }

   /**
    * Given 2 numbers represented by 2 linked lists, return sum of the 2 numbers in the same form.
    * Preconditions: l1 and l2 are both not null. 
    */
   public static SinglyLinkedList sumForward (SinglyLinkedList l1, SinglyLinkedList l2) {
      //Pad zeros if l1 and l2 are different sizes
      if (l1.size < l2.size) {
         padZeros(l1, l2.size - l1.size);
      } else if (l2.size < l1.size) {
         padZeros(l2, l1.size - l2.size);
      }

      SinglyLinkedList sumList = new SinglyLinkedList();
      int lastCarry = sumForwardHelper(l1.head, l2.head, sumList);
      if (lastCarry > 0)   sumList.insertAsHead(lastCarry);
      return sumList;
   }
   private static void padZeros (SinglyLinkedList list, int numZeros) {
      int count = 0;
      while (count < numZeros) {
         list.insertAsHead(0);
         count++;
      }
   }
   private static int sumForwardHelper (Node h1, Node h2, SinglyLinkedList sumList) {
      if (h1 == null  &&  h2 == null) {
         return 0;
      }

      int digit1 = h1 == null ? 0 : h1.data;
      int digit2 = h2 == null ? 0 : h2.data;

      int sum = digit1 + digit2 + sumForwardHelper (h1.next, h2.next, sumList);
      sumList.insertAsHead(sum % 10);
      return sum / 10;
   }

   /** Assuming a (corrupted) circular linked list, return the node at the beginning of the loop. */
   public static Node getCollision (Node head) {
      Node slow = head;
      Node fast = head;

      //Find collision by using a fast and slow pointer
      while (true) {
         slow = slow.next;
         fast = fast.next.next;
         if (slow == fast) {
            break;
         }
      }

      //Traverse from head and from collision at same speed until collide
      Node startAtHead = head;
      while (startAtHead != slow) {
         startAtHead = startAtHead.next;
         slow = slow.next;
      }

      return slow;
   } 

   /** Check if data in a linked list represents a palindrome. */
   public boolean isPalindrome() {
      //Return true on empty linked list
      if (this.head == null) {
         return true;
      }

      Node slow = this.head;
      Node fast = this.head;
      Stack<Node> firstHalf = new Stack<Node>();

      while (true) {
         Node n = slow;
         firstHalf.push(n);
         slow = slow.next;
         if (fast.next == null  ||  fast.next.next == null) {
            break;
         }
         fast = fast.next.next;
      }

      //For odd number of element in list
      if (fast.next == null) {
         firstHalf.pop();
      } 

      //Now compare elements popped from stack to second half
      Node secondHalfCursor = slow;
      while (!firstHalf.empty()  &&  secondHalfCursor != null) {
         Node popped = firstHalf.pop();
         if (popped.data != secondHalfCursor.data) {
            return false;
         }
         secondHalfCursor = secondHalfCursor.next;
      }

      //In case of miscount
      if (!firstHalf.empty()  ||  secondHalfCursor != null) {
         return false;
      }

      return true;
   }
}
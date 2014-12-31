package LinkedLists;

/**
 * Implementation of a stack backed by a singly linked list.
 */
public class StackByLinkedList extends SinglyLinkedList {
    SinglyLinkedList list;

    public StackByLinkedList() {
	list = new SinglyLinkedList();
    }

    public StackByLinkedList(int data) {
	list = new SinglyLinkedList(data);
    }

    public void push(int data) {
	list.insertAsHead(data);
    }

    public int pop() {
	Node popped = list.head;
	list.head = list.head.next;
	return popped.data;
    }

    public int top() {
	return list.head.data;
    }
}
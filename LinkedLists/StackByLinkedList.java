/**
 * Implementation of a stack backed by a singly linked list.
 */
public class StackByLinkedList<T> {
	SinglyLinkedList<T> list;

	public StackByLinkedList() {
		list = new SinglyLinkedList<T>();
	}

	public StackByLinkedList(T data) {
		list = new SinglyLinkedList<T>(data);
	}

	public void push(T data) {
		list.insertAsHead(data);
	}

	public T pop() {
		return list.removeHead();
	}

	public T top() {
		return list.getHead();
	}
}
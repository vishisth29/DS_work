package Lecture24;

public class LinkedList {

	private class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	Node head;
	Node tail;
	int size;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	// O(n)
	public void display() {
		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}

		System.out.println("END");
	}

	public void addFirst(int data) {
		Node node = new Node(data, this.head);

		if (this.size == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.head = node;
		}

		this.size++;
	}

	public void addLast(int data) {
		Node node = new Node(data, null);

		if (this.size == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}

		this.size++;
	}

	// O(n)
	public void addAt(int data, int idx) throws Exception {
		if (idx < 0 || idx > this.size) {
			throw new Exception("Index out of bound");
		}

		if (idx == 0) {
			this.addFirst(data);
		} else if (idx == this.size) {
			this.addLast(data);
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;

			Node node = new Node(data, n);
			nm1.next = node;

			this.size++;
		}
	}

	public int getFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		return this.head.data;
	}

	public int getLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		return this.tail.data;
	}

	// O(n)
	public int getAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Index out of bound.");
		}

		Node node = this.getNodeAt(idx);
		return node.data;
	}

	// O(n)
	private Node getNodeAt(int idx) {
		Node rv = this.head;

		int counter = 0;
		while (counter < idx) {
			rv = rv.next;
			counter++;
		}

		return rv;
	}

	public int removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		int rv = this.head.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}

		this.size--;

		return rv;
	}

	// O(n)
	public int removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		int rv = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node nm2 = this.getNodeAt(this.size - 2);
			nm2.next = null;
			this.tail = nm2;
		}

		this.size--;

		return rv;
	}

	public int removeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Index out of bound.");
		}

		if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size - 1) {
			return this.removeLast();
		} else {
			Node prev = this.getNodeAt(idx - 1);
			Node curr = prev.next;
			Node next = curr.next;

			prev.next = next;
			this.size--;

			return curr.data;
		}
	}

	// O(n^2)
	public void reverseDI() {
		int left = 0, right = this.size - 1;

		while (left <= right) {
			Node leftNode = this.getNodeAt(left);
			Node rightNode = this.getNodeAt(right);

			int temp = leftNode.data;
			leftNode.data = rightNode.data;
			rightNode.data = temp;

			left++;
			right--;
		}
	}

	// O(n)
	public void reversePI() {
		Node prev = null, curr = this.head, next = curr.next;

		while (next != null) {
			curr.next = prev;

			prev = curr;
			curr = next;
			next = next.next;
		}

		// manage the remaining one
		curr.next = prev;

		// swap heads and tails
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
	}

	// O(n)
	public void reverseDR() {
		// this.reverseDR(this.head, this.head);
		HeapMover left = new HeapMover(this.head);
		this.reverseDR(left, this.head, 0);
	}

	private void reverseDR(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}

		reverseDR(left, right.next, floor + 1);

		if (floor > this.size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;

			left.node = left.node.next;
		}
	}

	// private void reverseDR(Node left, Node right){
	// if(right == null){
	// return;
	// }
	//
	// reverseDR(left, right.next);
	//
	// int temp = left.data;
	// left.data = right.data;
	// right.data = temp;
	//
	// left = left.next;
	// }

	private class HeapMover {
		Node node;

		HeapMover(Node node) {
			this.node = node;
		}
	}

	// O(n)
	public void reversePR() {
		this.reversePR(this.head);

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;
	}

	private void reversePR(Node right) {
		if (right == this.tail) {
			return;
		}

		this.reversePR(right.next);
		right.next.next = right;

	}

	public void fold() {
		HeapMover left = new HeapMover(this.head);
		this.fold(left, this.head, 0);
	}

	private void fold(HeapMover left, Node right, int floor) {
		if (right == tail) {
			return;
		}

		fold(left, right.next, floor + 1);

		if (floor >= this.size / 2) {
			Node leftNext = left.node.next;
			Node rightNext = right.next;

			// removal
			right.next = null;

			// add
			left.node.next = rightNext;
			rightNext.next = leftNext;

			// increment left
			left.node = leftNext;

			if (floor == this.size / 2) {
				this.tail = right;
			}
		}
	}

	public int kthItemFromLast(int pos) throws Exception {
		if (pos <= 0 || pos > this.size) {
			throw new Exception("Out of bound");
		}
		Node slow = this.head, fast = this.head;

		for (int i = 0; i < pos; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;
	}

	public int kthItemFromLastR(int pos) throws Exception {
		if (pos <= 0 || pos > this.size) {
			throw new Exception("Out of bound");
		}

		HMK mover = new HMK();
		mover.pos = pos;
		this.kthItemFromLast(mover, this.head);
		return mover.data;
	}

	private void kthItemFromLast(HMK mover, Node node) {
		if (node == null) {
			return;
		}

		this.kthItemFromLast(mover, node.next);

		if (mover.pos > 0) {
			mover.pos--;
			if (mover.pos == 0) {
				mover.data = node.data;
			}
		}
	}

	private class HMK {
		int pos;
		int data;
	}

	public int mid() {
		return this.midNode().data;
	}

	private Node midNode() {
		Node slow = this.head, fast = this.head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public LinkedList merge(LinkedList other) {
		LinkedList rv = new LinkedList();

		Node otherTemp = other.head, thisTemp = this.head;
		while (thisTemp != null && otherTemp != null) {
			if (thisTemp.data < otherTemp.data) {
				rv.addLast(thisTemp.data);
				thisTemp = thisTemp.next;
			} else {
				rv.addLast(otherTemp.data);
				otherTemp = otherTemp.next;
			}
		}

		while (thisTemp != null) {
			rv.addLast(thisTemp.data);
			thisTemp = thisTemp.next;
		}

		while (otherTemp != null) {
			rv.addLast(otherTemp.data);
			otherTemp = otherTemp.next;
		}

		return rv;
	}

	public void mergeSort() {
		LinkedList sorted = this.mergeSortHelper();
		this.head = sorted.head;
		this.tail = sorted.tail;
		this.size = sorted.size;
	}

	private LinkedList mergeSortHelper() {
		if (this.size == 1) {
			return this;
		}

		Node mid = this.midNode();
		Node midNext = mid.next;

		LinkedList fhalf = new LinkedList();
		fhalf.head = this.head;
		fhalf.tail = mid;
		fhalf.tail.next = null;
		fhalf.size = (this.size + 1) / 2;

		LinkedList shalf = new LinkedList();
		shalf.head = midNext;
		shalf.tail = this.tail;
		shalf.size = (this.size) / 2;

		fhalf = fhalf.mergeSortHelper();
		shalf = shalf.mergeSortHelper();

		LinkedList sorted = fhalf.merge(shalf);
		return sorted;
	}

	public int find(int data) {
		Node temp = this.head;
		int rv = 0;

		while (temp != null) {
			if (temp.data == data) {
				return rv;
			}

			temp = temp.next;
			rv++;
		}

		return -1;
	}
}

package Lecture25;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.sound.midi.Synthesizer;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children;
		
		public Node(int data){
			this.data = data;
			this.children = new ArrayList<>();
		}
	}
	
	private Node root;
	private int size;
	
	public GenericTree(){
		Scanner scn = new Scanner(System.in);
		this.root = this.takeInput(scn, null, -1);
	}
	
	private Node takeInput(Scanner scn, Node parent, int ith){
		if(parent == null){
			System.out.println("Enter the data for root node ");
		} else {
			System.out.println("Enter the data for " + ith + " child of " + parent.data);
		}
		
		int data = scn.nextInt();
		
		// child is made but, its children are yet to be made
		Node child = new Node(data);
		this.size++;
		
		System.out.println("Enter the number of children for " + child.data);
		int nc = scn.nextInt();
		
		for(int i = 0; i < nc; i++){
			Node grandChild = this.takeInput(scn, child, i);
			child.children.add(grandChild);
		}
		
		return child;
	}
	
	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return this.size() == 0;
	}
	
	public void display(){
		this.display(this.root);
		System.out.println("*********************");
	}
	
	private void display(Node node){
		System.out.print(node.data + " => ");
		for(int i = 0; i < node.children.size(); i++){
			System.out.print(node.children.get(i).data + ", ");
		}
		
		System.out.println("END");
		
		for(Node child: node.children){
			this.display(child);
		}
	}

	public int size2(){
		return this.size2(this.root);
	}
	
	private int size2(Node node){
		int rv = 0;
		
		for(int i = 0; i < node.children.size(); i++){
			int ctSize = this.size2(node.children.get(i));
			rv += ctSize;
		}
		
		// for the node itself
		rv += 1;
		
		return rv;
	}

	public int height(){
		return this.height(this.root);
	}
	
	private int height(Node node){
		int maxChildHeight = -1;
		
		for(Node child: node.children){
			int ch = this.height(child);
			if(ch > maxChildHeight){
				maxChildHeight = ch;
			}
		}
		
		// for the node itself
		maxChildHeight = maxChildHeight + 1;
		
		return maxChildHeight;
	}

	public int max(){
		return this.max(this.root);
	}
	
	private int max(Node node){
		int rv = node.data;
		
		for(Node child: node.children){
			int cmax = this.max(child);
			if(cmax > rv){
				rv = cmax;
			}
		}
		
		return rv;
	}
	
	public boolean find(int data){
		return this.find(data, this.root);
	}
	
	private boolean find(int data, Node node){
		if(node.data == data){
			return true;
		}
		
		for(Node child: node.children){
			boolean foundInChild = this.find(data, child);
			if(foundInChild){
				return true;
			}
		}
		
		return false;
	}
	
	public void mirror(){
		this.mirror(this.root);
	}
	
	private void mirror(Node node){
		for(Node child: node.children){
			this.mirror(child);
		}
		
		int left = 0, right = node.children.size() - 1;
		while(left <= right){
			Node temp = node.children.get(left);
			node.children.set(left, node.children.get(right));
			node.children.set(right, temp);
			
			left++;
			right--;
		}
	}

	public void preOrder(){
		this.preOrder(this.root);
		System.out.println("END");
	}
	
	private void preOrder(Node node){
		System.out.print(node.data + ", ");
		for(Node child: node.children){
			preOrder(child);
		}
	}
	
	public void postOrder(){
		this.postOrder(this.root);
		System.out.println("END");
	}
	
	private void postOrder(Node node){
		for(Node child: node.children){
			postOrder(child);
		}
		System.out.print(node.data + ", ");
	}

	public void levelOrder(){
		LinkedList<Node> queue = new LinkedList<>();
		
		queue.addLast(this.root); // enqueue
		while(!queue.isEmpty()){
			Node temp = queue.removeFirst(); // dequeue
			
			System.out.print(temp.data + ", ");
			
			for(Node child: temp.children){
				queue.addLast(child);
			}
		}
		
		System.out.println("END");
	}
	
	public void preOrderI(){
		LinkedList<Node> stack = new LinkedList<>();
		
		stack.addFirst(this.root); // push
		while(!stack.isEmpty()){
			Node temp = stack.removeFirst(); // pop
			
			System.out.print(temp.data + ", ");
			
			for(int i = temp.children.size() - 1; i >= 0; i--){
				stack.addFirst(temp.children.get(i));
			}
		}
		
		System.out.println("END");
	}

	public int justLarger(int data){
		return 0;
	}
	
	public int maxSONC(){
		return this.maxSONC(this.root).data;
	}
	
	private Node maxSONC(Node node){
		Node rv = node;
		
		for(Node child: node.children){
			Node cmax = maxSONC(child);
			
			int cmaxScore = getSONCScore(cmax);
			int rvScore = getSONCScore(rv);
			
			if(cmaxScore > rvScore){
				rv = cmax;
			}
		}
		
		return rv;
	}
	
	private int getSONCScore(Node node){
		System.out.println("Hi to " + node.data);
		int rv = node.data;
		
		for(Node child: node.children){
			rv += child.data;
		}
		
		return rv;
	}
	
	private class HeapMover {
		Node node;
		int SONCscore;
		
		HeapMover(Node node){
			this.node = node;
			this.SONCscore = getSONCScore(node);
		}
	}
	
	public int maxSONC2(){
		HeapMover mover = this.maxSONC2(this.root);
		return mover.node.data;
	}
	
	private HeapMover maxSONC2(Node node){
		HeapMover rv = new HeapMover(node);
		
		for(Node child: node.children){
			HeapMover cmax = maxSONC2(child);
			
//			int cmaxScore = getSONCScore(cmax);
//			int rvScore = getSONCScore(rv);
			
			if(cmax.SONCscore > rv.SONCscore){
				rv = cmax;
			}
		}
		
		return rv;
	}
	
	public void linearize(){
		this.linearize(this.root);
	}
	
	private void linearize(Node node){
		for(Node child: node.children){
			this.linearize(child);
		}
		
		while(node.children.size() > 1){
			Node removed = node.children.remove(1);
			Node zerokitail = this.getTail(node.children.get(0));
			zerokitail.children.add(removed);
		}
	}
	
	private Node getTail(Node node){
		Node temp = node;
		
		while(temp.children.size() != 0){
			temp = temp.children.get(0);
		}
		
		return temp;
	}
	
	private class HeapMoverLinearize {
		Node head;
		Node tail;
		
		public HeapMoverLinearize(Node head, Node tail) {
			this.head = head;
			this.tail = tail;
		}
	}
	
	public void linearize2(){
		this.linearize2(this.root);
	}
	
	private HeapMoverLinearize linearize2(Node node){
		if(node.children.size() == 0){
			return new HeapMoverLinearize(node, node);
		}
		HeapMoverLinearize prev = this.linearize2(node.children.get(0));
		
		while(node.children.size() > 1){
			// remove
			Node removed = node.children.remove(1);
				
			// linearize
			HeapMoverLinearize curr = this.linearize2(removed);
			
			// add
			prev.tail.children.add(curr.head);
			
			// update prev tail
			prev.tail = curr.tail;
		}
		
		// update prev head;
		prev.head = node;
		
		return prev;
	}
	
	private class HeapMoverRange {
		private int min;
		private int max;
		
		HeapMoverRange(Node node){
			this.min = node.data;
			this.max = node.data;
		}
		
		public HeapMoverRange() {
			this.min = Integer.MAX_VALUE;
			this.max = Integer.MIN_VALUE;
		}
	}
	
	public int getRange(){
		HeapMoverRange mover = this.getRange(this.root);
		return mover.max - mover.min;
		
	}
	
	private HeapMoverRange getRange(Node node){
		HeapMoverRange rv = new HeapMoverRange(node);
		
		for(Node child: node.children){
			HeapMoverRange cmover = this.getRange(child);
			
			if(cmover.min < rv.min){
				rv.min = cmover.min;
			}
			
			if(cmover.max > rv.max){
				rv.max = cmover.max;
			}
		}
		
		return rv;
	}

	public int getRange2(){
		HeapMoverRange mover = new HeapMoverRange();
		this.getRange2(this.root, mover);
		return mover.max - mover.min;
	}
	
	private void getRange2(Node node, HeapMoverRange mover){
		// work
		if(node.data < mover.min){
			mover.min = node.data;
		}
		
		if(node.data > mover.max){
			mover.max = node.data;
		}
		
		
		for(Node child: node.children){
			getRange2(child, mover);
		}
	}
}

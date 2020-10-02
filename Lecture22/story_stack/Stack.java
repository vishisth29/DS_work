package Lecture22.story_stack;

public class Stack {
	protected int[] data;
	private int tos;
		
	public static final int DEFAULT_CAPACITY = 10;
	
	public Stack(int capacity){
		this.data = new int[capacity];
		this.tos = -1;
	}
	
	public Stack(){
		this(DEFAULT_CAPACITY);
	}
	
	public int size(){
		return this.tos + 1;
	}
	
	public boolean isEmpty(){
		return this.size() == 0;
	}
	
	public void push(int item) throws Exception {
		if(this.size() == this.data.length){
			throw new Exception("Stack is full.");
		}
		
		this.tos++;
		this.data[this.tos] = item;
	}
	
	public int pop() throws Exception {
		if(this.isEmpty()){
			throw new Exception("Stack is empty.");
		}
		
		int rv = this.data[this.tos];
		
		this.tos--;
		
		return rv;
	}
	
	public int top() throws Exception {
		if(this.isEmpty()){
			throw new Exception("Stack is empty.");
		}
		
		int rv = this.data[this.tos];
		return rv;
	}
	
	public void display(){
		System.out.println("*******************************************");
		System.out.println("TOS = " + this.tos + ", Capacity = " + this.data.length);
		for(int i = this.tos; i >= 0; i--){
			System.out.print(this.data[i] + ", ");
		}
		
		System.out.println("END");
		System.out.println("*******************************************");
	}
}

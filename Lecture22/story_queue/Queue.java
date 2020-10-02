package Lecture22.story_queue;

public class Queue {
	protected int[] data;
	protected int front;
	private int size;
	
	public static final int DEFAULT_CAPACITY = 10;
	
	public Queue(int capacity){
		this.data = new int[capacity];
		this.front = 0;
		this.size = 0;
	}
	
	public Queue(){
		this(DEFAULT_CAPACITY);
	}
	
	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return this.size() == 0;
	}

	public void enqueue(int item) throws Exception {
		if(this.size() == this.data.length){
			throw new Exception("Queue is full");
		}
		
		int ai = (this.front + this.size) % this.data.length;
		this.data[ai] = item;
		this.size++;
	}
	
	public int dequeue() throws Exception {
		if(this.isEmpty()){
			throw new Exception("Queue is empty");
		}
		
		int rv = this.data[this.front];
		
		this.front = (this.front + 1) % this.data.length;
		this.size--;
		
		return rv;
	}
	
	public int front() throws Exception {
		if(this.isEmpty()){
			throw new Exception("Queue is empty");
		}
		
		int rv = this.data[this.front];
		return rv;
	}
	
	public void display(){
		for(int i = 0; i < this.size(); i++){
			int ai = (this.front + i) % this.data.length;
			System.out.print(this.data[ai] + ", ");
		}
		
		System.out.println("END");
		System.out.println("*****************************");
	}
}

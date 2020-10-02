package Lecture23.story_queue;

import Lecture22.story_queue.Queue;

public class DynamicQueue extends Queue {
	public DynamicQueue(int capacity){
		super(capacity);
	}
	
	public DynamicQueue(){
		this(DEFAULT_CAPACITY);
	}
	
	@Override
	public void enqueue(int item) throws Exception {
		if(this.size() == this.data.length){
			int[] temp = this.data;
			
			this.data = new int[2 * temp.length];
			for(int i = 0; i < this.size(); i++){
				int ai = (this.front + i) % temp.length;
				this.data[i] = temp[ai];
			}
			this.front = 0;
		}
	
		super.enqueue(item);
	}
	
	public int dequeue() throws Exception {
		if(this.size() == this.data.length / 4){
			int[] temp = this.data;
			
			this.data = new int[this.data.length / 2];
			for(int i = 0; i < this.size(); i++){
				int ai = (this.front + i) % temp.length;
				this.data[i] = temp[ai];
			}
			
			this.front = 0;
		}
		
		return super.dequeue();
	}
	
	public void display(){
		System.out.println("*******************************************");
		System.out.println("Front = " + this.front + ", Capacity = " + this.data.length);
		
		super.display();
	}
}

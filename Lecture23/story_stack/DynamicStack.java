package Lecture23.story_stack;

import Lecture22.story_stack.Stack;

public class DynamicStack extends Stack {
	public DynamicStack(int capacity){
		super(capacity);
	}
	
	public DynamicStack(){
		this(DEFAULT_CAPACITY);
	}
	
	public void push(int item) {
		if (this.size() == super.data.length) {
			int[] temp = super.data;

			super.data = new int[temp.length * 2];

			for (int i = 0; i < temp.length; i++) {
				super.data[i] = temp[i];
			}
		}

		try {
			super.push(item);
		} catch (Exception ex) {
			// never going to land here, because we have handled the exception
			// case above.
		}
	}
	
	public int pop() throws Exception {
		if(this.size() == super.data.length / 4){
			int[] temp = super.data;
			
			super.data = new int[super.data.length / 2];
			
			for(int i = 0; i < this.size(); i++){
				super.data[i] = temp[i];
			}
		}
		
		return super.pop();
	}
	
	
}

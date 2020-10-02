package Lecture23.story_stack;

import Lecture22.story_stack.Stack;

public class DynamicStackClient {

	public static void main(String[] args) {
		try {
			Stack st = new DynamicStack(4);

			for (int i = 0; i < 20; i++) {
				st.push(20 - i);
				displayStackInfo(st);
			}
			
			System.out.println("Point 1");
			st.push(100);
			displayStackInfo(st);
			System.out.println("Point 2");
			
			while(!st.isEmpty()){
				System.out.println(st.top());
				System.out.println(st.pop());
				displayStackInfo(st);
			}
			
			System.out.println("Point 3");
			st.pop();
			System.out.println("Point 4");
		} catch (Exception ex) {
			System.out.println(ex);
			System.out.println("Bye");
		}
	}
	
	public static void displayStackInfo(Stack st){
		System.out.println("Size = " + st.size());
		System.out.println("Empty = " + st.isEmpty());
		st.display();
	}

}

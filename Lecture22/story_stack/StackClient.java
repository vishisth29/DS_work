package Lecture22.story_stack;

public class StackClient {

	public static void main(String[] args) {
		try {
			Stack st = new Stack(5);

			for (int i = 0; i < 5; i++) {
				st.push(5 - i);
				displayStackInfo(st);
			}
			
			System.out.println("Point 1");
			st.push(100);
			System.out.println("Point 2");
			
			while(!st.isEmpty()){
				System.out.println(st.top());
				System.out.println(st.pop());
				displayStackInfo(st);
			}
			
//			System.out.println("Point 3");
//			st.pop();
//			System.out.println("Point 4");
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

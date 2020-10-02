package Lecture22.story_queue;

public class QueueClient {

	public static void main(String[] args) {
		try {
			Queue qu = new Queue(5);

			for (int i = 0; i < 5; i++) {
				qu.enqueue(5 - i);
				displayQueueInfo(qu);
			}
			
//			System.out.println("Point 1");
//			qu.enqueue(100);
//			System.out.println("Point 2");
			
			System.out.println(qu.front());
			System.out.println(qu.dequeue());
			displayQueueInfo(qu);
			
			System.out.println(qu.front());
			System.out.println(qu.dequeue());
			displayQueueInfo(qu);
			
			qu.enqueue(50);
			displayQueueInfo(qu);
			
			qu.enqueue(40);
			displayQueueInfo(qu);
			
//			System.out.println("Point 3");
//			qu.dequeue();
//			System.out.println("Point 4");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public static void displayQueueInfo(Queue qu){
		System.out.println("Size = " + qu.size());
		System.out.println("Empty = " + qu.isEmpty());
		qu.display();
	}

}

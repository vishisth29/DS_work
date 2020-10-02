package Lecture23.story_queue;

import Lecture22.story_queue.Queue;

public class DynamicQueueClient {

	public static void main(String[] args) {
		try {
			Queue qu = new DynamicQueue(4);

			for (int i = 0; i < 20; i++) {
				qu.enqueue(20 - i);
				displayQueueInfo(qu);
			}

			System.out.println("Point 1");
			qu.enqueue(100);
			System.out.println("Point 2");

			while (!qu.isEmpty()) {
				System.out.println(qu.front());
				System.out.println(qu.dequeue());
				displayQueueInfo(qu);
			}

			System.out.println("Point 3");
			qu.dequeue();
			System.out.println("Point 4");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void displayQueueInfo(Queue qu) {
		System.out.println("Size = " + qu.size());
		System.out.println("Empty = " + qu.isEmpty());
		qu.display();
	}

}

package Lecture24;

public class Client {

	public static void main(String[] args) throws Exception {
		LinkedList list = new LinkedList();
		
		list.addFirst(10);
		list.addFirst(5);
		list.addFirst(0);
		list.addFirst(-5);
		list.addLast(50);
		list.addLast(100);
		list.addLast(200);
		
		list.display();
		
		list.reverseDI();
		list.display();
		
		list.reversePI();
		list.display();
		
		list.reversePR();
		list.display();
		
		list.reverseDR();
		list.display();
		
//		list.fold();
//		list.display();
		
		System.out.println(list.kthItemFromLast(3));
		System.out.println(list.kthItemFromLastR(3));
		
		System.out.println(list.mid());
		
		LinkedList list2 = new LinkedList();
		
		list2.addLast(20);
		list2.addLast(25);
		list2.addLast(45);
		list2.addLast(58);
		list2.addLast(205);
		
		list2.display();
		
		
		LinkedList list3 = list.merge(list2);
		list3.display();
		
		list3.fold();
		list3.display();
		
		list3.mergeSort();
		list3.display();
	}

}

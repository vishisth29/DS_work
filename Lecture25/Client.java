package Lecture25;

public class Client {

// 10 3 20 2 50 0 60 0 30 3 70 0 80 0 90 0 40 2 100 0 110 0
	public static void main(String[] args) {
		GenericTree gt = new GenericTree();
		
//		System.out.println(gt.size());
//		System.out.println(gt.size2());
		
		
//		gt.display();
//		gt.mirror();
//		gt.display();
		
		System.out.println(gt.max());
		System.out.println(gt.find(65));
		System.out.println(gt.find(70));
		System.out.println(gt.height());
		
		gt.preOrder();
		gt.postOrder();
		gt.levelOrder();
		gt.preOrderI();
		
		System.out.println(gt.maxSONC2());
		
		gt.display();
		gt.linearize2();
		gt.display();
		
		System.out.println(gt.getRange());
		System.out.println(gt.getRange2());
	}

}

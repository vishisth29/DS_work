package Lecture2;

public class LargestOfThree {

	public static void main(String[] args) {
		int a = 5, b = 10, c = 20;
		
		/*if(a >= b && a >= c){
			System.out.println("Largest number is " + a);
			return;
		}
		
		if(b >= a && b >= c){
			System.out.println("Largest number is " + b);
			return;
		}
		
		System.out.println("Largest number is " + c);*/
		
		/*if(a >= b && a >= c){
			System.out.println("Largest number is " + a);
		}
		else {
			if(b >= a && b >= c){
				System.out.println("Largest number is " + b);
			}
			else {
				System.out.println("Largest number is " + c);
			}
		}*/
		
		if(a >= b && a >= c){
			System.out.println("Largest number is " + a);
		}
		else if(b >= a && b >= c){
			System.out.println("Largest number is " + b);
		}
		else {
			System.out.println("Largest number is " + c);
		}
	}

}

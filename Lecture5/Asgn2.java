package Lecture5;

import java.util.Scanner;

public class Asgn2 {

	public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
//		Q12();
//		Q14();
//		Q15();
		System.out.println(Q10(243, 3));
	}
	
	public static void Q12(){
		System.out.println("Enter the number ");
		int N = scn.nextInt();
		
		int sqrt = 0;
		while(sqrt * sqrt <= N){
			sqrt++;
		}
		
		System.out.println(sqrt - 1);
	}
	
	public static void Q14(){
		// '5' - '0' = 5
		System.out.println("Enter the character ");
		char ch = scn.next().charAt(0);
		
		if(ch >= 'A' && ch <= 'Z'){
			System.out.println("U");
		}
		else if(ch >= 'a' && ch <= 'z'){
			System.out.println("L");
		}
		else {
			System.out.println("I");
		}
	}
	
	public static void Q15(){
		System.out.println("How many numbers? ");
		int N = scn.nextInt();
		
		System.out.println("Enter first number ");
		int prev = scn.nextInt();
		
		int counter = 2;
		boolean goingDown = true;
		
		while(counter <= N){
			System.out.println("Enter " + counter + "th number");
			int current = scn.nextInt();
			
			// from here
			if(goingDown){
				if(current > prev){
					goingDown = false;
				}
			}
			else {
				if(current < prev){
					System.out.println("Invalid");
					return;
				}
			}
			// to here
					
			prev = current;
			counter++;
		}
		
		System.out.println("Valid");
	}
	
	public static int Q10(int x, int n){
		int rv = 0;
		
		while(x != 1){
			x = x / n;
			rv++;
		}
		
		return rv;
	}

}

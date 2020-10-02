package Lecture2;

import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {
		// Take input
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Please enter the number ");
		int N = scn.nextInt();
		
		// check if it is prime
		int divisor = 2;
		while(divisor < N){
			if(N % divisor == 0){
				System.out.println(N + " is not prime");
				return;
			}
			else {
				// kuch nai aaega
			}
			
			divisor = divisor + 1;
		}
		
		System.out.println(N + " is prime");
		
		// print result
	}

}

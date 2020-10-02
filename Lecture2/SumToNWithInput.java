package Lecture2;

import java.util.Scanner;

public class SumToNWithInput {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Please enter the number ");
		int N = scn.nextInt();
		
		int sum = 0, counter = 1;
		while (counter <= N) {
			sum = sum + counter;
			counter = counter + 1;
		}

		System.out.println("Sum upto " + N + " is " + sum);
	}

}

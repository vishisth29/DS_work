package Lecture3;

import java.util.Scanner;

public class B2D {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter the number in base 2 ");
		int bin = scn.nextInt();
		
		int dec = 0, twoPowers = 1;
		while(bin != 0){
			int rem = bin % 10;
			
			dec = dec + rem * twoPowers;
			twoPowers = twoPowers * 2;
			
			bin = bin / 10;
		}
		
		System.out.println("Decimal value = " + dec);
	}

}

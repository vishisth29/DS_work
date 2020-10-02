package Lecture6;

import java.util.Scanner;

public class SquareRoot {

	public static void main(String[] args) {
		double d = 1;
		double i = 0.1;
		d = d * i;
		System.out.println(d);
//		d = d * i;
//		d = d * i;
//		d = d * i;
//		System.out.println(Math.round(d * 1000)/ 1000.0);
//		System.out.println(d);
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter the number ");
		int N = scn.nextInt();
		
		System.out.println("Enter the precision ");
		int P = scn.nextInt();
		
		double sqrt = 0;
		double increment = 1;
		double dHelper = 1.0;
		int iHelper = 1;
		
		while(P != 0){
			increment = increment * 0.1;
			dHelper *= 10;
			iHelper *= 10;
			
			P--;
		}
		
		while(sqrt * sqrt <= N){
			sqrt += increment;
			System.out.println(sqrt + ", " + (Math.round(sqrt * iHelper) / dHelper));
		}
		
		sqrt = sqrt - increment;
		System.out.println(sqrt);
		System.out.println(Math.round(sqrt * iHelper) / dHelper);
	}

}

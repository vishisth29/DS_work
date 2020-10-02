package Lecture5;

import java.util.Scanner;

public class Asgn1 {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// Q6();
		// Q9();
		Q10(4);
	}

	public static void Q6() {
		System.out.println("Please enter the number");
		int N = scn.nextInt();

		int counter = 1, sO = 0, sE = 0;
		while (N != 0) {
			int rem = N % 10;

			if (counter % 2 == 0) {
				sE += rem;
			} else {
				sO += rem;
			}

			N = N / 10;
			counter++;
		}

		System.out.println("Sum of odd digits is " + sO);
		System.out.println("Sum of even digits is " + sE);
	}

	public static void Q9() {
		System.out.println("Enter the number of rows ");
		int N = scn.nextInt();

		int row = 1, col = 1, numSpaces = N - 1, numIncNums = 1, numDecNums = 0;
		int value = 0, initValue = 1;
		while (row <= 2 * N - 1) {
			// spaces
			col = 1;
			while (col <= numSpaces) {
				System.out.print("  ");
				col++;
			}

			// Increasing numbers
			col = 1;
			value = initValue;
			while (col <= numIncNums) {
				System.out.print(value + " ");
				value++;
				col++;
			}

			// Decreasing numbers
			col = 1;
			value = value - 2;
			while (col <= numDecNums) {
				System.out.print(value + " ");
				value--;
				col++;
			}

			if (row >= N) {
				numSpaces++;
				numIncNums--;
				numDecNums--;
				initValue--;
			} else {
				numSpaces--;
				numIncNums++;
				numDecNums++;
				initValue++;
			}

			System.out.println();
			row++;
		}
	}

	public static void Q10(int N) {
		int row = 1, col = 1, numSpaces = 2 * N - 3, numIncNums = 1, numDecNums = 1;
		while (row <= N) {
			// Increasing numbers
			col = 1;
			int value = 1;
			while (col <= numIncNums) {
				if (row != N || value != N) {
					System.out.print(value + " ");
				}
				value++;
				col++;
			}

			// spaces
			col = 1;
			while (col <= numSpaces) {
				System.out.print("  ");
				col++;
			}

			// Decreasing numbers
			col = 1;
			value = value - 1;
			while (col <= numDecNums) {
				System.out.print(value + " ");
				value--;
				col++;
			}

			numSpaces = numSpaces - 2;
			numIncNums++;
			numDecNums++;

			System.out.println();
			row++;
		}
	}
}

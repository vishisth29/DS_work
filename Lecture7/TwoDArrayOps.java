package Lecture7;

import java.util.Scanner;

public class TwoDArrayOps {

	public static void main(String[] args) {
//		int[][] arr = takeInput();
//		display(arr);
		
		int[][] test = {
				{11, 12, 13, 14},
				{21, 22, 23, 24},
				{31, 32, 33, 34}
		};
		spiral(test);
	}
	
	public static int[][] takeInput(){
		int[][] retVal = null;
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter of the number of rows ");
		int rows = scn.nextInt();
		
		retVal = new int[rows][];
		for(int row = 0; row < retVal.length; row++){
			System.out.println("Enter the number of columns for " + row + "th row ");
			int cols = scn.nextInt();
			
			retVal[row] = new int[cols];
			for(int col = 0; col < retVal[row].length; col++){
				System.out.println("Enter the value for cell (" + row + ", " + col + ") ");
				retVal[row][col] = scn.nextInt();
			}
		}
		
		return retVal;
	}
	
	public static void display(int[][] arr){
		if(arr == null){
			System.out.println("No rows, no columns");
		}
		else {
			System.out.println("Rows = " + arr.length);
			for(int row = 0; row < arr.length; row++){
				if(arr[row] == null || arr[row].length == 0){
					System.out.println("Blank row");
				}
				else {
					for(int col = 0; col < arr[row].length; col++){
						System.out.print(arr[row][col] + "\t");
					}
					System.out.println();
				}
			}
		}
	}

	public static void wave(int[][] arr){
		for(int col = 0; col < arr[0].length; col++){
			if(col % 2 == 0){
				for(int row = 0; row < arr.length; row++){
					System.out.println(arr[row][col]);
				}
			}
			else{
				for(int row = arr.length - 1; row >= 0; row--){
					System.out.println(arr[row][col]);
				}
			}
		}
	}

	public static void spiral(int[][] arr){
		int colMin = 0, rowMin = 0, colMax = arr[0].length - 1, rowMax = arr.length - 1;
		int numElements = arr.length * arr[0].length;
		int counter = 1;
		while(counter <= numElements){
			// print min col
			for(int row = rowMin; counter <= numElements && row <= rowMax; row++){
				System.out.println(arr[row][colMin]);
				counter++;
			}
			colMin++;
			
			// print row max
			for(int col = colMin; counter <= numElements && col <= colMax; col++){
				System.out.println(arr[rowMax][col]);
				counter++;
			}
			rowMax--;
			
			// print max col
			for(int row = rowMax; counter <= numElements && row >= rowMin; row--){
				System.out.println(arr[row][colMax]);
				counter++;
			}
			colMax--;
			
			// print min row
			for(int col = colMax; counter <= numElements && col >= colMin; col--){
				System.out.println(arr[rowMin][col]);
				counter++;
			}
			rowMin++;
		}
	}
}

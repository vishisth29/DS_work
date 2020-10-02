package Lecture15;

import java.util.ArrayList;

import Lecture6.ArrayOps;

public class Client {

	public static void main(String[] args) {
//		System.out.println(countNQueens(4));
		// printNQueens(4);
//		System.out.println(getNQueens(4));
		
//		int[] one = {1, 4, 7, 15, 19};
//		int[] two = {3, 6, 9, 18, 20, 29};
//		
//		int[] three = merge(one, two);
//		ArrayOps.display(three);
		
		int[] arr = {15, 2, 6, 1, 18};
		arr = mergeSort(arr, 0, arr.length - 1);
		ArrayOps.display(arr);
	}

	public static int countNQueens(int N) {
		boolean[][] board = new boolean[N][N];
		return countNQueens(board, 0);
	}

	public static int countNQueens(boolean[][] board, int row) {
		if (row == board.length) {
			return 1;
		}

		int count = 0;

		for (int col = 0; col < board.length; col++) {
			if (isSafeTPQ(board, row, col)) {
				board[row][col] = true;
				count += countNQueens(board, row + 1);
				board[row][col] = false;
			}
		}

		return count;
	}

	public static boolean isSafeTPQ(boolean[][] board, int row2test, int col2test) {
		// test column
		for (int row = row2test; row >= 0; row--) {
			if (board[row][col2test]) {
				return false;
			}
		}

		// test diag 1
		for (int row = row2test, col = col2test; row >= 0 && col >= 0; row--, col--) {
			if (board[row][col]) {
				return false;
			}
		}

		// test diag 2
		for (int row = row2test, col = col2test; row >= 0 && col < board.length; row--, col++) {
			if (board[row][col]) {
				return false;
			}
		}

		return true;
	}

	public static void printNQueens(int N) {
		boolean[][] board = new boolean[N][N];
		printNQueens(board, 0, "");
	}

	public static void printNQueens(boolean[][] board, int row, String osf) {
		if (row == board.length) {
			System.out.println(osf + "END");
			return;
		}

		for (int col = 0; col < board.length; col++) {
			if (isSafeTPQ(board, row, col)) {
				board[row][col] = true;
				printNQueens(board, row + 1, osf + "{" + row + "-" + col + "}, ");
				board[row][col] = false;
			}
		}
	}

	public static ArrayList<String> getNQueens(int N) {
		boolean[][] board = new boolean[N][N];
		return getNQueens(board, 0);
	}

	public static ArrayList<String> getNQueens(boolean[][] board, int row) {
		if (row == board.length) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("END\n");

			return baseResult;
		}

		ArrayList<String> myResult = new ArrayList<>();

		for (int col = 0; col < board.length; col++) {
			if (isSafeTPQ(board, row, col)) {
				board[row][col] = true;

				ArrayList<String> recResult = getNQueens(board, row + 1);
				for (int i = 0; i < recResult.size(); i++) {
					myResult.add("{" + row + " - " + col + "}; " + recResult.get(i));
				}

				board[row][col] = false;
			}
		}

		return myResult;
	}

	public static int[] merge(int[] one, int[] two){
		int[] retVal = new int[one.length + two.length];
		
		int i = 0, j = 0, k = 0;
		while(i < one.length && j < two.length){
			if(one[i] < two[j]){
				retVal[k] = one[i];
				k++;
				i++;
			}
			else {
				retVal[k] = two[j];
				k++;
				j++;
			}
		}
		
		while(i < one.length){
			retVal[k] = one[i];
			k++;
			i++;
		}
		
		while(j < two.length){
			retVal[k] = two[j];
			k++;
			j++;
		}
		
		
		
		return retVal;
	}

	public static int[] mergeSort(int[] arr, int lo, int hi){
		if(lo == hi){
			int[] base = new int[1];
			
			base[0] = arr[lo];
			
			return base;
		}
		
		int mid = (lo + hi) / 2;
		int[] fhalf = mergeSort(arr, lo, mid);
		int[] shalf = mergeSort(arr, mid + 1, hi);
		
		int[] complete = merge(fhalf, shalf);
		return complete;
	}
}

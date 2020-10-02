package Lecture14;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		maxSumSA(new int[] { -18, 1, 3, 5, -5, 6 });
		System.out.println(countNQueens(4));
	}

	public static void maxSumSA(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		int maxSi = 0, maxLi = 0;

		for (int si = 0; si < arr.length; si++) {
			int sum = 0;

			for (int li = si; li < arr.length; li++) {
				sum += arr[li];

				if (sum > maxSum) {
					maxSum = sum;
					maxSi = si;
					maxLi = li;
				}
			}
		}

		System.out.println(maxSi + ", " + maxLi);
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
		
		for (int col = 0; col < board[row].length; col++) {
			if (isItSafeTPQ(board, row, col)) {
				board[row][col] = true;
				count += countNQueens(board, row + 1);
				board[row][col] = false;
			}
		}

		return count;
	}

	public static boolean isItSafeTPQ(boolean[][] board, int row, int col) {
		// check col
		for (int i = row - 1; i >= 0; i--) {
			if (board[i][col]) {
				return false;
			}
		}
		
		// check diag1
		for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
			if(board[i][j]){
				return false;
			}
		}
		
		// check diag2
		for(int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++){
			if(board[i][j]){
				return false;
			}
		}
		
		return true;
	}
}

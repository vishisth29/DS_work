package Lecture19;

import java.util.Random;

import Lecture16.TnSDemos;

public class DP {
	/*
	 * 1. Fib - N, Btr, Btr2
	 * 2. CBP - N, Btr, Btr2
	 * 3. CMP - N, Btr, Iter
	 * 4. LCS - N, Btr, Iter
	 * 5. ED - N, Btr, Iter
	 * 6. MCM - N, Btr
	 * 7. KS - N, Btr
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Part 1
		int N = 40;

		TnSDemos.init();
		System.out.println(Fib(N));
		System.out.println("Fib took " + TnSDemos.duration() + " for " + N + " items.");

		TnSDemos.init();
		System.out.println(FibBtr(N, new int[N + 1]));
		System.out.println("FibBtr took " + TnSDemos.duration() + " for " + N + " items.");

		TnSDemos.init();
		System.out.println(FibBtr2(N, new int[2]));
		System.out.println("FibBtr2 took " + TnSDemos.duration() + " for " + N + " items.");

		// Part 2
		N = 27;

		TnSDemos.init();
		System.out.println(countBoardPaths(N, 0));
		System.out.println("countBoardPaths took " + TnSDemos.duration() + " for " + N + " items.");

		TnSDemos.init();
		System.out.println(countBoardPathsBtr(N, 0, new int[N + 1]));
		System.out.println("countBoardPathsBtr took " + TnSDemos.duration() + " for " + N + " items.");

		TnSDemos.init();
		System.out.println(countBoardPathsBtr2(N, 0, new int[6]));
		System.out.println("countBoardPathsBtr2 took " + TnSDemos.duration() + " for " + N + " items.");

		// Part 3
		N = 14;

		TnSDemos.init();
		System.out.println(countMazePaths(N, N, 0, 0));
		System.out.println("countMazePaths took " + TnSDemos.duration() + " for " + N + " items.");

		TnSDemos.init();
		System.out.println(countMazePathsBtr(N, N, 0, 0, new int[N + 1][N + 1]));
		System.out.println("countMazePathsBtr took " + TnSDemos.duration() + " for " + N + " items.");

		TnSDemos.init();
		System.out.println(countMazePathsIterative(N, N));
		System.out.println("countMazePathsIterative took " + TnSDemos.duration() + " for " + N + " items.");

		// Part 4
		String s1 = "adsgzsssdhftgddadsj";
		String s2 = "ashjdsdzfdsdhfzt";

		TnSDemos.init();
		System.out.println(lcs(s1, s2));
		System.out.println("lcs took " + TnSDemos.duration());

		TnSDemos.init();
		System.out.println(lcsBtr(s1, s2, new int[s1.length() + 1][s2.length() + 1]));
		System.out.println("lcsBtr took " + TnSDemos.duration());

		TnSDemos.init();
		System.out.println(lcsIterative(s1, s2));
		System.out.println("lcsIterative took " + TnSDemos.duration());

		// Part 5
		s1 = "adsgddwdstj";
		s2 = "zxdsvwlsmtup";

		TnSDemos.init();
		System.out.println(editDistance(s1, s2));
		System.out.println("editDistance took " + TnSDemos.duration());

		TnSDemos.init();
		System.out.println(editDistanceBtr(s1, s2, new int[s1.length() + 1][s2.length() + 1]));
		System.out.println("editDistanceBtr took " + TnSDemos.duration());

		TnSDemos.init();
		System.out.println(editDistanceIterative(s1, s2));
		System.out.println("editDistanceIterative took " + TnSDemos.duration());

		int[] arr = new int[20];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 10 + 10 * i;
		}
		TnSDemos.init();
		System.out.println(mcm(arr, 0, arr.length - 1));
		System.out.println("mcm took " + TnSDemos.duration());

		TnSDemos.init();
		System.out.println(mcmBtr(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		System.out.println("mcmBtr took " + TnSDemos.duration());

		N = 28;
		Random rand = new Random();

		int[] vals = new int[N];
		int[] wts = new int[N];
		int wt = 300;

		for (int i = 0; i < vals.length; i++) {
			vals[i] = rand.nextInt(30);
			wts[i] = rand.nextInt(30);
		}

		TnSDemos.init();
		System.out.println(knapSack(vals, wts, wt, 0));
		System.out.println("knapSack took " + TnSDemos.duration());

		TnSDemos.init();
		System.out.println(knapSackBtr(vals, wts, wt, 0, new int[wt + 1][vals.length + 1]));
		System.out.println("knapSackBtr took " + TnSDemos.duration());
	}

	public static int Fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		int fibnm1 = Fib(n - 1);
		int fibnm2 = Fib(n - 2);
		int fibn = fibnm1 + fibnm2;

		return fibn;
	}

	public static int FibBtr(int n, int[] storage) {
		if (n == 0 || n == 1) {
			return n;
		}

		if (storage[n] != 0) {
			return storage[n];
		}

		int fibnm1 = FibBtr(n - 1, storage);
		int fibnm2 = FibBtr(n - 2, storage);
		int fibn = fibnm1 + fibnm2;

		storage[n] = fibn;
		return fibn;
	}

	public static int FibBtr2(int n, int[] storage) {
		if (n == 1) {
			storage[0] = 1;
			storage[1] = 0;

			return n;
		}

		FibBtr2(n - 1, storage);
		int fibnm1 = storage[0];
		int fibnm2 = storage[1];
		int fibn = fibnm1 + fibnm2;

		storage[0] = fibn;
		storage[1] = fibnm1;

		return fibn;
	}

	public static int countBoardPaths(int last, int curr) {
		if (curr == last) {
			return 1;
		}

		if (curr > last) {
			return 0;
		}

		int count = 0;

		for (int i = 1; i <= 6; i++) {
			count += countBoardPaths(last, curr + i);
		}

		return count;
	}

	public static int countBoardPathsBtr(int last, int curr, int[] storage) {
		if (curr == last) {
			return 1;
		}

		if (curr > last) {
			return 0;
		}

		if (storage[curr] != 0) {
			return storage[curr];
		}

		int count = 0;

		for (int i = 1; i <= 6; i++) {
			count += countBoardPathsBtr(last, curr + i, storage);
		}

		storage[curr] = count;
		return count;
	}

	public static int countBoardPathsBtr2(int last, int curr, int[] storage) {
		if (curr == last) {
			storage[0] = 1;
			return 1;
		}

		countBoardPathsBtr2(last, curr + 1, storage);
		int cntCurr = 0;

		for (int dice = 5; dice >= 0; dice--) {
			cntCurr += storage[dice];

			if (dice > 0) {
				storage[dice] = storage[dice - 1];
			} else {
				storage[dice] = cntCurr;
			}
		}

		return cntCurr;
	}

	public static int countMazePaths(int endRow, int endCol, int currentRow, int currentCol) {
		if (currentCol == endCol && currentRow == endRow) {
			return 1;
		}
		if (currentCol > endCol || currentRow > endRow) {
			return 0;
		}

		int count = 0;

		count += countMazePaths(endRow, endCol, currentRow + 1, currentCol);
		count += countMazePaths(endRow, endCol, currentRow, currentCol + 1);

		return count;
	}

	public static int countMazePathsBtr(int endRow, int endCol, int currentRow, int currentCol, int[][] storage) {
		if (currentCol == endCol && currentRow == endRow) {
			return 1;
		}
		if (currentCol > endCol || currentRow > endRow) {
			return 0;
		}

		if (storage[currentRow][currentCol] != 0) {
			return storage[currentRow][currentCol];
		}

		int count = 0;

		count += countMazePathsBtr(endRow, endCol, currentRow + 1, currentCol, storage);
		count += countMazePathsBtr(endRow, endCol, currentRow, currentCol + 1, storage);

		storage[currentRow][currentCol] = count;
		return count;
	}

	public static int countMazePathsIterative(int endRow, int endCol) {
		int[][] storage = new int[endRow + 1][endCol + 1];

		storage[endRow][endCol] = 1;
		for (int row = endRow; row >= 0; row--) {
			for (int col = endCol; col >= 0; col--) {
				int nextRow = row + 1;
				int nextCol = col + 1;

				if (nextRow <= endRow) {
					storage[row][col] += storage[nextRow][col];
				}

				if (nextCol <= endCol) {
					storage[row][col] += storage[row][nextCol];
				}
			}
		}

		return storage[0][0];
	}

	public static int lcs(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		int rv = 0;

		if (s1.charAt(0) == s2.charAt(0)) {
			rv = 1 + lcs(s1.substring(1), s2.substring(1));
		} else {
			int f1 = lcs(s1, s2.substring(1));
			int f2 = lcs(s1.substring(1), s2);

			rv = Math.max(f1, f2);
		}

		return rv;
	}

	public static int lcsBtr(String s1, String s2, int[][] storage) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		if (storage[s1.length()][s2.length()] != 0) {
			return storage[s1.length()][s2.length()];
		}

		int rv = 0;

		if (s1.charAt(0) == s2.charAt(0)) {
			rv = 1 + lcsBtr(s1.substring(1), s2.substring(1), storage);
		} else {
			int f1 = lcsBtr(s1, s2.substring(1), storage);
			int f2 = lcsBtr(s1.substring(1), s2, storage);

			rv = Math.max(f1, f2);
		}

		storage[s1.length()][s2.length()] = rv;
		return rv;
	}

	public static int lcsIterative(String s1, String s2) {
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];

		for (int i = s1.length(); i >= 0; i--) {
			for (int j = s2.length(); j >= 0; j--) {
				if (i == s1.length() || j == s2.length()) {
					arr[i][j] = 0;
					continue;
				}

				if (s1.charAt(i) == s2.charAt(j)) {
					arr[i][j] = arr[i + 1][j + 1] + 1;
				} else {
					arr[i][j] = Math.max(arr[i + 1][j], arr[i][j + 1]);
				}
			}
		}

		return arr[0][0];
	}

	public static int editDistance(String s1, String s2) {
		if (s1.length() == 0) {
			return s2.length();
		}

		if (s2.length() == 0) {
			return s1.length();
		}

		if (s1.charAt(0) == s2.charAt(0)) {
			return editDistance(s1.substring(1), s2.substring(1));
		} else {
			int replaceCost = 1 + editDistance(s1.substring(1), s2.substring(1));
			int additionCost = 1 + editDistance(s1.substring(1), s2);
			int removalCost = 1 + editDistance(s1, s2.substring(1));

			return Math.min(replaceCost, Math.min(additionCost, removalCost));
		}
	}

	public static int editDistanceBtr(String s1, String s2, int[][] storage) {
		if (s1.length() == 0) {
			return s2.length();
		}

		if (s2.length() == 0) {
			return s1.length();
		}

		if (storage[s1.length()][s2.length()] != 0) {
			return storage[s1.length()][s2.length()];
		}

		int retVal = 0;

		if (s1.charAt(0) == s2.charAt(0)) {
			retVal = editDistanceBtr(s1.substring(1), s2.substring(1), storage);
		} else {
			int replaceCost = 1 + editDistanceBtr(s1.substring(1), s2.substring(1), storage);
			int additionCost = 1 + editDistanceBtr(s1.substring(1), s2, storage);
			int removalCost = 1 + editDistanceBtr(s1, s2.substring(1), storage);

			retVal = Math.min(replaceCost, Math.min(additionCost, removalCost));
		}

		storage[s1.length()][s2.length()] = retVal;
		return retVal;
	}

	public static int editDistanceIterative(String s1, String s2) {
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];

		for (int i = s1.length(); i >= 0; i--) {
			for (int j = s2.length(); j >= 0; j--) {
				if (i == s1.length()) {
					arr[i][j] = s2.length() - j;
					continue;
				}

				if (j == s2.length()) {
					arr[i][j] = s1.length() - i;
					continue;
				}

				if (s1.charAt(i) == s2.charAt(j)) {
					arr[i][j] = arr[i + 1][j + 1];
				} else {
					int replaceCost = 1 + arr[i + 1][j + 1];
					int additionCost = 1 + arr[i + 1][j];
					int removalCost = 1 + arr[i][j + 1];

					arr[i][j] = Math.min(replaceCost, Math.min(additionCost, removalCost));
				}
			}
		}

		return arr[0][0];
	}

	public static int mcm(int[] dims, int fm, int lm) {
		if (lm == fm + 1) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int i = fm + 1; i < lm; i++) {
			int cost = mcm(dims, fm, i);
			cost += mcm(dims, i, lm);
			cost += dims[fm] * dims[i] * dims[lm];

			if (cost < min) {
				min = cost;
			}
		}

		return min;
	}

	public static int mcmBtr(int[] dims, int fm, int lm, int[][] storage) {
		if (lm == fm + 1) {
			return 0;
		}

		if (storage[fm][lm] != 0) {
			return storage[fm][lm];
		}

		int min = Integer.MAX_VALUE;

		for (int i = fm + 1; i < lm; i++) {
			int cost = mcmBtr(dims, fm, i, storage);
			cost += mcmBtr(dims, i, lm, storage);
			cost += dims[fm] * dims[i] * dims[lm];

			if (cost < min) {
				min = cost;
			}
		}

		storage[fm][lm] = min;
		return min;
	}

	public static int knapSack(int[] vals, int[] wts, int wt, int si) {
		if (si == vals.length || wt <= 0) {
			return 0;
		}

		int rv = 0;

		if (wts[si] <= wt) {
			int f1 = 0 + knapSack(vals, wts, wt, si + 1);
			int f2 = vals[si] + knapSack(vals, wts, wt - wts[si], si + 1);

			rv = Math.max(f1, f2);
		} else {
			rv = knapSack(vals, wts, wt, si + 1);
		}

		return rv;
	}

	public static int knapSackBtr(int[] vals, int[] wts, int wt, int si, int[][] storage) {
		if (si == vals.length || wt <= 0) {
			return 0;
		}

		if (storage[wt][si] != 0) {
			return storage[wt][si];
		}

		int rv = 0;

		if (wts[si] <= wt) {
			int f1 = 0 + knapSackBtr(vals, wts, wt, si + 1, storage);
			int f2 = vals[si] + knapSackBtr(vals, wts, wt - wts[si], si + 1, storage);

			rv = Math.max(f1, f2);
		} else {
			rv = knapSack(vals, wts, wt, si + 1);
		}

		storage[wt][si] = rv;
		return rv;
	}
}

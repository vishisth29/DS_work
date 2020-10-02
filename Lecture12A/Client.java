package Lecture12A;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		// System.out.println(getBoardPaths(10, 0));
		// printSS("abcd", "");
		// printPermutations("abc", "");
		// printPermutationsWDupli("abab", "");
		// System.out.println(countBoardPaths(10, 0));
		// System.out.println(countMazePaths(2, 2, 0, 0));
//		System.out.println(countMPWDiag(2, 3, 0, 0));
//		System.out.println(countMPWDiagSelect(3, 3, 0, 0));
		
		System.out.println(getMPWDiag(2, 2, 0, 0));
		printMPWDiag(2, 2, 0, 0, "");
	}

	public static ArrayList<String> getBoardPaths(int size, int current) {
		// positive base case
		if (current == size) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("\n");

			return baseResult;
		}

		if (current > size) {
			ArrayList<String> baseResult = new ArrayList<>();
			return baseResult;
		}

		ArrayList<String> recResult = null, myResult = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {
			recResult = getBoardPaths(size, current + dice);
			for (int j = 0; j < recResult.size(); j++) {
				myResult.add(dice + recResult.get(j));
			}
		}

		return myResult;
	}

	public static void printSS(String str, String osf) {
		if (str.length() == 0) {
			System.out.println(osf);
			return;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);

		printSS(ros, osf + ""); // no
		printSS(ros, osf + cc); // yes
	}

	public static void printPermutations(String str, String osf) {
		if (str.length() == 0) {
			System.out.println(osf);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);

			printPermutations(ros, osf + cc);
		}
	}

	public static void printPermutationsWDupli(String str, String osf) {
		if (str.length() == 0) {
			System.out.println(osf);
			return;
		}

		boolean[] used = new boolean[26];

		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);

			if (used[cc - 'a'] == false) {
				printPermutationsWDupli(ros, osf + cc);
				used[cc - 'a'] = true;
			}
		}
	}

	public static int countBoardPaths(int size, int current) {
		if (current == size) {
			return 1;
		}

		if (current > size) {
			return 0;
		}

		int recResult = 0, myResult = 0;
		for (int i = 1; i <= 6; i++) {
			recResult = countBoardPaths(size, current + i);
			myResult = myResult + recResult;
		}

		return myResult;
	}

	public static int countMazePaths(int endRow, int endCol, int currentRow, int currentCol) {
		if (currentRow == endRow && currentCol == endCol) {
			return 1;
		}

		if (currentCol > endCol || currentRow > endRow) {
			return 0;
		}

		int myResult = 0;

		int hResult = countMazePaths(endRow, endCol, currentRow, currentCol + 1);
		int vResult = countMazePaths(endRow, endCol, currentRow + 1, currentCol);
		myResult = hResult + vResult;

		return myResult;
	}

	public static int countMPWDiag(int endRow, int endCol, int currentRow, int currentCol) {
		if (currentRow == endRow && currentCol == endCol) {
			return 1;
		}

		if (currentCol > endCol || currentRow > endRow) {
			return 0;
		}

		int myResult = 0;

		int hResult = countMPWDiag(endRow, endCol, currentRow, currentCol + 1);
		int vResult = countMPWDiag(endRow, endCol, currentRow + 1, currentCol);
		int dResult = countMPWDiag(endRow, endCol, currentRow + 1, currentCol + 1);
		myResult = hResult + vResult + dResult;

		return myResult;
	}

	public static int countMPWDiagSelect(int endRow, int endCol, int currentRow, int currentCol) {
		if (currentRow == endRow && currentCol == endCol) {
			return 1;
		}

		if (currentCol > endCol || currentRow > endRow) {
			return 0;
		}

		int myResult = 0;

		int hResult = countMPWDiagSelect(endRow, endCol, currentRow, currentCol + 1);
		int vResult = countMPWDiagSelect(endRow, endCol, currentRow + 1, currentCol);
		int dResult = 0;

		if (currentCol == currentRow || currentCol + currentRow == endCol) {
			dResult = countMPWDiagSelect(endRow, endCol, currentRow + 1, currentCol + 1);
		}

		myResult = hResult + vResult + dResult;

		return myResult;
	}

	public static ArrayList<String> getMPWDiag(int er, int ec, int cr, int cc){
		if(cc == ec && cr == er){
			ArrayList<String> baseResult = new ArrayList<>();
			
			baseResult.add("");
			
			return baseResult;
		}
		
		
		if (cc > ec || cr > er) {
			ArrayList<String> baseResult = new ArrayList<>();
			return baseResult;
		}
		
		ArrayList<String> myResult = new ArrayList<>();
		
		ArrayList<String> hResult = getMPWDiag(er, ec, cr, cc + 1);
		ArrayList<String> vResult = getMPWDiag(er, ec, cr + 1, cc);
		ArrayList<String> dResult = getMPWDiag(er, ec, cr + 1, cc + 1);
		
		for(int i = 0; i < hResult.size(); i++){
			myResult.add("H" + hResult.get(i));
		}
		
		for(int i = 0; i < vResult.size(); i++){
			myResult.add("V" + vResult.get(i));
		}
		
		for(int i = 0; i < dResult.size(); i++){
			myResult.add("D" + dResult.get(i));
		}
		
		return myResult;
	}
	
	public static void printMPWDiag(int er, int ec, int cr, int cc, String psf){
		if(cc == ec && cr == er){
			System.out.println(psf);
			return;
		}
		
		if (cc > ec || cr > er) {
			return;
		}
		
		printMPWDiag(er, ec, cr, cc + 1, psf + "H");
		printMPWDiag(er, ec, cr + 1, cc, psf + "V");
		printMPWDiag(er, ec, cr + 1, cc + 1, psf + "D");
	}
}

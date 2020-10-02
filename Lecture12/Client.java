package Lecture12;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		// int N = 5;
		// printPattern(N, 1, 1);
		//
		// int[] arr = { 12, 2, 9, -18, 32, 15 };
		// bubbleSort(arr, 0, arr.length - 1);
		//
		// ArrayOps.display(arr);

		// printPattern2(5, 1, 1);

		 System.out.println(getSS("abcd"));
		// System.out.println(getSSWAscii("ab"));
//		System.out.println(getPermutations("abd"));
		//System.out.println(getKC("190"));
	}

	public static void printPattern(int N, int col, int row) {
		if (row > N) {
			return;
		}

		if (col > row) {
			System.out.println();
			printPattern(N, 1, row + 1);
			return;
		}

		System.out.print("*\t");
		printPattern(N, col + 1, row);
	}

	public static void bubbleSort(int[] arr, int si, int li) {
		if (li == 0) {
			return;
		}

		if (si == li) {
			bubbleSort(arr, 0, li - 1);
			return;
		}

		if (arr[si] > arr[si + 1]) {
			int temp = arr[si];
			arr[si] = arr[si + 1];
			arr[si + 1] = temp;
		}
		bubbleSort(arr, si + 1, li);
	}

	public static void printPattern2(int N, int col, int row) {
		if (row > N) {
			return;
		}

		if (col > row) {
			printPattern2(N, 1, row + 1);
			System.out.println();
			return;
		}

		printPattern2(N, col + 1, row);
		System.out.print("*\t");
	}

	public static ArrayList<String> getSS(String str) {
		if (str.equals("")) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("");

			return baseResult;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> recResult = getSS(ros);
		ArrayList<String> myResult = new ArrayList<>();

		for (int i = 0; i < recResult.size(); i++) {
			myResult.add("" + recResult.get(i)); // cc said no
			myResult.add(cc + recResult.get(i)); // cc said yes
		}

		return myResult;
	}

	public static ArrayList<String> getSSWAscii(String str) {
		if (str.equals("")) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("");

			return baseResult;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> recResult = getSSWAscii(ros);
		ArrayList<String> myResult = new ArrayList<>();

		for (int i = 0; i < recResult.size(); i++) {
			myResult.add("" + recResult.get(i)); // cc said no
			myResult.add(cc + recResult.get(i)); // cc said yes
			myResult.add((int) cc + recResult.get(i)); // cc said yes with ascii
		}

		return myResult;
	}

	public static ArrayList<String> getPermutations(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("");

			return baseResult;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> recResult = getPermutations(ros);
		ArrayList<String> myResult = new ArrayList<>();

		for (int i = 0; i < recResult.size(); i++) {
			String recString = recResult.get(i);

			for (int j = 0; j <= recString.length(); j++) {
				String myString = recString.substring(0, j) + cc + recString.substring(j);
				myResult.add(myString);
			}
		}

		return myResult;
	}

	public static ArrayList<String> getKC(String str){
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("");

			return baseResult;
		}
		
		char cc = str.charAt(0);
		String ros = str.substring(1);
		
		ArrayList<String> recResult = getKC(ros);
		ArrayList<String> myResult = new ArrayList<>();
		
		String code = getCode(cc);
		for(int i = 0; i < recResult.size(); i++){
			for(int j = 0; j < code.length(); j++){
				String myString = code.charAt(j) + recResult.get(i);
				myResult.add(myString);
			}
		}
		
		return myResult;
	}
	
	private static String getCode(char cc) {
		String retVal = "";

		switch (cc) {
		case '1':
			retVal = "abc";
			break;
		case '2':
			retVal = "def";
			break;
		case '3':
			retVal = "ghi";
			break;
		case '4':
			retVal = "jkl";
			break;
		case '5':
			retVal = "mno";
			break;
		case '6':
			retVal = "pqr";
			break;
		case '7':
			retVal = "stu";
			break;
		case '8':
			retVal = "vwx";
			break;
		case '9':
			retVal = "yz";
			break;
		case '0':
			retVal = ".;";
			break;
		default:
			retVal = "";
			break;
		}

		return retVal;
	}
}

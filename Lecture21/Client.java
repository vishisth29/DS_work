package Lecture21;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// printLG("bcad", "", false, "bcad");
		// lexico(1000, 0);
		// lexicoR(1000, 0);
		// printTargetSS(new int[] {1, 2, 3, 4, 5, 6, 7}, 0, 7, "");
		// System.out.println(toh("T1", "T2", "T3", 4));
		printBP(15, 0, getLadders(15), "");
	}

	public static void printLG(String str, String osf, boolean flag, String orig) {
		if (str.length() == 0) {
			if (!osf.equals(orig)) {
				System.out.println(osf);
			}
			return;
		}

		if (flag) {
			for (int i = 0; i < str.length(); i++) {
				String ros = str.substring(0, i) + str.substring(i + 1);
				char cc = str.charAt(i);

				printLG(ros, osf + cc, true, orig);
			}
		} else {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) >= str.charAt(0)) {
					String ros = str.substring(0, i) + str.substring(i + 1);
					char cc = str.charAt(i);

					printLG(ros, osf + cc, cc > str.charAt(0), orig);
				} else {
					// no call
				}
			}
		}
	}

	public static void lexico(int end, int curr) {
		if (curr == end) {
			System.out.println(curr);
			return;
		}

		if (curr > end) {
			return;
		}

		System.out.println(curr);
		for (int i = (curr == 0 ? 1 : 0); i <= 9; i++) {
			lexico(end, 10 * curr + i);
		}
	}

	public static void lexicoR(int end, int curr) {
		if (curr == end) {
			System.out.println(curr);
			return;
		}

		if (curr > end) {
			return;
		}

		for (int i = 9; i >= (curr == 0 ? 1 : 0); i--) {
			lexicoR(end, 10 * curr + i);
		}

		System.out.println(curr);
	}

	public static void printTargetSS(int[] arr, int si, int target, String osf) {
		if (si == arr.length) {
			if (target == 0) {
				System.out.println(osf + "END");
			}

			return;
		}

		printTargetSS(arr, si + 1, target, osf);
		printTargetSS(arr, si + 1, target - arr[si], osf + arr[si] + ", ");
	}

	public static int toh(String srcT, String destT, String auxT, int num) {
		if (num == 0) {
			return 0;
		}

		int count = 1;

		count += toh(srcT, auxT, destT, num - 1);

		System.out.println("Move " + num + "th disc from " + srcT + " to " + destT);

		count += toh(auxT, destT, srcT, num - 1);

		return count;
	}

	public static void printBP(int end, int curr, int[] ladders, String osf) {
		if (curr == end) {
			System.out.println(osf + "END");
			return;
		}

		if (curr > end) {
			return;
		}

		if (ladders[curr] != 0) {
			printBP(end, ladders[curr], ladders, osf + "L");
		} else {
			for (int dice = 1; dice <= 6; dice++) {
				printBP(end, curr + dice, ladders, osf + "D" + dice);
			}
		}
	}

	public static int[] getSnL(int N) {
		int[] rv = new int[N + 1];
		boolean[] primes = primeSieve(N);

		int left = 0, right = primes.length - 1, counter = 0;
		while (left <= right) {
			while (!primes[left]) {
				left++;
			}

			while (!primes[right]) {
				right--;
			}

			if (left <= right) {
				counter++;

				if (counter % 2 == 1) {
					rv[left] = right;
				} else {
					rv[right] = left;
				}

				left++;
				right--;
			}
		}

		return rv;
	}

	public static int[] getLadders(int N) {
		int[] rv = new int[N + 1];
		boolean[] primes = primeSieve(N);

		int left = 0, right = primes.length - 1;
		while (left <= right) {
			while (!primes[left]) {
				left++;
			}

			while (!primes[right]) {
				right--;
			}

			if (left <= right) {
				rv[left] = right;
				left++;
				right--;
			}
		}

		return rv;
	}

	public static boolean[] primeSieve(int N) {
		boolean[] rv = new boolean[N + 1];

		for (int i = 2; i < rv.length; i++) {
			rv[i] = true;
		}

		for (int div = 2; div * div < rv.length; div++) {
			if (rv[div]) {
				for (int mult = 2; div * mult < rv.length; mult++) {
					rv[div * mult] = false;
				}
			}
		}

		return rv;
	}

	/* Sample Solutions */
	public static String moveXToEnd(String str, int counter) {
		if (str.length() == 0) {
			String baseResult = "";

			for (int i = 0; i < counter; i++) {
				baseResult += "x";
			}

			return baseResult;
		}

		String ros = str.substring(1);
		char cc = str.charAt(0);

		String recResult = "";
		String myResult = "";

		if (cc == 'x' || cc == 'X') {
			recResult = moveXToEnd(ros, counter + 1);
			myResult = recResult;
		} else {
			recResult = moveXToEnd(ros, counter);
			myResult = cc + recResult;
		}

		return myResult;
	}

	public static int countHi(String str) {
		if (str.length() < 2) {
			return 0;
		}

		String chk = str.substring(0, 2);

		if (chk.equals("hi")) {
			String ros = str.substring(2);
			return 1 + countHi(ros);
		} else {
			String ros = str.substring(1);
			return countHi(ros);
		}
	}

	public static String removeHi(String str) {
		if (str.length() < 2) {
			return str;
		}

		String chk = str.substring(0, 2);

		if (chk.equals("hi")) {
			String ros = str.substring(2);
			return removeHi(ros);
		} else {
			String ros = str.substring(1);
			char cc = str.charAt(0);

			return cc + removeHi(ros);
		}
	}

	public static String replaceHiWBye(String str) {
		if (str.length() < 2) {
			return str;
		}

		String chk = str.substring(0, 2);

		if (chk.equals("hi")) {
			String ros = str.substring(2);
			return "bye" + replaceHiWBye(ros);
		} else {
			String ros = str.substring(1);
			char cc = str.charAt(0);

			return cc + replaceHiWBye(ros);
		}
	}

	public static ArrayList<String> getCodes(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("");

			return baseResult;

		} else if (str.length() == 1) {
			ArrayList<String> baseResult = new ArrayList<>();

			String code = ((char) (str.charAt(0) - '1' + 'a')) + "";
			baseResult.add(code);

			return baseResult;
		} else {
			ArrayList<String> myResult = new ArrayList<>();

			String ros1 = str.substring(1);
			char cc1 = str.charAt(0);
			ArrayList<String> recResult1 = getCodes(ros1);

			for (int i = 0; i < recResult1.size(); i++) {
				String code = ((char) (cc1 - '1' + 'a')) + "";
				myResult.add(code + recResult1.get(i));
			}

			if (cc1 <= '2') {
				String ros2 = str.substring(2);
				char cc2 = str.charAt(1);

				if (cc2 <= '6') {
					ArrayList<String> recResult2 = getCodes(ros2);

					for (int i = 0; i < recResult2.size(); i++) {
						String code = ((char) ((cc1 - '0') * 10 + (cc2 - '0') - 1 + 'a')) + "";
						myResult.add(code + recResult2.get(i));
					}
				}
			}

			return myResult;
		}

	}

	public static String getParenContent(String str, boolean startFound) {
		String ros = str.substring(1);
		char cc = str.charAt(0);

		if (cc == '(') {
			String recResult = getParenContent(ros, true);
			String myResult = recResult;
			return myResult;
		} else if (cc == ')') {
			return "";
		} else {
			String recResult = getParenContent(ros, startFound);
			String myResult = "";

			if (startFound) {
				myResult = cc + recResult;
			} else {
				myResult = recResult;
			}

			return myResult;
		}
	}
}

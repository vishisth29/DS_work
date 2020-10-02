package Lecture11;

import Lecture6.ArrayOps;

public class Client {

	public static void main(String[] args) {
		// Part 1
		// PrintDecreasing(5);
		// System.out.println("*********************");

		// Part 2
		// PrintIncreasing(5);
		// System.out.println("*********************");

		// Part 3
		// PrintDI(5);
		// System.out.println("*********************");

		// Part 4
		// PrintDISkip(5);
		// System.out.println("*********************");

		// Part 5
		// System.out.println(Factorial(5));
		// System.out.println("*********************");

		// Part 6
		// System.out.println(Fibonnaci(10));
		// System.out.println("*********************");

		// Part 7
		// System.out.println(Power(2, 10));
		// System.out.println("*********************");

		// Part 8
		// int[] arr = new int[] { 9, 12, 16, 18, 22 };
		// System.out.println(isSorted(arr));

		// Part 9
		int[] arr = new int[] { 1, 2, 3, 1, 2, 3, 1, 2, 3 };
		System.out.println(firstIndex(arr, 3, 0));

		// Part 10
		System.out.println(lastIndex(arr, 3, 0));
		
		// Part 11
		arr = new int[] {1, 2, 3, 2, 3};
		arr = allIndices(arr, 3, 0, 0);
		ArrayOps.display(arr);
	}

	public static void PrintDecreasing(int num) {
		if (num <= 0) {
			return;
		}

		System.out.println(num);
		PrintDecreasing(num - 1);
	}

	public static void PrintIncreasing(int num) {
		if (num <= 0) {
			return;
		}

		PrintIncreasing(num - 1);
		System.out.println(num);
	}

	public static void PrintDI(int num) {
		if (num <= 0) {
			return;
		}

		System.out.println(num);
		PrintDI(num - 1);
		System.out.println(num);
	}

	// Only odds in decreasing order and evens in increasing order
	public static void PrintDISkip(int num) {
		if (num <= 0) {
			return;
		}

		if (num % 2 == 1) {
			System.out.println(num);
		}

		PrintDISkip(num - 1);

		if (num % 2 == 0) {
			System.out.println(num);
		}
	}

	public static int Factorial(int num) {
		if (num == 0) {
			return 1;
		}

		int fnm1 = Factorial(num - 1);
		int fn = num * fnm1;

		return fn;
	}

	public static int Fibonnaci(int num) {
		if (num == 0 || num == 1) {
			return num;
		}

		int fnm1 = Fibonnaci(num - 1);
		int fnm2 = Fibonnaci(num - 2);
		int fn = fnm1 + fnm2;

		return fn;
	}

	public static int Power(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int xpnm1 = Power(x, n - 1);
		int xpn = x * xpnm1;

		return xpn;
	}

	public static void BubbleSort(int[] arr, int si, int li) {
		if (li == 0) {
			return;
		}

		if (si == li) {
			BubbleSort(arr, 0, li - 1);
			return;
		}

		if (arr[si] > arr[si + 1]) {
			int temp = arr[si];
			arr[si] = arr[si + 1];
			arr[si + 1] = temp;
		}

		BubbleSort(arr, si + 1, li);
	}

	public static boolean isSorted(int[] arr) {
		if (arr.length == 1) {
			return true;
		}

		if (arr[0] > arr[1]) {
			return false;
		} else {
			int[] sa = new int[arr.length - 1];
			for (int i = 1; i < arr.length; i++) {
				sa[i - 1] = arr[i];
			}

			boolean isSASorted = isSorted(sa);
			return isSASorted;
		}
	}

	public static boolean isSortedSmarter(int[] arr, int si) {
		if (si == arr.length - 1) {
			return true;
		}

		if (arr[si] > arr[si + 1]) {
			return false;
		} else {
			boolean isSASorted = isSortedSmarter(arr, si + 1);
			return isSASorted;
		}
	}

	public static boolean contains(int[] arr, int num) {
		if (arr.length == 0) {
			return false;
		}

		if (arr[0] == num) {
			return true;
		} else {
			int[] sa = new int[arr.length - 1];
			for (int i = 1; i < arr.length; i++) {
				sa[i - 1] = arr[i];
			}

			boolean isContainedInSA = contains(sa, num);
			return isContainedInSA;
		}
	}

	public static boolean containsSmarter(int[] arr, int num, int si) {
		if (si == arr.length) {
			return false;
		}

		if (arr[si] == num) {
			return true;
		} else {
			boolean isContainedInSA = containsSmarter(arr, num, si + 1);
			return isContainedInSA;
		}
	}

	public static int firstIndex(int[] arr, int num, int si) {
		if (si == arr.length) {
			return -1;
		}

		if (arr[si] == num) {
			return si;
		} else {
			int siinssa = firstIndex(arr, num, si + 1);
			return siinssa;
		}
	}

	public static int lastIndex(int[] arr, int num, int si) {
		if (si == arr.length) {
			return -1;
		}

		int liinsa = lastIndex(arr, num, si + 1);
		if (liinsa != -1) {
			return liinsa;
		} else {
			if (arr[si] == num) {
				return si;
			} else {
				return -1;
			}
		}
	}

	public static int[] allIndices(int[] arr, int num, int si, int count) {
		if (si == arr.length) {
			return new int[count];
		}

		int[] result = null;
		if (arr[si] == num) {
			result = allIndices(arr, num, si + 1, count + 1);
		} else {
			result = allIndices(arr, num, si + 1, count);
		}

		if (arr[si] == num) {
			result[count] = si;
		}

		return result;
	}

}

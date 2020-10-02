package Lecture16;

import Lecture6.ArrayOps;

public class TnSDemos {
	public static long startTime = 0;
	public static long endTime = 0;

	public static void init() {
		startTime = System.currentTimeMillis();
	}

	public static long duration() {
		endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	public static void main(String[] args) {
//		int N = 1000000;
//
//		int[] arr = new int[N];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = N - i;
//		}
//
//		init();
//		arr = Lecture15.Client.mergeSort(arr, 0, arr.length - 1);
//		System.out.println("Merge Sort for " + N + " items took " + duration() + " ms");
//
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = N - i;
//		}
//
//		init();
//		Lecture8.ArrayOps.bubbleSort(arr);
//		System.out.println("Bubble Sort for " + N + " items took " + duration() + " ms");
	
		int n = 100000, x = 2;
		init();
		System.out.println(power(x, n));
		System.out.println("Power for " + n + " took " + duration() + " ms");
	}

	public static void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		int left = lo, right = hi;

		// real work - partitioning the array (smaller than pivot and larger
		// than pivot)
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left++;
				right--;
			}
		}

		quickSort(arr, lo, right);
		quickSort(arr, left, hi);
	}

	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int xpnm1 = power(x, n - 1);
		int xpn = x * xpnm1;

		return xpn;
	}

	public static int powerBtr(int x, int n) {
		if(n == 0){
			return 1;
		}
		
		int xpnb2 = powerBtr(x, n / 2);
		int xpn = 0;

		if (n % 2 == 0) {
			xpn = xpnb2 * xpnb2;
		}
		else {
			xpn = xpnb2 * xpnb2 * x;
		}
		
		return xpn;
	}
}

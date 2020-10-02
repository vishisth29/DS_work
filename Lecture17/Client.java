package Lecture17;

import java.util.Arrays;

public class Client {

	public static void main(String[] args) {
//		System.out.println(getPV(3, 4));
//		System.out.println(countPalindromicSS("abbcbabc"));
		int N = 10;
		Lecture16.TnSDemos.init();
//		printPrimes(N);
//		System.out.println(Fib(N));
//		System.out.println(FibBtr(N, new int[N + 1]));
//		System.out.println(countBoardPaths(N , 0));
		System.out.println(countBoardPathsBtr(N, 0, new int[N + 1]));
		System.out.println("Duration = " + Lecture16.TnSDemos.duration());
	}

	public static int getPV(int x, int n) {
		int rv = 0;

		int powX = x;
		while (n > 0) {
			rv += powX * n;

			powX = powX * x;
			n--;
		}

		return rv;
	}

	public static int countPalindromicSS(String str) {
		int rv = 0;

		// odd length palindromes
		for (int axis = 0; axis < str.length(); axis++) {
			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt(axis + orbit) == str.charAt(axis - orbit)) {
					rv++;
				} else {
					break;
				}
			}
		}

		// even length palindrome
		for (int axis = 1; axis < str.length(); axis++) {
			for (int orbit = 1; axis - orbit >= 0 && axis + orbit - 1 < str.length(); orbit++) {
				if (str.charAt(axis - orbit) == str.charAt(axis + orbit - 1)) {
					rv++;
				} else {
					break;
				}
			}
		}

		return rv;
	}

	public static void printPrimes(int N) {
		for (int i = 2; i <= N; i++) {
			if (isPrime(i)) {
//				System.out.println(i);
			}
		}
	}

	public static boolean isPrime(int N) {
		for (int div = 2; div * div <= N; div++) {
			if (N % div == 0) {
				return false;
			}
		}

		return true;
	}

	public static void printPrimesSOE(int N) {
		boolean[] primes = new boolean[N + 1];

		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}

		for (int div = 2; div * div <= N; div++) {
			if (primes[div]) {
				for (int multiple = 2; div * multiple <= N; multiple++) {
					primes[div * multiple] = false;
				}
			}
		}

		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
//				System.out.println(i);
			}
		}
	}

	public static int Fib(int n){
		if(n == 0 || n == 1){
			return n;
		}
		
		int fibnm1 = Fib(n - 1);
		int fibnm2 = Fib(n - 2);
		int fibn = fibnm1 + fibnm2;
		
		return fibn;
	}

	public static int FibBtr(int n, int[] storage){
		if(n == 0 || n == 1){
			return n;
		}
		
		if(storage[n] != 0){
			return storage[n];
		}
		
		int fibnm1 = FibBtr(n - 1, storage);
		int fibnm2 = FibBtr(n - 2, storage);
		int fibn = fibnm1 + fibnm2;
		storage[n] = fibn;
		
		return fibn;
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
	
	public static int countBoardPathsBtr(int size, int current, int[] storage) {
		if (current == size) {
			return 1;
		}

		if (current > size) {
			return 0;
		}
		
		if(storage[current] != 0){
			return storage[current];
		}

		int recResult = 0, myResult = 0;
		for (int i = 1; i <= 6; i++) {
			recResult = countBoardPathsBtr(size, current + i, storage);
			myResult = myResult + recResult;
		}
		storage[current] = myResult;

		return myResult;
	}

}

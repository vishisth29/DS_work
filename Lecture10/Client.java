package Lecture10;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// double d = 1;
		// d = d * 0.1;
		// System.out.println(d);
		// d = d * 0.1;
		// System.out.println(d);
		// System.out.println(Math.round(d * 100)/ 100.0);
		// squareRoot(28, 3);
		// System.out.println(getSubsets(new int[] {1, 2, 3}));
		System.out.println(getPermutations(new int[] { 1, 2, 3 }));
	}

	public static void squareRoot(int N, int P) {
		int iPower = 1;
		double dPower = 1.0;

		double sqrt = 0;
		double increment = 1;

		int counter = 0;
		while (counter <= P) {

			while (sqrt * sqrt <= N) {
				sqrt += increment;
				System.out.println(sqrt + ", " + (Math.round(sqrt * iPower) / dPower));
			}

			sqrt = sqrt - increment;

			increment = increment * 0.1;
			iPower = iPower * 10;
			dPower = dPower * 10.0;
			counter++;
		}

		System.out.println(sqrt);
	}

	public static ArrayList<ArrayList<Integer>> getSubsets(int[] arr) {
		ArrayList<ArrayList<Integer>> retVal = new ArrayList<>();

		int range = (int) Math.pow(2, arr.length) - 1;
		int counter = 0;

		while (counter <= range) {
			ArrayList<Integer> inner = new ArrayList<>();
			int dec = counter;

			int ic = 0;
			while (ic < arr.length) {
				int rem = dec % 2;

				if (rem == 1) {
					inner.add(arr[ic]);
				}

				dec = dec / 2;
				ic++;
			}

			retVal.add(inner);
			counter++;
		}

		return retVal;
	}

	public static ArrayList<ArrayList<Integer>> getPermutations(int[] arr) {
		ArrayList<ArrayList<Integer>> retVal = new ArrayList<>();

		ArrayList<ArrayList<Integer>[]> solver = new ArrayList<>();

		ArrayList<Integer>[] seed = new ArrayList[2];
		seed[0] = new ArrayList<>();
		seed[1] = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			seed[0].add(arr[i]);
		}

		solver.add(seed);
		while (!solver.isEmpty()) {
			ArrayList[] step = solver.remove(solver.size() - 1);

			for (int i = 0; i < step[0].size(); i++) {
				ArrayList[] nextStep = new ArrayList[2];

				nextStep[0] = new ArrayList<>();
				nextStep[1] = new ArrayList<>();

				for (int j = 0; j < step[0].size(); j++) {
					if (i != j) {
						nextStep[0].add(step[0].get(j));
					}
				}

				nextStep[1].addAll(step[1]);
				nextStep[1].add(step[0].get(i));

				if (nextStep[0].size() == 0) {
					retVal.add(nextStep[1]);
				} else {
					solver.add(nextStep);
				}
			}
		}

		return retVal;
	}
}

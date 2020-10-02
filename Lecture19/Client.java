package Lecture19;

import java.util.Random;

import Lecture16.TnSDemos;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "adsgzsssdhftgddadsj";
		String s2 = "ashjdsdzfdsdhfzt";

		TnSDemos.init();
		System.out.println(lcs(s1, s2));
		System.out.println("lcs took " + TnSDemos.duration());

		TnSDemos.init();
		System.out.println(lcsBtr(s1, s2, new int[s1.length() + 1][s2.length() + 1]));
		System.out.println("lcsBtr took " + TnSDemos.duration());

		s1 = "dsgtgdayadsj";
		s2 = "shjddszhfnzt";
		TnSDemos.init();
		System.out.println(editDistance(s1, s2));
		System.out.println("editDistance took " + TnSDemos.duration());

		TnSDemos.init();
		System.out.println(editDistanceBtr(s1, s2, new int[s1.length() + 1][s2.length() + 1]));
		System.out.println("editDistanceBtr took " + TnSDemos.duration());
		
		int N = 28;
		
		int[] vals = new int[N];
		int[] wts = new int[N];
		int tw = 300;
		
		Random random = new Random();
		for(int i = 0; i < vals.length; i++){
			vals[i] = random.nextInt(100);
			wts[i] = random.nextInt(N);
		}
		
		TnSDemos.init();
		System.out.println(knapSack(vals, wts, tw, 0));
		System.out.println("knapSack took " + TnSDemos.duration());
		
		TnSDemos.init();
		System.out.println(knapSackBtr(vals, wts, tw, 0, new int[tw + 1][vals.length + 1]));
		System.out.println("knapSackBtr took " + TnSDemos.duration());
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

	public static int editDistance(String s1, String s2) {
		if (s1.length() == 0) {
			return s2.length();
		}

		if (s2.length() == 0) {
			return s1.length();
		}

		int rv = 0;

		if (s1.charAt(0) == s2.charAt(0)) {
			rv = editDistance(s1.substring(1), s2.substring(1));
		} else {
			int f1 = 1 + editDistance(s1.substring(1), s2.substring(1));
			int f2 = 1 + editDistance(s1.substring(1), s2);
			int f3 = 1 + editDistance(s1, s2.substring(1));

			rv = Math.min(f1, Math.min(f2, f3));
		}

		return rv;
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

		int rv = 0;

		if (s1.charAt(0) == s2.charAt(0)) {
			rv = editDistanceBtr(s1.substring(1), s2.substring(1), storage);
		} else {
			int f1 = 1 + editDistanceBtr(s1.substring(1), s2.substring(1), storage);
			int f2 = 1 + editDistanceBtr(s1.substring(1), s2, storage);
			int f3 = 1 + editDistanceBtr(s1, s2.substring(1), storage);

			rv = Math.min(f1, Math.min(f2, f3));
		}

		storage[s1.length()][s2.length()] = rv;
		return rv;
	}

	public static int knapSack(int[] vals, int[] wts, int tw, int si){
		if(si == vals.length){
			return 0;
		}
		
		int rv = 0;
		
		if(tw >= wts[si]){
			// leave or use
			int f1 = knapSack(vals, wts, tw, si + 1);
			int f2 = vals[si] + knapSack(vals, wts, tw - wts[si], si + 1);
			
			rv = Math.max(f1, f2);
		}
		else {
			// leave
			rv = knapSack(vals, wts, tw, si + 1);
		}
		
		return rv;
	}

	public static int knapSackBtr(int[] vals, int[] wts, int tw, int si, int[][] storage){
		if(si == vals.length){
			return 0;
		}
		
		if(storage[tw][si] != 0){
			return storage[tw][si];
		}
		
		int rv = 0;
		
		if(tw >= wts[si]){
			// leave or use
			int f1 = knapSackBtr(vals, wts, tw, si + 1, storage);
			int f2 = vals[si] + knapSackBtr(vals, wts, tw - wts[si], si + 1, storage);
			
			rv = Math.max(f1, f2);
		}
		else {
			// leave
			rv = knapSackBtr(vals, wts, tw, si + 1, storage);
		}
		
		storage[tw][si] = rv;
		return rv;
	}

}

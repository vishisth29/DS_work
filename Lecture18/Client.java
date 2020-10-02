package Lecture18;

import Lecture16.TnSDemos;

public class Client {
	public static void main(String[] args){
		int N = 44;
		
//		TnSDemos.init();
//		getConcatenatedVals(N);
//		System.out.println(TnSDemos.duration());
//		
//		TnSDemos.init();
//		getConcatenatedValsBtr(N);
//		System.out.println(TnSDemos.duration());
//		
		TnSDemos.init();
		System.out.println(FibFarBtr(N)[0]);
		System.out.println(TnSDemos.duration());
		
		TnSDemos.init();
		System.out.println(FibBtr(N, new int[N + 1]));
		System.out.println(TnSDemos.duration());
//		
		TnSDemos.init();
		System.out.println(Fib(N));
		System.out.println(TnSDemos.duration());
		
//		TnSDemos.init();
//		System.out.println(countBoardPathsBtr(N, 0, new int[N + 1]));
//		System.out.println(TnSDemos.duration());
//		
//		TnSDemos.init();
//		System.out.println(countBoardPaths(N, 0));
//		System.out.println(TnSDemos.duration());
		
//		TnSDemos.init();
//		System.out.println(countMazePathBtr(N, N, 0, 0, new int[N + 1][N + 1]));
//		System.out.println(TnSDemos.duration());
//		
//		TnSDemos.init();
//		System.out.println(countMazePath(N, N, 0, 0));
//		System.out.println(TnSDemos.duration());
	}
	
	public static String getConcatenatedVals(int N){
		String rv = "";
		
		for(int i = 0; i <= N; i++){
			rv = rv + i + "\n";
		}
		
		return rv;
	}
	
	public static String getConcatenatedValsBtr(int N){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i <= N; i++){
			sb.append(i);
			sb.append('\n');
		}
		
		return sb.toString();
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

	public static int[] FibFarBtr(int n){
		if(n == 1){
			int[] baseResult = new int[2];
			
			baseResult[0] = 1; // 1 ka fib
			baseResult[1] = 0; // 0 ka fib
			
			return baseResult;
		}
		
		int[] recResult = FibFarBtr(n - 1); // 0 pe n - 1 ka fib, 1 pe n - 2 ka fib
		// I've to return 0 pe n ka fib, 1 pe n - 1 ka fib
		int[] myResult = new int[2];
		myResult[0] = recResult[0] + recResult[1];
		myResult[1] = recResult[0];
		
		return myResult;
	}
	
	public static int countBoardPaths(int end, int current){
		if(current == end){
			return 1;
		}
		
		if(current > end){
			return 0;
		}
		
		int myResult = 0;
		
		for(int dice = 1; dice <= 6; dice++){
			int recResult = countBoardPaths(end, current + dice);
			myResult += recResult;
		}
		
		return myResult;
	}
	
	public static int countBoardPathsBtr(int end, int current, int[] storage){
		if(current == end){
			return 1;
		}
		
		if(current > end){
			return 0;
		}
		
		if(storage[current] != 0){
			return storage[current];
		}
		
		
		int myResult = 0;
		
		for(int dice = 1; dice <= 6; dice++){
			int recResult = countBoardPathsBtr(end, current + dice, storage);
			myResult += recResult;
		}
		
		storage[current] = myResult;
		return myResult;
	}

	public static int countMazePath(int er, int ec, int cr, int cc){
		if(cr == er && cc == ec){
			return 1;
		}
		
		if(cr > er || cc > ec){
			return 0;
		}
		
		int count = 0;
		
		count += countMazePath(er, ec, cr + 1, cc);
		count += countMazePath(er, ec, cr, cc + 1);
		
		return count;
	}
	
	public static int countMazePathBtr(int er, int ec, int cr, int cc, int[][] storage){
		if(cr == er && cc == ec){
			return 1;
		}
		
		if(cr > er || cc > ec){
			return 0;
		}
		
		if(storage[cr][cc] != 0){
			return storage[cr][cc];
		}
		
		int count = 0;
		
		count += countMazePathBtr(er, ec, cr + 1, cc, storage);
		count += countMazePathBtr(er, ec, cr, cc + 1, storage);
		
		storage[cr][cc] = count;
		return count;
	}
}

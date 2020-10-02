package Lecture20;

public class Client {

	public static void main(String[] args) {
//		int[] arr = new int[800000000];
//		
//		System.out.println("Fine");
		
		System.out.println(FibBtr2(10000, new int[2]));
		
		int[] result = countBoardPathsBtr2(10, 0);
		System.out.println(result[0]);
		
		System.out.println(countBoardPathsIterative(10, 0));
		
		System.out.println(countMazePathsIterative(3, 3));
	}
	
	public static int FibBtr2(int n, int[] storage){
		if(n == 1){
			storage[0] = 1; // 1 fib is 1
			storage[1] = 0; // 0 fib is 0
			
			return 1;
		}
		
		int fibnm1 = FibBtr2(n - 1, storage);
		int fibnm2 = storage[1];
		int fibn = fibnm1 + fibnm2;
		
		storage[0] = fibn;
		storage[1] = fibnm1;
		
		return fibn;
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

	public static int[] countBoardPathsBtr2(int end, int current){
		if(current == end){
			int[] baseResult = new int[6];
			
			baseResult[0] = 1;
			
			return baseResult;
		}
		
		int[] recResult = countBoardPathsBtr2(end, current + 1);
		int[] myResult = new int[6];
		
		for(int i = 0; i <= 4; i++){
			myResult[i + 1] = recResult[i];
		}
		
		myResult[0] = recResult[0] + recResult[1] + recResult[2] + recResult[3] + recResult[4] + recResult[5];
		
		return myResult;
	}

	public static int countBoardPathsIterative(int end, int current){
		int[] result = new int[6];
		result[0] = 1;
		
		for(int sws = end; sws > current; sws--){
			int[] nextResult = new int[6];
			
			for(int i = 0; i <= 4; i++){
				nextResult[i + 1] = result[i];
			}
			nextResult[0] = result[0] + result[1] + result[2] + result[3] + result[4] + result[5]; 
			
			result = nextResult;
		}
		
		return result[0];
	}

	public static int countMazePathsIterative(int er, int ec){
		int[][] arr = new int[er + 1][ec + 1];
		arr[er][ec] = 1;
		
		for(int row = er; row >= 0; row--){
			for(int col = ec; col >= 0; col--){
				int nr = row + 1;
				int nc = col + 1;
				
				if(nr < arr.length){
					arr[row][col] += arr[nr][col];
				}
				
				if(nc < arr[0].length){
					arr[row][col] += arr[row][nc];
				}
			}
		}
		
		return arr[0][0];
	}
}

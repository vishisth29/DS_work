package Lecture7;

public class FunWith2dArrays {

	public static void main(String[] args) {
		int[][] arr = null;
		display(arr);
		
		// one dimension initialized
		System.out.println("***************************");
		arr = new int[4][];
//		arr = new int[][4];
		display(arr);
		
		// both dimensions provided
		System.out.println("***************************");
		arr = new int[4][3];
		display(arr);
		
		// jagged array
		System.out.println("***************************");
		arr = new int[4][];
		
		arr[0] = new int[2];
		arr[1] = new int[3];
		arr[2] = new int[1];
		arr[3] = new int[5];
		
		arr[3][4] = 100;
		
		display(arr);
		
		System.out.println(arr.length);
		System.out.println(arr[2].length);
	}

	public static void display(int[][] arr) {
		if (arr == null) {
			return;
		}

		for (int row = 0; row < arr.length; row++) {
			if (arr[row] != null) {
				for (int col = 0; col < arr[row].length; col++) {
					System.out.print(arr[row][col] + "\t");
				}
				System.out.println();
			}
		}
	}

}

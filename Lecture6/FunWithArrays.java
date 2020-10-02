package Lecture6;

public class FunWithArrays {

	public static void main(String[] args) {
		// Part1
		int[] arr;
		
		arr = new int[3];
		
		// Part2
		arr[0] = 100;
//		arr[1] = 12;
		arr[2] = 200;
//		arr[3] = 400; index out of bound (0 to n - 1)
		
		
		// Part3
		int j = arr[1];
		
		// Part4
		System.out.println(arr);
		
		// Part5
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
		
		// Part6
		System.out.println("**************************");
		for(int val: arr){
			val = val + 1; // readonly, forward only
			System.out.println(val);
		}
		
		// Part 7
		System.out.println("**************************");
		for(int val: arr){
			System.out.println(val);
		}
		
		// Part 8
		System.out.println("**************************");
		System.out.println(arr[0] + ", " + arr[2]);
		Swap(arr, 0, 2);
		System.out.println(arr[0] + ", " + arr[2]);
		
		// Part 9
		System.out.println("**************************");
		System.out.println(arr[0] + ", " + arr[2]);
		SwapAnother(arr[0], arr[2]);
		System.out.println(arr[0] + ", " + arr[2]);
	}
	
	public static void Swap(int[] arr, int i, int j){
//		System.out.println(arr[i] + ", " + arr[j]);
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
//		System.out.println(arr[i] + ", " + arr[j]);
	}

	public static void SwapAnother(int one, int two){
		System.out.println(one + ", " + two);
		
		int temp = one;
		one = two;
		two = temp;
		
		System.out.println(one + ", " + two);
	}
}

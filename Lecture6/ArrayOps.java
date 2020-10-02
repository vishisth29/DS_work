package Lecture6;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayOps {

	public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
//		int[] arr = takeInput();
//		int[] arr = {11, 15, 18, 99, 22};
//		display(arr);
//		int mv = max(arr);
//		System.out.println("Maximum value is " + mv);
//		
//		System.out.println("Enter the element to find: ");
//		int data = scn.nextInt();
//		
//		System.out.println(data + " found at " + linearSearch(arr, data));
//		
//		display(arr);
//		reverse(arr);
//		display(arr);
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(10);
		list.add(20);
		
		System.out.println(list.size());
		
		int zv = list.get(0); // list[0]
		list.set(0, 100); // list[0] = 100;
		
		System.out.println(list);
		
		list.add(1, 50);
		System.out.println(list);
	}
	
	public static int[] takeInput(){
		int[] retVal = null;
		
		System.out.println("Enter the size: ");
		int N = scn.nextInt();
		
		retVal = new int[N];
		
		for(int i = 0; i < retVal.length; i++){
			System.out.println("Enter " + i + "th element: ");
			int data = scn.nextInt();
			
			retVal[i] = data;
		}
		
		return retVal;
	}

	public static void display(int[] arr){
		for(int val: arr){
			System.out.print(val + ", ");
		}
		System.out.println("END");
	}

	public static int max(int[] arr){
		int retVal = arr[0];
		
		for(int i = 1; i < arr.length; i++){
			if(arr[i] > retVal){
				retVal = arr[i];
			}
		}
		
		return retVal;
	}

	public static int linearSearch(int[] arr, int data){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == data){
				return i;
			}
		}
		
		return -1;
	}

	public static void reverse(int[] arr){
		int left = 0, right = arr.length - 1;
		
		while(left <= right){
			FunWithArrays.Swap(arr, left, right);
			left++;
			right--;
		}
	}
}

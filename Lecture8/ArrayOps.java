package Lecture8;

import java.util.ArrayList;

import Lecture6.FunWithArrays;

public class ArrayOps {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50 };
		insertionSort(arr);
		Lecture6.ArrayOps.display(arr);
		
		System.out.println(binarySearch(arr, 10));
		System.out.println(binarySearch(arr, 100));
		System.out.println(binarySearch(arr, 0));
		System.out.println(binarySearch(arr, 27));
		
	}

	public static void bubbleSort(int[] arr) {
		int counter = 1;

		while (counter <= arr.length - 1) {
			for (int i = 0; i < arr.length - counter; i++) {
				if (arr[i + 1] < arr[i]) {
					FunWithArrays.Swap(arr, i + 1, i);
				}
			}

			counter++;
		}
	}

	public static void selectionSort(int[] arr) {
		int counter = 1;

		while (counter <= arr.length - 1) {
			for (int i = counter; i < arr.length; i++) {
				if (arr[i] < arr[counter - 1]) {
					FunWithArrays.Swap(arr, i, counter - 1);
				}
			}

			counter++;
		}
	}

	public static void insertionSort(int[] arr) {
		int counter = 1;

		while (counter <= arr.length - 1) {
			for(int i = counter; i > 0; i--){
				if(arr[i] < arr[i - 1]){
					FunWithArrays.Swap(arr, i, i - 1);
				}
				else {
					break;
				}
			}

			counter++;
		}
	}

	public static int binarySearch(int[] arr, int data){
		int left = 0, right = arr.length - 1;
		
		while(left <= right){
			int mid = (left + right) / 2;
			if(data > arr[mid]){
				left = mid + 1;
			}
			else if(data < arr[mid]){
				right = mid - 1;
			}
			else {
				return mid;
			}
		}
		
		return -1;
	}

	public static int[] intersection(int[] one, int[] two){
		return null;
	}

}

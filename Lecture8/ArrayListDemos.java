package Lecture8;

import java.util.ArrayList;

public class ArrayListDemos {

	public static void main(String[] args) {
		// declaration
		int[] arr;
		ArrayList<Integer> list;
		
		// init
		arr = new int[3];
		list = new ArrayList<>();
		displayStats(arr);
		displayStats(list);
		
		// add
		// not valid for arr
		list.add(10);
		displayStats(list);
		list.add(20);
		displayStats(list);
		list.add(30);
		displayStats(list);
		list.add(1, 40);
		displayStats(list);
		
		// get
		int i = arr[0];
		System.out.println(i);
		int j = list.get(0);
		
		// set
		arr[0] = 100;
		list.set(0, 40);
		displayStats(arr);
		displayStats(list);
		
		// remove
		// not relevant for arr
		list.remove(((Object)40)); // remove value
		displayStats(list);
		
		list.remove(2);
		displayStats(list);
		
		// Limits
		// Get, Set, Remove => 0 to size() - 1
		// Add => 0 to size();
	}
	
	public static void displayStats(int[] arr){
		System.out.println("*******************Array********************");
		System.out.println(arr.length);
		
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + ", ");
		}
		
		System.out.println("END");
		System.out.println("*******************Array********************");
	}

	public static void displayStats(ArrayList<Integer> list){
		System.out.println("*******************List********************");
		System.out.println(list.size());
		
		System.out.println(list);
		
		System.out.println("*******************List********************");
	}
}

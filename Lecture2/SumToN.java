package Lecture2;

public class SumToN {

	public static void main(String[] args) {
		int N = 10;
		
		int sum = 0, counter = 1;
		while(counter <= N){
			sum = sum + counter;
			counter = counter + 1;
		}
		
		System.out.println("Sum upto " + N + " is " + sum);
	}

}

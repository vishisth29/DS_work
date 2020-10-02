package Lecture4;

public class F2C {

	public static void main(String[] args) {
//		System.out.println(5/9);
//		System.out.println(5.0/9);
		int minF = 0, maxF = 300, step = 20;
		
		int currF = minF;
		while(currF <= maxF){
//			int celsius = (5 / 9) * (currF - 32);
//			int celsius = (5.0 / 9) * (currF - 32);
//			int celsius = (int)(5.0 / 9) * (currF - 32);
			int celsius = (int)((5.0 / 9) * (currF - 32));
			
//			System.out.println(currF + ' ' + celsius);
			System.out.println(currF + "\t" + celsius);
			
			currF = currF + step;
		}
	}
	public int kConcatenationMaxSum(int[] arr, int k) {
		int ans=0;
		int l=arr.length;
		int[] arr1=new int[l*k];
		int l1=arr1.length;
		for (int i=0;i<arr1.length;i++){
			arr1[i]=arr[i%l];
		}
		Arraylist<Integer> w=Arrays.asList(maxSubArraySum(arr1,l1));
		for(int b=0;b<w.length;b++){
			ans=ans+w[b];
		}
		return ans;
	}

	static int maxSubArraySum(int a[], int size)
	{
		int max_so_far = a[0];
		int curr_max = a[0];

		for (int i = 1; i < size; i++)
		{
			curr_max = Math.max(a[i], curr_max+a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}

}

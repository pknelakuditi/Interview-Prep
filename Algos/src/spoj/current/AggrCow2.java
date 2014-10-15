package spoj.current;
/*
 * Binarysearch for the max difference of stall btw cows
*/
import java.util.Arrays;
import java.util.Scanner;

public class AggrCow2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int c = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			sb.append(aggrCow(arr, c)+"\n");

			t--;
		}
       System.out.println(sb);
		sc.close();
	}

	private static int aggrCow(int[] arr, int c) {
		if(c==2){
			return arr[arr.length-1]-arr[0];
		}else{
			int low = 1;
			int high = arr[arr.length - 1] - arr[0] / (c - 1);
		
			int mid = 0;
			while (low < high) {
				
				mid = (high + low) / 2;
				
				if (works(arr, mid,c)) {		
					if(low == mid){				
						if(works(arr,mid+1,c)){					
							return mid+1;
						}
						high=mid;
					}
					low=mid;
				
				} else {
					high = mid;
				
				}
			}

			return mid;
		}
	}

	private static boolean works(int[] arr, int d,int c) {
		int flag = 1;
		int temp=arr[0];
		
		for (int i = 1; i < arr.length; i++) {
            if(arr[i]>=temp+d){
            	temp=arr[i];
            	flag++;
          
            	if(flag==c){
            		return true;
            	}
            }
		}
		return false;
	}

}

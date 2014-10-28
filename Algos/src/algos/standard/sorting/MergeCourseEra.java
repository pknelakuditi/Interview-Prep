package algos.standard.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergeCourseEra {
   static long count;
	public static void main(String[] args) {
		count=0;
		Scanner sc =new Scanner(System.in);
		ArrayList<Integer> ar =new ArrayList<Integer>();
		while(sc.hasNextInt()){
			ar.add(sc.nextInt());
		}
		int[] arr=new int[ar.size()];
		for(int i=0;i<ar.size();i++){
			arr[i]=ar.get(i);
		}
	//	System.out.println(Arrays.toString(arr));
		
		System.out.println(mergesort(arr, 0, ar.size()-1));
	}
	
	public static long  mergesort(int[] arr, int start, int end) {
//System.out.println(start+" "+end);
		long c=0;
		int mid = start + (end - start) / 2;
		if (start < end) {
			c+=mergesort(arr, mid + 1, end);
			c+=mergesort(arr, start, mid);
			c+=merge(arr, start, mid, end);
		}
		return c;
	}

	static int merge(int arr[], int l, int m, int r) {
		int ci=0;
		int i, j, k;
		int n1 = m - l + 1;
		int n2 = r - m;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for (i = 0; i < n1; i++)
			L[i] = arr[l + i];
		for (j = 0; j < n2; j++)
			R[j] = arr[m + 1 + j];

		i = 0;
		j = 0;
		k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
			//	System.out.println("m-1-j="+(m-1-j));
				ci+=m-1-j;
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			ci+=m-1-i;		
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			
			arr[k] = R[j];
			j++;
			k++;
		}
		return ci;
	}
	

}


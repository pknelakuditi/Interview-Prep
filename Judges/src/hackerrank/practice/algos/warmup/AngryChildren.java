package hackerrank.practice.algos.warmup;
import java.util.Arrays;
import java.util.Scanner;


public class AngryChildren {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		Arrays.sort(a);
		for(int i=0;i<n;i++){
			System.out.println(a[i]);
		}
		//System.out.println(a.toString());
		int min=Integer.MAX_VALUE;
	
		for(int i=0;i<n-k;i++){
			int temp=a[k-1+i]-a[i];
		//	System.out.println("temp"+temp);
			if(temp<min){
				min =temp;
			}
		}System.out.println(min);
		sc.close();
	}

}

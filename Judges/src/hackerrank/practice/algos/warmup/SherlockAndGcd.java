package hackerrank.practice.algos.warmup;
import java.util.Scanner;

public class SherlockAndGcd {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while (testCases > 0) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			subsetGcd(a);
			testCases--;
		}
		sc.close();
	}

	private static void subsetGcd(int[] a) {
		int n = a.length;
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
                 if(!gcd(a[i],a[j])){
                	 System.out.println("NO");
                	 return;
                 }
			}
			
		}
		System.out.println("YES");
	}

	private static boolean gcd(int a, int b) {
		//System.out.print(a+"gcd"+b+" ");
		//System.out.println(GCD(a,b));
		if(GCD(a,b)==1 || a==b){
			//System.err.println("false");
			return true;
		}else{
		return false;}
	}
	
	public static int GCD(int a, int b) {
		   if (b==0) return a;
		   return GCD(b,a%b);
		}
}

package algos.warmup;
import java.math.BigInteger;
import java.util.Scanner;

public class ACM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		BigInteger a;
		int[][] ar = new int[n][m];
		for (int j = 0; j < n; j++) {
			{
				a = sc.nextBigInteger();
				for (int i = 0; i < m; i++) {
					ar[j][m - 1 - i] = (a.mod(BigInteger.TEN).intValue());
					a=a.divide(BigInteger.TEN);
				}
			}
		}
		int max = 0;
		int flag = 0;
		for (int j = 0; j < n - 1; j++) {

			for (int i = j + 1; i < n; i++) {
				int temp = and(ar[j], ar[i], m);
			//	System.out.println("temp "+temp);
				if (temp > max) {
					max = temp;
					flag = 1;
				} else if (temp == max) {
					flag++;
				}
			}
		}
		System.out.println(max);
		System.out.println(flag);
/*int[] a={1,0,1,0,1};
int[] b={0,1,0};
		System.out.println(and(a,b,3));*/
		sc.close();
	}

	public static int and(int[] a, int[] b, int m) {
		int flag = 0;
		//int temp = 0;
		for (int i = 0; i < m; i++) {
		//	System.out.println(comparing );
			if ((a[i] | b[i]) == 1) {
				flag++;
			}
		}
		return flag;
	}

}

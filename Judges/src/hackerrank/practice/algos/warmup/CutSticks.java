package hackerrank.practice.algos.warmup;
import java.util.Arrays;
import java.util.Scanner;

public class CutSticks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		sol(a);
		sc.close();
	}

	private static void sol(int[] a) {
		int n = a.length;
		for (int i = 0; i < n;) {
			if (a[i] == 0) {
				i++;
			} else {

				int temp = a[i];
				for (int j = i; j < n; j++) {
					a[j] = a[j] - temp;

				}
				System.out.println(n - i);

			}
		}

	}

}

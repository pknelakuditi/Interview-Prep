package hackerrank.contest.week.eleven;

import java.util.Scanner;

public class SherlockAndSquare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Long[] time = new Long[n];
		for (int i1 = 0; i1 < n; i1++) {
			time[i1] = sc.nextLong();
		}
		sherlock(time);
		sc.close();
		// System.out.println(pow(1000));

	}

	private static void sherlock(Long[] a) {
		long m = 1000000007;
		for (int i1 = 0; i1 < a.length; i1++) {
			// temp = BigInteger.ZERO;
			if (a[i1] == 0) {
				System.out.println(4);
			} else {
				System.out.println((2 + pow(a[i1] + 1)) % m);
			}
		}
	}

	private static long pow(long l) {
		long m = 1000000007;
		long temp = 1;
		long a = 2;
		while (l > 0) {
			if (l % 2 == 1) {
				temp = temp * a % m;
			}
			a = a * a % m;
			l = l / 2;

		}
		return temp;
	}
}

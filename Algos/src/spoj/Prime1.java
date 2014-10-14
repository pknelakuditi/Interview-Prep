package spoj;

import java.util.Scanner;

public class Prime1 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		for (int i = 1; i <= T; i++) {
			int begin = in.nextInt();
			int end = in.nextInt();
			generateprimes(begin, end);
			System.out.println();
		}
	}

	private static void generateprimes(int begin, int end) {
		int k = begin;
		while (k <= end) {
			checkprime(k);
			k++;
		}
	}

	private static boolean checkprime(int x) {
		for (int i=2;i<x;i++){
			if (x%i==0)return false;
		}
		System.out.println(x);
		return true;
 
	}

}
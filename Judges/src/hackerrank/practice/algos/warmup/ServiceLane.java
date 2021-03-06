package hackerrank.practice.algos.warmup;

import java.util.Scanner;

public class ServiceLane {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		int[][] range = new int[t][2];
		int[] width = new int[n];
		for (int i = 0; i < n; i++) {
			width[i] = sc.nextInt();
		}
		for (int i = 0; i < t; i++) {
			range[i][0] = sc.nextInt();
			range[i][1] = sc.nextInt();
		}
		maxim(width, range);
		sc.close();
	}

	public static void maxim(int[] width, int[][] range) {

		for (int i = 0; i < range.length; i++) {
			
			int min = 10;
			for (int k = range[i][0]; k <= range[i][1]; k++) {
				if (width[k] < min) {
					min = width[k];
				}
			}
			System.out.println(min);
		}
	}
}

package hackerrank.contest.back2school;

import java.util.Arrays;
import java.util.Scanner;

public class Tan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Point[] p = new Point[n];

		for (int i1 = 0; i1 < n; i1++) {
			p[i1] = new Point(sc.nextInt(), sc.nextInt());

		}
		Arrays.sort(p);
		for (int i1 = 0; i1 < n; i1++) {
			System.out.println(p[i1]);
		}

		sc.close();
	}

	static class Point implements Comparable<Point> {
		public int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;

		}

		public int quad() {
			if (x > 0 && y >= 0)
				return 0;
			if (x <= 0 && y > 0)
				return 1;
			if (x < 0 && y <= 0)
				return 2;
			return 3;
		}

		@Override
		public String toString() {
			return x + " " + y;
		}

		@Override
		public int compareTo(Point other) {
			int a = this.quad();
			int b = other.quad();
			if (a != b) {
				return a - b;
			}
			int m = y * other.x - x * other.y;
			if (m != 0) {
				return m;
			}
			return x * x + y * y - other.x * other.x - other.y * other.y;
		}

	}

}
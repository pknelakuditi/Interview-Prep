package spoj;

import java.util.Arrays;
import java.util.Scanner;

public class AggrCow1 {

	public static void main(String[] args) throws java.lang.Exception {

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		for (int i = 1; i <= T; i++) {
			int N = in.nextInt();
			int C = in.nextInt();
			int[] places = new int[N];
			for (int j = 0; j < N; j++) {
				places[j] = in.nextInt();
			}
			Arrays.sort(places);
			maxdiff(C, places);

		}
//
//		int[] a = { 1, 2, 4, 8, 9 };
//		maxdiff(3, a);

	}
	
	

	private static void maxdiff(int c, int[] places) {
		int low = 0;
		int high = (places[places.length - 1] - places[0]) / (c - 1);
		int mid;

		int m = 0;
		while (low <= high) {

			mid = (low + high) / 2;
			// System.out.println("mid:" + mid + " low:" + low + " high:" +
			// high);
			if (low == mid)
				break;

			if (validMinDistance(mid, c, places)) {
				low = mid;
				if (m < mid)
					m = mid;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(m);

	}

	private static boolean doeswork(int distance, int cows, int[] positions) {
		int cowsplaced = 1;
		int k = 1;
		int s = positions[0];
		while (cowsplaced < cows && k < positions.length) {
			if (s + distance > positions[positions.length - 1]) {
				break;
			}
			if (s + distance <= positions[k]) {
				s = positions[k];
				cowsplaced++;
			}
			k++;
		}
		if (cowsplaced == cows) {
			return true;
		} else {
			return false;
		}
	}
	
	 static boolean validMinDistance(int distance, int cows, int[] positions) {
	        int cowPlaced = 1;
	        int lastPosition = positions[0];
	        for (int i = 1; i < positions.length; i++) {
	            if (positions[i]-lastPosition < distance)
	                continue;
	            if (++cowPlaced == cows)
	                return true;
	            lastPosition = positions[i];
	        }
	        return false;
	    }

}

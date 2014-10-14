package spoj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class AggrCow {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        new AggrCow().run();
    }

    void run() throws IOException {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0)
            solve();
        out.flush();
    }

    void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int stalls = Integer.parseInt(tokenizer.nextToken());
        int cows = Integer.parseInt(tokenizer.nextToken());
        int[] stallPositions = new int[stalls];
        for (int i = 0; i < stalls; i++)
            stallPositions[i] = Integer.parseInt(in.readLine());
        Arrays.sort(stallPositions);
        out.println(maxdiff(cows, stallPositions));
    }

	private  int maxdiff(int c, int[] places) {
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

			if (doeswork(mid, c, places)) {
				low = mid+1;
				if (m < mid)
					m = mid;
			} else {
				high = mid - 1;
			}
		}
		return low;

	}

	private  boolean doeswork(int distance, int cows, int[] positions) {
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
}
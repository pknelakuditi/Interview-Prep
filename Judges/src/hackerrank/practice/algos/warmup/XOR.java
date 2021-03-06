package hackerrank.practice.algos.warmup;

import java.util.Scanner;

public class XOR {

	static int maxXor(int l, int r) {
		int max = 0;
		int temp = 0;
		for (int i = l; i <= r; i++) {
			for (int j = i; j <= r; j++) {
				temp = i ^ j;
				if (temp > max) {
					//System.out.println(temp);
					max = temp;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;
		int _l;
		_l = Integer.parseInt(in.nextLine());

		int _r;
		_r = Integer.parseInt(in.nextLine());

		res = maxXor(_l, _r);
		System.out.println(res);
in.close();
	}

}

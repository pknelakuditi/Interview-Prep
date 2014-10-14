package algos.warmup;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IterativeStones {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			List<Integer> l = new ArrayList<Integer>();
			stones(sc.nextInt(), sc.nextInt(), sc.nextInt(), l);
		}
		sc.close();
	}

	private static void stones(int n, int a, int b, List<Integer> l) {
		//int temp = 0;
		int max, min;
		if (a > b) {
			max = a;
			min = b;
		} else if (a == b) {
			System.out.println(a * (n - 1));
			return;
		} else {
			max = b;
			min = a;
		}
		if (n == 1) {
			System.out.println(0);
		} else {
			for (int i = 0; i < n; i++) {
				System.out.print(max * i + min * (n - 1 - i) + " ");
			}
			System.out.println();
		}

	}

}

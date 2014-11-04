package hackerrank.practice.algos.warmup;
import java.util.Scanner;

public class SherlockBeast {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			decent(sc.nextInt());
			t--;
		}sc.close();
	}

	private static void decent(int n) {
		if (n == 1) {
			System.out.println(-1);
		} else {
			int x = n, y = 0;
			// System.out.println(x + " x");
			
			if (x % 3 == 0) {
				if (y % 5 == 0) {

				}
			} else {
                int r=x % 3;
				x = x - r;
				y = y + r;
            //   System.out.println();
				while (x > 0) {

					if (x % 3 == 0) {
						if (y % 5 == 0) {
							break;
						} else {
							// System.out.println("decrese x");
							x = x - 3;
							y = y + 3;
						}
						// System.out.println(x+" break "+y);

					} else {
						// System.out.println("decrese x");
						x = x - 3;
						y = y + 3;
					}
				}

			}

			if (x % 3 + y% 5 !=0) {
				System.out.println(-1);
				}else{
			while (x > 0) {
				System.out.print(5);
				x--;
			}
			while (y > 0) {
				System.out.print(3);
				y--;
			}
			System.out.println();
				}
		}
	}

}
package hackerrank.contest.week.eleven;

//Takes more time than the other solution
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StrangeNumbers {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long max = 0;
		long[][] time = new long[n][2];
		for (int i1 = 0; i1 < n; i1++) {
			time[i1][0] = sc.nextLong();
			time[i1][1] = sc.nextLong();
			if (time[i1][1] > max) {
				max = time[i1][1];
			}
		}

		List<Long> l = strangestM(max);
		for (int i1 = 0; i1 < n; i1++) {
			int flag = 0;
			for (int i = 0; i < l.size(); i++) {

				if (l.get(i) >= time[i1][0] && l.get(i) <= time[i1][1]) {
					flag++;
				}
			}

			System.out.println(flag);
		}

		/*for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i) + ",");
			;
		}*/
	}

	public static List<Long> strangestM(long max) {
		List<Long> l = new ArrayList<Long>();
		for (long i =0; i < 10; i++) {
			if (i < 10) {
				l.add(i);
			}
		}
		int x = 1;
		long t = l.get(x);
		while (x < l.size()) {
			l.addAll(strangest(l.get(x), max));
			x++;
		}

		return l;
	}

	public static List<Long> strangest(long x, long max) {
		List<Long> l = new ArrayList<Long>();
		// System.out.println("strangest "+x);
		// List<Long> l = new ArrayList<Long>();
		long i = 2;
		while (i > 1) {

			long t = x * i;
			if (t > max) {
				break;
			}
			// System.out.println(x+"t value "+i);
			if (t < 10) {
				i++;
				// System.out.println("escape"+t);
				continue;
			}
			long length = (long) Math.log10(t) + 1;
			if (i == length) {

				if ((t) % length == 0) {
					// l.add(t);
					l.add(t);
					// System.out.print(t+",");
					i++;
				}
			} else if (i > length) {
				// System.out.println("before break");
				break;
			} else {
				i++;
				// System.out.println(t+" dd");
			}
		}
		return l;
	}

}
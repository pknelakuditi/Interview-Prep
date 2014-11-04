package hackerrank.contest.euler;
import java.math.BigInteger;
import java.util.Scanner;

public class SquareRootConvergent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		square(n);

		
		sc.close();
	}

	private static void square(final long n) {
		BigInteger den = BigInteger.valueOf(2);
		BigInteger num = BigInteger.valueOf(3);
		int flag = 0;

		for (int i = 2; i <= n; i++) {
			num = num.add(den.multiply(BigInteger.valueOf(2)));
			den = num.subtract(den);
			if (getDigitCount(num) > getDigitCount(den)) {
				flag++;
				System.out.println(i);
			}
		}
		System.out.println(flag);
	}

	public static int getDigitCount(BigInteger number) {
		double factor = Math.log(2) / Math.log(10);
		int digitCount = (int) (factor * number.bitLength() + 1);
		if (BigInteger.TEN.pow(digitCount - 1).compareTo(number) > 0) {
			return digitCount - 1;
		}
		return digitCount;
	}

}

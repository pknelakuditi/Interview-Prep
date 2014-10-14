package algos.warmup;
import java.util.Arrays;
import java.util.Scanner;

public class ScaredRobert {

	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		// String inputString = myScan.nextLine();

		String ans = myScan.nextLine();
		System.out.println(key(ans));
		// System.out.println(ans);
		myScan.close();
	}

	private static String key(String ans) {
		char[] a = ans.toCharArray();
		Arrays.sort(a);
		char temp = a[0];
		int flag = 1;
		int flag1 = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] == temp) {
				flag++;
				temp = a[i];
			} else {
				if (flag % 2 != 0 && flag1 == 1) {
					return "NO";
				} else {
					flag = 1;
					flag1 = 1;
					temp = a[i];
				}
			}
		}

		return "YES";
	}

}

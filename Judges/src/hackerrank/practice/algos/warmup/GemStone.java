package hackerrank.practice.algos.warmup;

import java.util.Arrays;
import java.util.Scanner;

public class GemStone {

	public static void main(String[] args) {
		// int[] bool = new int['z' - 'a'];
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int min = Integer.MAX_VALUE;
		int flag = 0;
		String[] str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = sc.nextLine();
			if (str[i].length() < min) {
				min = str[i].length();
				flag = i;
			}
		}
		unique(str, flag);
		sc.close();
	}

	private static void unique(String[] str, int flag) {
		char[] s=str[flag].toCharArray();
		Arrays.sort(s);
		int flag1 = 0;
		char t = '@';
		for (int j = 0; j < s.length; j++) {
			char temp=s[j];
			//System.out.println("char " + str[flag].charAt(j));
			if (t == temp) {
				continue;
			}
			for (int i = 0; i < str.length; i++) {
				t = temp;				
				if (str[i].indexOf(t) == -1) {
					break;
				} else {
					if (i == str.length - 1) {

						flag1++;
					}
				}

			}

		}
		System.out.println(flag1);
	}
}

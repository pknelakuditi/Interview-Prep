package back2school;
import java.util.Scanner;

public class Grid {

  	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfTestCase = sc.nextInt();
		String x = "";
		String y = "";
		for (int i = 0; i < numOfTestCase; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			String str[] = new String[a];
			if (a == 1) {
                sc.nextLine();
				x = sc.nextLine();
			} else {
				String s = sc.nextLine();

				for (int j = 0; j < a; j++) {
					str[j] = sc.nextLine();
				}
			}
			int c = sc.nextInt();//
			int d = sc.nextInt();
			String str1[] = new String[c];
			if (c == 1) {
                 sc.nextLine();
				y = sc.nextLine();
			} else {
				String s1 = sc.nextLine();
				for (int j = 0; j < c; j++) {
					str1[j] = sc.nextLine();
				}
			}
			if ( c == 1 ) {
              //  System.out.println(x+" i "+y);
				if (x.indexOf(y) >= 0) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			} else {
				grid(str, str1, a, c);
			}

		}
	}

	private static boolean grid(String[] str, String[] str1, int a, int c) {
		int k = -1;
		for (int j = 0; j < a; j++) {

			if (k == -1) {
				k = str[j].indexOf(str1[0]);
			} else {
				for (int e = 1; e < c; e++) {
					if (str[j].indexOf(str1[e],k-1) != k) {
						System.out.println("NO");
						return false;
					}
					j++;

				}
				System.out.println("YES");
				return true;

			}
		}
        if (k==-1){System.out.println("NO");
		return false;}else{System.out.println("YES");
				return true;}
        
	}
}
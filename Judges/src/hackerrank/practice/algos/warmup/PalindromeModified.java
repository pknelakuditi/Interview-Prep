package hackerrank.practice.algos.warmup;


public class PalindromeModified {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
//		System.out.println(t);
//		String str;
//		sc.nextLine();
//		for (int i = 0; i < t; i++) {
//        str=sc.nextLine();
//        System.out.println(str+i);
//        palindrome(str);        
//		}
//		sc.close();
		palindrome("abc");
}

	private static void palindrome(String str) {
		int j,i;
		j=str.length()-1;
		i=0;
		int flag=0;
		while(i<j){			
			flag+=Math.abs(str.charAt(i)-str.charAt(j));
			i++;
			j--;
		}
		System.out.println(flag);
	}
}
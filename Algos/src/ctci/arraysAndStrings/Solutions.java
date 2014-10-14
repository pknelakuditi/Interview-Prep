package ctci.arraysAndStrings;

import java.util.Arrays;

public class Solutions {
	
	public boolean stringRotationChecker(String str,String str1){
		String str2= str1+str1;
		if(str2.indexOf(str)==-1){return false;}		
		return true;
	}

	public String stringComp(String str) {
		if (str.length() == 0) {
			return "Empty string is given";
		} else {
			StringBuilder sb = new StringBuilder();
			// char[] a = str.toCharArray();
			int flag = 0;
			for (int i = 0; i < str.length();) {
				char x = str.charAt(i);
				sb.append(x);
				flag += 1;
				i++;
				while (i < str.length() && x == str.charAt(i)) {
					flag += 1;
					i++;
				}
				sb.append(flag);
				flag = 0;
			}
			return sb.toString();

		}
	}

	public String stringManip(char[] str, int length) {
		// StringBuffer sb = new StringBuffer(str);
		// int length = str.length;
		int newlength = length + 2 * (findSpace(str, length));
		// str[newlength] = '\0';
		for (int i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newlength - 1] = '0';
				str[newlength - 2] = '2';
				str[newlength - 3] = '%';
				// System.out.println(str);
				newlength -= 3;
			} else {
				str[newlength - 1] = str[i];
				newlength -= 1;
			}
		}
		return new String(str);
	}

	public int findSpace(char[] str, int length) {
		int spaceCount = 0;
		for (int i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		return spaceCount;
	}

	/* running time is O(n) space : O(1) */
	public boolean checkForUnique(String str) {
		if (str.length() > 256) {
			return false;
		} else {
			boolean[] qnt = new boolean[256];
			for (int i = 0; i < str.length(); i++) {
				int val = str.charAt(i);
				if (qnt[val]) {
					return false;
				} else {
					qnt[val] = true;
				}
			}
		}
		return true;

	}

	public boolean checkIfPermutation(String str, String str1) {
		if (str.length() == str1.length()) {
			if (sort(str).equals(sort(str1))) {
				return true;
			}
		}
		return false;
	}

	private String sort(String str) {
		char[] ch = str.toLowerCase().toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
}

package ctci.arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class Problems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str= "pAvan";
 System.out.println(Character.toChars(65));
 System.out.println(Character.MAX_VALUE);
 System.out.println((int)str.charAt(1));
 
 Solutions test = new Solutions();
System.out.println( test.checkForUnique("abcdefghtsj"));
System.out.println( test.checkForUnique("abcdefghtsja"));
System.out.println(test.checkIfPermutation("pavankumar", "navapKuram"));
System.out.println(test.stringManip("Mr JOHN SMITH    ".toCharArray(),13));
System.out.println(test.stringComp("aabcccccaaa"));
System.out.println(test.stringComp(""));
System.out.println(test.stringComp("abcdefghijklmn"));
System.out.println(test.stringRotationChecker("waterbottle", "terbottlewa"));


//System.out.println(test.findSpace("Mr JOHN SMITH    ".toCharArray(),13));
/*List<String> list = new ArrayList<String>();
System.out.println(list.getClass());
System.out.println(list.toString());*/

	}

}

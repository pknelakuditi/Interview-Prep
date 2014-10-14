/**
 * 
 */
package practise.initial;

/**
 * @author pavan
 *
 */
public class Strng {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 String str1=new String();
 String str2=new String("kumar");
 //String str3=new String({"a","b"});
 str1="pavan";
 str1=str1.concat(str2);
 System.out.println(str1);
 System.out.println(str2);
 System.out.println(str1.length());	
 System.out.printf("My name is %s \n",str1);
 String str3=new String();
 str3=String.format("My name is %s", str1);
 System.out.println(str3);
 System.out.println(str1.charAt(1));
 System.out.println(str1.compareTo(str3));//returns number of difference in lexographical order
 System.out.println(str1.contentEquals(str2));
 System.out.println(str1.indexOf(str2));
 //matches for regular expression
 //replace replacing char
 //replace entire sequence
 //replaceFirst
 //split
 //trim
 //subsequence(0,5)
 //substring(0,5)
 //toCharArray()
	}

}

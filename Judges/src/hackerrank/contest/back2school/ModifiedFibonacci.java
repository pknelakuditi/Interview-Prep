package hackerrank.contest.back2school;
import java.math.BigInteger;
import java.util.Scanner;
  
/*
 * 
 * Tn+2 = (Tn+1)* (Tn+1) + Tn
Input Format
You are given three space separated integers A, B and N on one line.
Input Constraints 
0 <= A,B <= 2 
3 <= N <= 20
Output Format
One integer. 
This integer is the Nth term of the given series when the first two terms are A and B respectively.
Sample Input 0 1 5
Sample Output 5
Explanation :The first two terms of the series are 0 and 1. The fifth term is 5. How we arrive at the fifth term, is explained step by step in the introductory sections.
*/
public class ModifiedFibonacci {
	
	

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		BigInteger n = sc.nextBigInteger();
		sc.close();
		fibMod(a, b, n);
    }
    
    	public static BigInteger fibMod(BigInteger a, BigInteger b, BigInteger n) {
		 {
			BigInteger t = n;
			BigInteger val =new BigInteger("0");
            BigInteger val1 =new BigInteger("1");
			BigInteger i=new BigInteger("2");
			while (t.compareTo(i)==1) {
				val = b.multiply(b).add(a);
				a = b;
				b = val;
				t=t.subtract(val1);
				//System.out.println("t "+t);
			}
			System.out.println(val);
			return val;
		}
        }}
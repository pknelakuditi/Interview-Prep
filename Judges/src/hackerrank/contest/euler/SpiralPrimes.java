package hackerrank.contest.euler;

import java.math.BigInteger;
import java.util.Scanner;

public class SpiralPrimes {
	 public static final BigInteger ZERO = BigInteger.ZERO;  // declaring constants
     public static final BigInteger ONE  = BigInteger.ONE;
     public static final BigInteger TWO = BigInteger.valueOf(2);
     public static final int[] aValues = {2,3,5,7,11,13,17,19,23,29,31,37,41};
	private static BigInteger sixty = new BigInteger("6000000000");

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
		long n=sc.nextLong();
		System.out.println(spiral(n));
		sc.close();
		//System.out.println(millerRabin(BigInteger.valueOf(3), 10));;
	}

	private static long spiral(long n) {
		BigInteger temp =  ONE;
		long total=1;
		long flag=3;
		for(BigInteger i=TWO;i.compareTo(sixty)<1;){
			for(long j=1;j<=4;j++){
				temp=temp.add(TWO.multiply(i));
			//	System.out.println(temp);
				if(millerRabin(temp,13)){
				//	System.out.println("fincs");
					flag++;
				}
			}
			total+=4;
		//	System.out.println((flag*100)/total);
			if((flag*100)/total<=n){
				//System.out.println(i);
				return i.multiply(TWO).add(ONE).longValue();
			}
		i=i.add(ONE);}
		return -1;
	}
	 public static boolean testPr (BigInteger n, BigInteger a, int s, BigInteger d){
         for (int i=0; i<s; i++){
                 BigInteger exp = TWO.pow(i);
                 exp = exp.multiply(d);
                 BigInteger res = a.modPow(exp, n);
                 if (res.equals(n.subtract(ONE)) || res.equals(ONE)){
                         return true;
                 }
         }
         return false;
 }

 public static boolean millerRabin (BigInteger n, int numValues){ // n = number to test
         BigInteger d = n.subtract(ONE);                          // numValues = # of bases to test
         int s = 0;
         while (d.mod(TWO).equals(ZERO)){
                 s++;
                 d = d.divide(TWO);
         }
       //  System.out.print("Base ");
         for (int i=0; i<numValues; i++){     // loops through the bases, terminating early if 
                 BigInteger a = BigInteger.valueOf(aValues[i]);  // composite
                 boolean r = testPr(n, a, s, d);
             //    System.out.print(aValues[i] + " ");
                 if (!r){
                         return false;
                 }
         }
         return true;
 }

}

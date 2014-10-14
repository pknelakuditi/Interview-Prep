package back2school;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
//time taking ,but correct sol
// n-k+1 C k
public class Lovers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[][] a = new double[n][2];
		for (int i = 0; i < n; i++) {
			a[i][0] = sc.nextDouble();
			a[i][1] = sc.nextDouble();
		}
		ways(a, n);
		sc.close();
	}
	
	static BigInteger binomial(final double N, final double K) {
	    BigInteger ret = BigInteger.ONE;
	    for (double k = 0; k < K; k++) {
	        ret = ret.multiply(BigInteger.valueOf((long) (N-k)))
	                 .divide(BigInteger.valueOf((long) (k+1)));
	    }
	    return ret;
	}

	

	private static void ways(double[][] a, int n) {
	//	BigInteger temp = new BigInteger("0");
		BigInteger m = new BigInteger("100003");
		for (int i = 0; i < n; i++) {
			if (a[i][1] <= a[i][0] / 2) {
				BigInteger[] t = new BigInteger[2];				
				/*t[0] = factorialM(a[i][0] - a[i][1] + 1, a[i][0] - 2 * a[i][1] + 1);
				t[1]= factorialM(a[i][1],0);
					temp = t[0].divide(t[1]);
				System.out.println(temp.mod(m));
				*/
				t[0]=binomial(a[i][0] - a[i][1] + 1,a[i][1] );
				System.out.println(t[0].mod(m));
				//System.out.println(binomial(133, 71));
			
			} else {
				if(a[i][1] == (a[i][0]+1) / 2){System.out.println(1);}
				else{System.out.println(0);}
				
			}
		}
	}

	@SuppressWarnings("unused")
	private static BigInteger factorialM(double n, double b) {
	//	System.out.println(n+" mul "+b);
		BigInteger result = new BigInteger("1");
		BigInteger test2 = new BigInteger("1");
		BigInteger test = new BigDecimal(b+1).toBigInteger();
		for (double i = b+1; i <= n; i++) {
			result = result.multiply(test);	
		//	System.out.println("result " +result);
			test = test.add(test2);	
		}
		
		return result;
		

	}
	
	


}

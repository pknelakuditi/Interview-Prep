package hackerrank.practice.algos.warmup;
import java.util.HashSet;
import java.util.Scanner;


public class IsFibo {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int testCases=sc.nextInt();
		long[] ar=new long[testCases];
		long max=0;
		for(int i=0;i<testCases;i++){
			ar[i]=sc.nextLong();
			if(ar[i]>max){
				max=ar[i];
			}
		}
	//	System.out.println("max "+max);
		HashSet<Long> hs=fib(max);
	//	System.out.println(hs.toString());
		for(int i=0;i<testCases;i++){
			if(hs.contains(ar[i])){
				System.out.println("IsFibo");
			}else{
				System.out.println("IsNotFibo");
			}
		}
		
		sc.close();
	}

	private static HashSet<Long> fib(long max) {
	   HashSet<Long> hs=new HashSet<Long>();
	  // hs.add(1);
	   long a=1,b=1;long temp;
	   while(b<=max){
		   hs.add(b);
		   temp=b;
		   b=a+b;
		   a=temp;
	   }
		return hs;
	}

}

package hackerrank.practice.algos.warmup;
import java.util.HashSet;
import java.util.Scanner;

public class NumberDivisible {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        while(tc>0){
            countDivisibleNumbers(sc.nextLong());
            tc--;
        }
        sc.close();
    }
    
    @SuppressWarnings("unused")
	private static void countDivisibleNumbers(long a){
    	long n=a;
        HashSet<Integer> hs=new HashSet<Integer>();
        int flag=0;
        //hs.add(1);
        for(int i=1;i<10;i++){
        	if(a%i==0){
        		hs.add(i);
        	}
       
        }
        for(int i=1;n>0;i++){
        	int temp=(int) (n%10);
        	if(hs.contains(temp)){
        		flag++;
        	}
        	n=n/10;
        }
         System.out.println(flag);;
    }
}

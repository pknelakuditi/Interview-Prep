package algos.warmup;
import java.util.Scanner;

public class SherlockSquares {
	public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  int testCases=sc.nextInt();
  while(testCases>0){
	  System.out.println(noOfSquares(sc.nextLong(),sc.nextLong()))	; 
	  testCases--;
  }
  sc.close();
	}

	private static int noOfSquares(long a, long b) {
		long temp=(long)Math.sqrt(a);	
		long temp2=temp*temp;
		int flag=0;
		while(temp2<=b ){
			if(temp2>=a){flag++;}
			
			temp++;						
			temp2=temp*temp;
		}
		
		return flag;
	}
}

package hackerrank.practice.algos.warmup;

import java.util.Scanner;

public class ChoclateLover {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
        }
        
        in.close();
    }
    
    private static long Solve(int N, int C, int M){
        long noOfcholates=N/C+wrap(N/C,M);
        
    //    return noOfcholates;//
		return noOfcholates;
        
    }

	private static int wrap(int i, int m) {
		//System.out.println(i+" "+m);
		if(i<m)return 0;
		else{
			return (i/m)+wrap(i%m+i/m,m);
		}
		
	}
    
    
}
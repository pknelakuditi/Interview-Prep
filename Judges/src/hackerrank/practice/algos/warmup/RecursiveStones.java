package hackerrank.practice.algos.warmup;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecursiveStones {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
            List<Integer> l=new ArrayList<Integer>();
			stones(sc.nextInt()-1, sc.nextInt(), sc.nextInt(), 0,l);
            for(int j=0;j<l.size();j++){
			System.out.print(l.get(j)+" ");
		}
          System.out.println();
		}
		
		sc.close();
	}

	private static void stones(int n, int a, int b, int temp,List<Integer> l) {
         if(n==0){
        	 if(!l.contains(temp)){
        		 l.add(temp);
        	 }
        	//System.out.print(temp+" ");
         }else{
        	 stones(n-1,a,b,temp+a,l);
        	 stones(n-1,a,b,temp+b,l);
         }
	}

}

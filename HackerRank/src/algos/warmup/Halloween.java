package algos.warmup;

import java.util.Scanner;

public class Halloween {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			long[] points = new long[n];
			for (int i1 = 0; i1 < n; i1++) {
				points[i1] = sc.nextInt();	
				System.out.println();
			}
	        term(points);
			sc.close();
	}

	private static void term(long[] points) {
		// TODO Auto-generated method stub
		long temp;
		for (int i1 = 0; i1 < points.length; i1++) {
			//System.out.println(((points[i1]/2))*((points[i1]/2)+1));
			//System.out.println((points[i1]/2)*((points[i1]/2)+1));
				temp=(points[i1]/2)*((points[i1]/2)-1);
			//	System.out.println("temp"+temp);
				if((points[i1]%2)==0){
					temp+=(points[i1])/2;
				}else{
					temp+=(points[i1])/2;temp+=(points[i1])/2;
				}
				System.out.println(temp);
				temp=0;
		}
	}

}


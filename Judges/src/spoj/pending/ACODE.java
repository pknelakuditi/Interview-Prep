package spoj.pending;

import java.util.HashMap;
import java.util.Scanner;
public class ACODE {
	static HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int temp;
		while((temp=sc.nextInt())!=0){
			System.out.println(perm(temp));
		}
	}

	private static int perm(int num) {
		// TODO Auto-generated method stub
		if(num<11){
			return 1;
		}
		if(hm.containsKey(num)){
			return hm.get(num);
		}
		
		
		int length = (int)(Math.log10(num)+1);
		int x=(int) Math.pow(10,length-1);
		int y=x/10;
		int temp=perm(num%x);
	//	System.out.println(temp+" "+num%x);
	//	System.out.println(num/y+" tempy");
		if((num/y)<=26 && (num/y)>0 ){
			
			temp+=perm(num%(x/10));
		}
		hm.put(num, temp);
		
		return temp;
	}

}

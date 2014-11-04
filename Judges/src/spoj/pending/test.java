package spoj.pending;

public class test {

	public static void main(String[] args) {
		//int a=0;
		//System.out.println(Math.ceil(Math.sqrt(36)));
		//System.out.println(a);
//		int a=5;
//		int ix=a+(a&-a);
//		System.out.println(ix);
		int num=25114;
		int length = (int)(Math.log10(num)+1);
		int x=(int) Math.pow(10,length-1);
		int temp=(num%x);
		System.out.println(temp);
		
	}

}

package practise.michigan;


public class Main1 {

	public static void main(String[] args) {
		byte b =  Byte.MAX_VALUE;
		System.out.println(b);
		
		int []a=new int[5] ;
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
			System.out.println(a[i]);
			
		}
		System.out.println();
		for ( int i : a){ System.out.println(i);}
		
	//	Range range = new Range(0,10); 6183741518
		
	
	}

}

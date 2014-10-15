package randomInterview;

import java.util.HashSet;
import java.util.Iterator;

public class Parenthesis {

	public static void main(String[] args) {
		HashSet<String> hs=new HashSet<String>();
		
		parenthesis(3, "",hs);
		System.out.println(hs.size()+hs.toString());
	}

   
	private static void parenthesis(int i,String s,HashSet<String> hs){
		if(i==0){
			//System.out.println(s);
			hs.add(s);
		}else{
			parenthesis(i-1,"{"+s+"}",hs);
			parenthesis(i-1,s+"{"+"}",hs);
			parenthesis(i-1,"{"+"}"+s,hs);
		}
		
	}
	
}

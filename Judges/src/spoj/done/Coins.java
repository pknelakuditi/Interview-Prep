package spoj.done;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class Coins {
	
	static HashMap<Integer, Long> hm;

	public static void main(String[] args) throws Exception {
		String line;
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		hm = new HashMap<Integer, Long>();

		 while ((line = in.readLine()) != null)  {
			out.println(coinsT(Integer.parseInt(line)));
		}
		 out.flush();
		
	}


	public static long coinsT(int i) {
		if (i < 12) {
			return i;
		}

		if (hm.containsKey(i)) {
			return hm.get(i);
		}
		long temp = coinsT(i / 2) + coinsT(i / 3) + coinsT(i / 4);
		hm.put(i, temp);
		return temp;
	}

}

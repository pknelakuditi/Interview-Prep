package spoj.done;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;

// Range Minimum Query
public class RMQSQ {
	static int[] sgmntMin;

	public static void main(String[] args) throws Exception {
		 Parser sc = new Parser(System.in);
		int N = sc.nextInt();
		int size = (int) Math.ceil(Math.sqrt(N));
		int[] values = new int[N];
		for (int i = 0; i < N; i++) {
			values[i] = sc.nextInt();
		}
		preprocess(values, size);

		// System.out.println(Arrays.toString(sgmntMin));
		// System.out.println(Arrays.toString(values));
		int Q = sc.nextInt();

		for (int i = 0; i < Q; i++) {
			// System.out.println("i val"+i);
			minRange(sc.nextInt(), sc.nextInt(), size, values);
		}
	}

	private static void minRange(int a, int b, int size, int[] values) {
		// System.out.println(a+"ab"+b);
		int aS = a / size;
		int aRem = a % size;
		int r = (aS + 1) * size;
		int bS = b / size;
		int bRem = b % size;
		int l = bS * size;
		int min = Integer.MAX_VALUE;
		// System.out.println(aS+" "+bS);
		if (aS == bS) {
			for (int i = a; i <= b; i++) {
				if (min > values[i]) {					
					min = values[i];
				}
			}
			System.out.println(min);
			return;
		} else {
			for (int i = a; i <= b; i++) {
				if (min > values[i]) {
					min = values[i];

				}
				if (i % size == size - 1) {
					break;
				}
			}
			for (int i = aS + 1; i < bS; i++) {
				if (min > sgmntMin[i]) {
					min = sgmntMin[i];
				}
			}
			for (int i = b;; i--) {

				if (min > values[i]) {
					min = values[i];
				}
				if (i % size == 0) {
					break;
				}

			}
		}

		System.out.println(min);
	}

	private static void preprocess(int[] values, int s) {

		// System.out.println(noSeg);
		sgmntMin = new int[s];
		Arrays.fill(sgmntMin, Integer.MAX_VALUE);
		int flag = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < values.length; i++) {
			if (i % s == 0) {
				flag++;
				min = Integer.MAX_VALUE;
			}
			if (sgmntMin[flag] > values[i]) {
				sgmntMin[flag] = values[i];
				// System.out.println("min");
			}
		}
	}
}

class Parser
{
   final private int BUFFER_SIZE = 1 << 16;
 
   private DataInputStream din;
   private byte[] buffer;
   private int bufferPointer, bytesRead;
 
   public Parser(InputStream in)
   {
      din = new DataInputStream(in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
   }
 
   public long nextLong() throws Exception
   {
      long ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do
      {
         ret = ret * 10 + c - '0';
         c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
   }
   
   //reads in the next string
   public String next() throws Exception
   {
      StringBuilder ret =  new StringBuilder();
      byte c = read();
      while (c <= ' ') c = read();
      do
      {
         ret = ret.append((char)c);
         c = read();
      } while (c > ' ');
      return ret.toString();
   }
 
   public int nextInt() throws Exception
   {
      int ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do
      {
         ret = ret * 10 + c - '0';
         c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
   }
   
   private void fillBuffer() throws Exception
   {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1) buffer[0] = -1;
   }
 
   private byte read() throws Exception
   {
      if (bufferPointer == bytesRead) fillBuffer();
      return buffer[bufferPointer++];
   }
   }
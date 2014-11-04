package spoj.pending;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class EZDIJKST {
	private static Reader in;
	private static PrintWriter out;

	public static void main(String[] args) throws IOException {
		in = new Reader();
		out = new PrintWriter(System.out, true);
		int t = 1;
		while (t > 0) {

			int n = in.nextInt();
			int m = in.nextInt();
			//System.out.println("for " + n + " " + m);
			ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<Edge>());
			}
			for (int i = 0; i < m; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				int w = in.nextInt();
				graph.get(a).add(new Edge(b, w));
				graph.get(b).add(new Edge(a, w));
			//	System.out.println("adding edge" + b + " " + a + " " + w);
			}
			int source = 1;
			int dest = n;
			
		//	System.out.println("for2 " + source + " " + dest);
			long result = easyDijkstra(graph, n, source, dest);
         //  out.println(result);
			if (result == -1) {
				out.println("-1");
				//System.out.println("NO");
			} else {
				//System.out.println(result);
			}

			// System.out.println();
			t--;
		}
		out.close();
		System.exit(0);
	}

	public static long easyDijkstra(ArrayList<ArrayList<Edge>> graph, int n,
			int source, int dest) {
		
		boolean[] visited = new boolean[n + 1];
		long[] dist = new long[n + 1];
		int[] parent = new int[n + 1];

		Arrays.fill(dist,Long.MAX_VALUE);
		long mstValue = -1;
		// int f=source;
		int temp = source;
		parent[source]=source;
		dist[temp] = 0;
		boolean flag = false;
		visited[temp] = true;
		while (!flag) {
			flag=true;
            
			for (Edge e : graph.get(temp)) {
				if (!visited[e.oEdge]) {
					if (dist[e.oEdge] > e.weight + dist[temp]) {
						dist[e.oEdge] = e.weight + dist[temp];
						parent[e.oEdge]=temp;
						flag=false;
					}
				}

			}

			long min = Long.MAX_VALUE;
			int index = 0;
			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					if (min > dist[i]) {
						index = i;
						min = dist[i];
						temp = i;
						flag=false;
					}

				}
			}

			visited[index] = true;

			if (index == dest) {
				flag = true;
				mstValue = dist[dest];
				StringBuilder sb=new StringBuilder();
				print(sb,parent,dest);System.out.println(sb);
			}

		}
		return mstValue;
	}

	private static void print(StringBuilder sb,int[] parent, int dest) {
		
		if(parent[dest]==dest){
			sb.append(dest);
			sb.append(" ");
		//	
		}else{
			
			print(sb,parent,parent[dest]);
			sb.append(dest);
			sb.append(" ");
		}
	}

	public static class Edge {
		int weight;
		int oEdge;

		public Edge(int oEdge, int weight) {
			super();
			this.weight = weight;
			this.oEdge = oEdge;
		}
	}

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[1024];
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (c == '.')
				while ((c = read()) >= '0' && c <= '9')
					ret += (c - '0') / (div *= 10);
			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
}

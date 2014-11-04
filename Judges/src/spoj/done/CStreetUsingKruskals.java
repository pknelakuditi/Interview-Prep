package spoj.done;
//working
import java.util.PriorityQueue;
import java.util.Scanner;

public class CStreetUsingKruskals {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0){
			int p=sc.nextInt();
			int v = sc.nextInt();
			int e = sc.nextInt();
			PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
			for (int i = 0; i < e; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
	           pq.add(new Edge(a,b,c));
			}
			
			System.out.println(kruskals(pq,v)*p);
			
			t--;
		}
		
		sc.close();
	}

	private static int kruskals(PriorityQueue<Edge> pq, int v) {
		DisjointSets ds=new DisjointSets(v);
		Edge current;
		int components=v;
		int cost=0;
		while(!pq.isEmpty()){
			current=pq.remove();
			if(ds.find(current.edge-1)==ds.find(current.oEdge-1)){
				continue;
			}
			components--;
			ds.union(current.edge-1,current.oEdge-1);
			cost+=current.cost;
		}
		if(components>1){
			return -1;
		}else{
			return cost;
		}
		
	}

	public static class Edge implements Comparable<Edge>{
		int edge;
		int oEdge;
		int cost;

		public Edge(int edge, int oEdge, int cost) {
			super();
			this.edge = edge;
			this.oEdge = oEdge;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge edge) {			
			return this.cost-edge.cost;
		}

	}

	public static class DisjointSets {
		int[] parents;

		public DisjointSets(int size) {
			parents = new int[size];
			for (int i = 0; i < size; i++) {
				parents[i] = i;
			}

		}

		public int find(int x) {
			if (parents[x] == x) {
                return x;
			}else{
				parents[x]=find(parents[x]);
				return parents[x];
			}
			
		}
		
		public void union(int x,int y){
			parents[find(x)]=find(y);
		}

	}


}

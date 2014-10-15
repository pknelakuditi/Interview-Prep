package spoj;
//working
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CStreetUsingPrimsPQ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int i = 1; i <= t; i++) {
			int p=in.nextInt();
			int vertices = in.nextInt();
			int edges = in.nextInt();

			Vertex[] graph = new Vertex[vertices + 1];

			for (int j = 0; j <= vertices; j++) {
				graph[j] = new Vertex();
			}

			for (int k = 0; k < edges; k++) {
				int start = in.nextInt();
				int finish = in.nextInt();
				int cost = in.nextInt();
				graph[start].neighbors.add(new Edge(finish, cost));
				graph[finish].neighbors.add(new Edge(start, cost));
			}

		 System.out.println(PrimsAlgorithm(graph, 1)*p);

		
		}in.close();
	}
	
	
	private static int PrimsAlgorithm(Vertex[] graph, int source) {
		PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
		boolean[] visited=new boolean[graph.length];
	//	System.out.println("graph.length"+visited.length);
		int cost=0;
		
		visited[source]=true;
		for(Edge e:graph[source].neighbors){
			pq.add(e);
		}
		
		while(!pq.isEmpty()){
			Edge current=pq.remove();
		
			if(visited[current.edge]){
				continue;
			}
			visited[current.edge]=true;
			cost=cost+current.cost;
			//System.out.println(cost);
			
			for(Edge e:graph[current.edge].neighbors){
				if(visited[e.edge]){
					continue;
				}
				pq.add(e);
				
			}
			
			
		}
		for(int i=1;i<visited.length;i++){
			if(!visited[i]){
				return -1;
			}
		}
		
		return cost;
	}


	public static class Vertex{
		ArrayList<Edge> neighbors;

		public Vertex( ) {
			neighbors=new ArrayList<Edge>();
		}
		
	}
	
	public static class Edge implements Comparable<Edge>{
		int edge;
		int cost;
		public Edge(int edge, int cost) {
			super();
			this.edge = edge;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
		
		
	}


}

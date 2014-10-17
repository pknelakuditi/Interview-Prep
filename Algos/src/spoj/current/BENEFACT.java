package spoj.current;
//longest path in a tree
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class BENEFACT {
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int i = 1; i <= t; i++) {

			int vertices = in.nextInt();
			

			Vertex[] graph = new Vertex[vertices + 1];

			for (int j = 0; j <= vertices; j++) {
				graph[j] = new Vertex();
			}

			for (int k = 0; k < vertices-1; k++) {
				int start = in.nextInt();
				int finish = in.nextInt();
				int cost = in.nextInt();
				graph[start].neighbors.add(new Edge(finish, cost));
				graph[finish].neighbors.add(new Edge(start, cost));
			}
			
			int max=0;
			for(int i1=1;i1<=vertices;i1++){
				visited = new boolean[vertices + 1];
				int t1=dFS(visited, i1, graph, 0);
				if(max<t1){max=t1;};
			}
       
			
			System.out.println(max);
			

			
		}
	}

	static class Vertex {
		List<Edge> neighbors;

		public Vertex() {
			neighbors = new ArrayList<Edge>();
		}
	}

	static class Edge  {
		int end, cost;

		public Edge(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
	}

	private static int dFS(boolean[] visited ,int source,Vertex[] graph ,int cost) {
		
		Stack<Integer> s = new Stack<Integer>();
	    s.add(source);
		visited[source] = true;
		int max=0;
		int t;
		
		while(!s.isEmpty()){
			int temp=s.pop();
		
			ArrayList<Edge> neighbours=(ArrayList<Edge>) graph[temp].neighbors;
			
			for(Edge n:neighbours){
				if(!visited[n.end]){
					visited[n.end]=true;
					t=n.cost+dFS(visited,n.end,graph,cost);
					if(max<t){
						max=t;
						
					//	System.out.println("end "+n.end);
					}
				}
			}
			
		}		
         
		return max;
	}
}

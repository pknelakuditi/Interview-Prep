package spoj.current;
//longest path in a tree
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import spoj.CSTREET.Edge;

public class BENEFACT {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int p = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<Edge>());
			}
			for (int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int w = sc.nextInt();
				graph.get(a).add(new Edge(b, w));
				graph.get(b).add(new Edge(a, w));
			}

			System.out.println(DFS(graph, n));
			t--;
		}
	}
	
	private static int DFS(ArrayList<ArrayList<Edge>> graph, int n) {
		
//		boolean[] visited = new boolean[v + 1];
//		Stack<Integer> s = new Stack<Integer>();
//	    s.add(1);
//		visited[1] = true;
//		
//		while(!s.isEmpty()){
//			int temp=s.pop();
//			ArrayList<Integer> neighbours=graph.get(temp);
//			for(int n:neighbours){1
//				if(!visited[n]){
//					s.add(n);
//					visited[n]=true;
//				}
//			}
//			
//		}
//		
//		for (int i = 1; i <= v; i++) {
//			if (!visited[i]) {
//				return false;
//			}
//		}

		//return true;
		
		
		
		return -1;
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
}

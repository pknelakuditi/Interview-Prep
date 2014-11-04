package spoj.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class MST {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while (t > 0) {
		//	int p = sc.nextInt();
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

			System.out.println(mst(graph, n));
			t--;
		}
		sc.close();
	}

	public static long mst(ArrayList<ArrayList<Edge>> graph, int n) {
		boolean[] visited = new boolean[n + 1];
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		long mstValue=0;
		int f=1;
		int temp=1;
		boolean flag = false;
		visited[1] = true;
		while (!flag) {
			//update all the reachable nodes distances from visited nodes
			 
				if (visited[temp]) {
					for (int j = 0; j < graph.get(temp).size(); j++) {
						if (graph.get(temp).get(j).weight < dist[graph.get(temp).get(
								j).oEdge]) {
							dist[graph.get(temp).get(j).oEdge] = graph.get(temp).get(
									j).weight;
						}
					}
				}
			
           
            int min=Integer.MAX_VALUE;
            int index=0;
           for (int i = 1; i <= n; i++) {            	
            	if(!visited[i]){
            		if(min>dist[i]){
           			index=i;
           			min=dist[i];
           			temp=i;
            		}
            		
            	}
           }
           
           //update values using result
            visited[index]=true;
            mstValue+=min;
            f++;
           //after n-1 iterations close the loop 
			if(f==n){
				flag=true;
			}
		}
		return mstValue;
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

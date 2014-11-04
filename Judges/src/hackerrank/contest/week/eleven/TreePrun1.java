package hackerrank.contest.week.eleven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class TreePrun1 {
	static int[][] edges;
	static int[] weight;
	static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int source = 1;

		edges = new int[n - 1][2];
		weight = new int[n + 1];
		visited = new boolean[n + 1];
		for (int i1 = 1; i1 <= n; i1++) {
			weight[i1] = sc.nextInt();
		}
		for (int i1 = 0; i1 < n - 1; i1++) {
			edges[i1][0] = sc.nextInt();
			edges[i1][1] = sc.nextInt();
		}
		Vertex[] vertices = new Vertex[n + 1];
		intialize(vertices, source);
		int fl = update(visited, vertices, source);
		
		
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		for (int i1 = 1; i1 <= n; i1++) {
			pq.add(vertices[i1]);
		}

		for (int j = 1; j <= k; j++) {
			for (int i1 = 1; i1 <= n; i1++) {
				System.out.print(vertices[i1].id+" w "+vertices[i1].tWeight+" ");
			}
	        System.out.println();

			int temp = pq.remove().id;
			
			
			if (visited[temp]) {
				j--;
				continue;
			}
			System.out.println(Arrays.toString(visited));
			System.out.println("removing "+temp);
			System.out.println("peeking "+pq.peek().id);
			remove(visited, temp, vertices);
			System.out.println(Arrays.toString(visited));
			int tem=update(visited, vertices, 1);
			for (int i1 = 1; i1 <= n; i1++) {
				System.out.print(vertices[i1].tWeight+" ");
			}
	     	System.out.println();
			System.out.println("change "+tem);
			if (fl >tem ) {
				break;
			}
			fl = tem;

			
		}
		int cost=0;
		for(int i=1;i<=n;i++){
			if(!visited[i]){
				cost+=vertices[i].cost;
			}
		}
		
		System.out.println(cost);
		sc.close();

	}

	private static void remove(boolean[] bol, int temp, Vertex[] vertices) {
		Stack<Integer> s = new Stack<Integer>();
		bol[temp] = true;
		s.addAll(vertices[temp].children);
		while (!s.isEmpty()) {
			int t = s.pop();
			bol[t] = true;
			// System.out.println("removed from pq "+t);
			s.addAll(vertices[t].children);
		}
	}

	private static int update(boolean[] v, Vertex[] vertices, int source) {
		vertices[source].tWeight = vertices[source].cost;
		if (v[source]) {
			return 0;
		} else if (vertices[source].children.isEmpty()) {
			vertices[source].tWeight = vertices[source].cost;
			
		} else {
			for (int i : vertices[source].children) {
				vertices[source].tWeight += update(v, vertices, i);
			}

		}
		return vertices[source].tWeight;
	}

	private static void intialize(Vertex[] vertices, int source) {
		Queue<Vertex> pq = new LinkedList<Vertex>();
		vertices[source] = new Vertex(source, weight[source], source);
		vertices[source].children = findChildren(source, source);
		pq.add(vertices[source]);
		while (!pq.isEmpty()) {
			Vertex current = pq.remove();
			for (int i : current.children) {
				vertices[i] = new Vertex(current.id, weight[i], i);
				vertices[i].children = findChildren(i, current.id);
				pq.add(vertices[i]);
			}

		}

	}

	private static ArrayList<Integer> findChildren(int id, int parent) {
		ArrayList<Integer> children = new ArrayList<Integer>();
		for (int i = 0; i < edges.length; i++) {
			if (id == edges[i][0]) {
				if (!(edges[i][1] == parent)) {
					children.add(edges[i][1]);
				}
			} else if (id == edges[i][1]) {
				if (!(edges[i][0] == parent)) {
					children.add(edges[i][0]);

				}
			}
		}
		return children;
	}

	static class Vertex implements Comparable<Vertex> {
		int parent;
		int tWeight;
		int cost;
		int id;
		ArrayList<Integer> children;

		@Override
		public int compareTo(Vertex o) {
			return this.tWeight - o.tWeight;
		}

		public Vertex(int parent, int cost, int id) {
			super();
			this.parent = parent;
			this.cost = cost;
			this.tWeight = cost;
			this.id = id;
		}

	}
}

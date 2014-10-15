package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Dijkstras {

	public static int dijkstras(Vertex[] graph, int source, int destination) {

		Vertex current = graph[source];
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();

		pq.add(current);
		while (!pq.isEmpty()) {
			current = pq.remove();
			if (current.id == destination) {
				break;
			}
			for (Edge e : current.neighbors) {
				Vertex end = graph[e.end];
				int distance = e.distance;
				int newMin = distance + current.minDistance;
				if (newMin < end.minDistance) {
					end.minDistance = newMin;
					pq.add(end);
				}
			}

		}

		if (graph[destination].minDistance == Integer.MAX_VALUE) {
			return -1;
		} else {
			return graph[destination].minDistance;
		}
		
	}

	public static void main(String[] ags) throws Exception {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int i = 0; i < t; i++) {
			int vertices = in.nextInt();
			int edges = in.nextInt();

			Vertex[] graph = new Vertex[vertices + 1];

			for (int j = 1; j <= vertices; j++) {
				graph[j] = new Vertex(j);
			}

			for (int k = 0; k < edges; k++) {
				int a = in.nextInt();
				int b = in.nextInt();
				int distance = in.nextInt();
				graph[a].neighbors.add(new Edge(b, distance));
				graph[b].neighbors.add(new Edge(a, distance));
			}

			int source = in.nextInt();
			int destination = in.nextInt();

			int result = dijkstras(graph, source, destination);

			if (result == -1) {
				System.out.println("NO");
			} else {
				System.out.println(result);
			}
		}
	}

	static class Vertex implements Comparable<Vertex> {
		int id, minDistance;
		List<Edge> neighbors;

		public Vertex(int id) {
			this.id = id;
			this.minDistance = Integer.MAX_VALUE;
			this.neighbors = new ArrayList<Edge>();
		}

		public int compareTo(Vertex v) {
			return (this.minDistance > v.minDistance) ? 1 : -1;
		}
	}

	static class Edge {
		int end, distance;

		public Edge(int end, int distance) {
			this.end = end;
			this.distance = distance;
		}
	}
}
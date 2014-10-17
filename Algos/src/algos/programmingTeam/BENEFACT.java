package algos.programmingTeam;

import java.util.ArrayList;
import java.util.PriorityQueue;
class BENEFACT{
	public static void main(String[] args)throws Exception{
		Parser in = new Parser(System.in);
		StringBuilder string = new StringBuilder();
		int t = in.nextInt();
		for(int i = 0; i < t; i++){
			int vertices = in.nextInt();
			Node[] graph = new Node[vertices+1];

			for(int j = 0; j <= vertices; j++){
				graph[j] = new Node(j);
			}

			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			for(int k = 0; k < vertices-1; k++){
				int start = in.nextInt();
				int end = in.nextInt();
				int length = in.nextInt();
				graph[start].neighbors.add(new Pair(start, end, length));
				graph[end].neighbors.add(new Pair(end, start, length));

				if(pq.size() == 0){
					pq.add(graph[start]);
				}
			}

			boolean[] visited = new boolean[vertices+1];
			Node current = null;
			while(pq.size() != 0){
				current = pq.remove();
				visited[current.id] = true;
				for(int e = 0; e < current.neighbors.size(); e++){
					if(!visited[current.neighbors.get(e).end]){
						Node temp = graph[current.neighbors.get(e).end];
						temp.dist = current.neighbors.get(e).length + current.dist;
						pq.add(temp);
					}
				}
			}

			visited = new boolean[vertices+1];
			pq.add(graph[current.id]);
			current.dist = 0;
			while(pq.size() != 0){
				current = pq.remove();
				visited[current.id] = true;
				for(int e = 0; e < current.neighbors.size(); e++){
					if(!visited[current.neighbors.get(e).end]){
						Node temp = graph[current.neighbors.get(e).end];
						temp.dist = current.neighbors.get(e).length + current.dist;
						pq.add(temp);
					}
				}
			}
			string.append(current.dist + "\n");
		}
		System.out.print(string);
	}

	static class Node implements Comparable<Node>{
		int id, dist;
		ArrayList<Pair> neighbors;

		public Node(int id){
			this.id = id;
			this.dist = 0;
			neighbors = new ArrayList<Pair>();
		}

		public int compareTo(Node n){
			return (this.dist > n.dist) ? 1 : -1;
		}
	}

	static class Pair{
		int start, end, length;

		public Pair(int start, int end, int length){
			this.start = start;
			this.end = end;
			this.length = length;
		}
	}
}

  
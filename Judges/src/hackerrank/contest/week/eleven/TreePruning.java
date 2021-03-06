package hackerrank.contest.week.eleven;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TreePruning {
	static int[][] edges;
	static int[] weight;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		 edges = new int[n - 1][2];
		 weight = new int[n];
		for (int i1 = 0; i1 < n; i1++) {
			weight[i1] = sc.nextInt();
		}
		for (int i1 = 0; i1 < n - 1; i1++) {
			edges[i1][0] = sc.nextInt();
			edges[i1][1] = sc.nextInt();

		}
		List<Node> nodes = new ArrayList<Node>();
		boolean[] bol = new boolean[n];
		bol[0] = true;
		Node temp = new Node(weight[0], 1, bol, edges);
		nodes.addAll(intialize(temp, bol, edges, weight));
		// tree(nodes.get(0), weight, edges);
		System.out.println(nodes.get(1).child.toString());
		
		//System.out.println(tree(temp,weight,edges,nodes));
		sc.close();
	}

	private static List<Node> intialize(Node node, boolean[] bol, 
			int[][] edges, int[] weight) {
		List<Node> nodes = new ArrayList<Node>();
		  nodes.add(node);
		int x=0;
		//Iterator<Integer> a = node.child.iterator(), b = node.child.iterator();
		
		while (x<node.child.size()) {
		//	System.out.println("true");
			int index1 = node.child.get(x);
			bol[index1 - 1] = true;
			x++;
		}

		int y=0;
		while (y<nodes.size()) {
			
			int index1 = node.child.get(y);
					System.out.println(" checking index "+index1);
				//	System.out.println(bol[index1 - 1]);
			//if (!bol[index1 - 1]) 
			{
				nodes.add(new Node(weight[index1 - 1], index1, bol, edges));				
				System.out.println("index added"+index1);
				
			}
			y++;
		}

		return nodes;

	}



	private static int tree(Node node, int[] weight, int[][] edges,List<Node> nodes) {
		int w=node.weight;
		List<Integer> q = new LinkedList<Integer>();
		q.add(node.index);
		Iterator i=q.iterator(),l=q.iterator();
		while (q.iterator().hasNext()) {
			System.out.println("in iterator");
           int index= (int) q.iterator().next();
           q.addAll(nodes.get(index-1).child);
          
		}
		while(l.hasNext()){
			w+=weight[(int) l.next() -1];
			System.out.println(w);
		}
		
		return w;

	}

	static class Node {
		public int weight;
		public int index;
		public int tWeight;
		public List<Integer> child;

		public Node(int weight, int index, boolean[] bol, int[][] edges) {
			super();
			this.weight = weight;
			this.index = index;
			this.child = findChild(bol, edges);
		}

		public List<Integer> findChild(boolean[] bol, int[][] edges) {
			System.out.println("children of"+index);
			List<Integer> children = new ArrayList<Integer>();
			for (int i = 0; i < edges.length; i++) {
				if (index == edges[i][0]) {
					if (!bol[edges[i][1]]) {
						children.add(edges[i][1]);
						System.out.println(edges[i][1]);
					}
				} else if (index == edges[i][1]) {
					if (!bol[edges[i][0]]) {
						children.add(edges[i][0]);
						System.out.println(edges[i][0]);
					}
				}
			}
			return children;
		}

	}
}

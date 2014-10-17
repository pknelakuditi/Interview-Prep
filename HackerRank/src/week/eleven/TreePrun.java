package week.eleven;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;



public class TreePrun {
	static int[][] edges;
	static int[] weight;
	static boolean[] bol;

	public static void main(String[] args) {
       
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int source = 1;

		edges = new int[n - 1][2];
		weight = new int[n + 1];
		 bol =new boolean[n+1];
		for (int i1 = 1; i1 <= n; i1++) {
			weight[i1] = sc.nextInt();
		}
		for (int i1 = 0; i1 < n - 1; i1++) {
			edges[i1][0] = sc.nextInt();
			edges[i1][1] = sc.nextInt();
		}

		Vertex[] vertices = new Vertex[n + 1];
     	intialize(vertices, source);
     	int fl=updateTw(vertices,1);
     	for (int i1 = 1; i1 <= n; i1++) {
			System.out.print(vertices[i1].tWeight+" ");
		}
     	System.out.println();
	//	System.out.println(updateTw(vertices,1));;
      //  System.out.println(Arrays.toString(weight));
		PriorityQueue<Vertex> pq=new PriorityQueue<Vertex>();
		for (int i1 = 1; i1 <= n; i1++) {
			pq.add(vertices[i1]);
		}
		for(int j=1;j<=k;j++){
			System.out.println("update "+fl);
			Iterator<Vertex> i=pq.iterator();
			while(i.hasNext()){
				Vertex te=i.next();
				System.out.println(te.id+" weight "+te.tWeight);
			}
			int temp=pq.remove().id;
			if(bol[temp]){j--;continue;}
			System.out.println(temp+" removed from pq");
			System.out.println("peeking "+pq.peek().id);
			vertices[vertices[temp].parent].children.remove(new Integer(temp));
			
			remove(bol,temp,vertices);
			//System.out.println();
			if(fl>updateTw(vertices,1)){
				//System.out.println("j-1");
				break;
			}fl=updateTw(vertices,1);
			for (int i1 = 1; i1 <= n; i1++) {
				System.out.print(vertices[i1].tWeight+" ");
			}
	     	System.out.println();
		}
		for (int i1 = 1; i1 <= n; i1++) {
			System.out.print(vertices[i1].tWeight+" ");
		}
     	System.out.println();
		System.out.println(vertices[1].tWeight);
	//	System.out.println(vertices[2].children);
		sc.close();
		
	}

	private static void remove(boolean[] bol, int temp,Vertex[] vertices) {
	       Stack<Integer> s=new Stack<Integer>();
	       bol[temp]=true;
	       s.addAll(vertices[temp].children);
	       while(!s.isEmpty()){
	    	   int t=s.pop();
	    	   bol[t]=true;
	    	   System.out.println("removed from pq "+t);
	    	   s.addAll(vertices[t].children);
	       }
	}

	private static int updateTw(Vertex[] vertices,int source) {
		vertices[source].tWeight=vertices[source].cost;
		//System.out.println(vertices[source].tWeight+" of "+source+" source cost "+vertices[source].cost);
		if(vertices[source].children.isEmpty()){
			vertices[source].tWeight=vertices[source].cost;
		}else{
			
			for(int i: vertices[source].children){
				vertices[source].tWeight+=updateTw(vertices,i);
			///	System.out.println(vertices[source].tWeight+" source "+source);
			}
		}
		
		return vertices[source].tWeight;
		
		
	}

	private static void intialize(Vertex[] vertices, int source) {
		// boolean[] visited=new boolean[vertices.length];
		Queue<Vertex> pq = new LinkedList<Vertex>();
		vertices[1] = new Vertex(1, weight[1],1);
		vertices[1].children = findChildren(1, 1);
		pq.add(vertices[1]);
		while (!pq.isEmpty()) {
			Vertex current = pq.remove();
			for (int i: current.children){
		//		System.out.println("intializing "+i);
				vertices[i]=new Vertex(current.id,weight[i],i);
				vertices[i].children=findChildren(i, current.id);
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
					//System.out.println(edges[i][1]);
				}
			} else if (id == edges[i][1]) {
				if (!(edges[i][0] == parent)) {
					children.add(edges[i][0]);
					//System.out.println(edges[i][0]);
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

		public Vertex(int parent, int cost,int id) {
			super();
			this.parent = parent;
		//	this.children = new ArrayList<Integer>();
			this.cost = cost;
			this.tWeight = cost;
			this.id=id;
		}

	}

}

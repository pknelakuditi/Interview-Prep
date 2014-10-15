package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Given a graph ,checking if it is a tree or not

public class BFS {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		if (e + 1 != v) {
			System.out.println("No");
			return;
		} else {
			ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i <= v; i++) {
				graph.add(new ArrayList<Integer>());
			}
			for (int i = 0; i < e; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				graph.get(a).add(b);
				graph.get(b).add(a);
			}

			if (bFS(graph, v)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

	private static boolean bFS(ArrayList<ArrayList<Integer>> graph, int v) {
		boolean[] visited = new boolean[v + 1];
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(1);
		visited[1] = true;

		while (!q.isEmpty()) {
			int temp = q.remove();
			for (int i = 0; i < graph.get(temp).size(); i++) {
				if (!visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}

		for (int i = 1; i <= v; i++) {
			if (!visited[i]) {
				return false;
			}
		}

		return true;
	}

}

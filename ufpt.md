##Breadth First Search : 
-------------------------
using QUEUE :
-----------
```java
q.add(start);
visited[start] = true;
		while (!q.isEmpty()) {
			int temp = q.remove();
			for (int i = 0; i < graph.get(temp).size(); i++) {
				if (!visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}		
``` 		

##Depth First Search
-------------------------
using stack :
-----------
```java
class Main{
public static void dfs(ArrayList<ArrayList<Integer>> graph,int start){
q.add(start);
visited[start] = true;
		while(!s.isEmpty()){
			int temp=s.pop();
			ArrayList<Integer> neighbours=graph.get(temp);
			for(int n:neighbours){
				if(!visited[n]){
					s.add(n);
					visited[n]=true;
				}
			}
			
		}
}

}
```

##Dijkstra's Algorithm 


```java  

public static int dijkstras(Vertex[] graph, int source, int destination) {
        boolean[] visited =new boolean[graph.length];
		Vertex current = graph[source];
		
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		//intially minDistance for each vertex would be Integer.MAXVALUE make start distance as zero
        current.minDistance=0;
		pq.add(current);
		while (!pq.isEmpty()) {
			current = pq.remove();
			if (current.id == destination) {
				break;
			}
			if(visited[current.id]){
				continue;
			}else{
				visited[current.id]=true;
			}
			
			//updating all the unvisited new neighbour values  and insert in pq
			for (Edge e : current.neighbors) {
				if((visited[e.end])){continue;}
				Vertex end = graph[e.end];
				int distance = e.distance;
				int newMin = distance + current.minDistance;
				if (newMin < end.minDistance  ) {
					end.minDistance = newMin;
					pq.add(end);
				}
			}

		}
		return graph[destination].minDistance;		
		
	}
```

##Prim's Algorithm
------------------------
```java
	private static int PrimsAlgorithm(Vertex[] graph, int source) {
		PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
		boolean[] visited=new boolean[graph.length];
	
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
			//adding all the unvisited neoghbours into the priority pq
			for(Edge e:graph[current.edge].neighbors){
				if(visited[e.edge]){
					continue;
				}
				pq.add(e);
				
			}
			
			
		}
		
		
		return cost;
	}
```
##Kruskal's algo : 
comparable on the cost of edge and put it pq and add the edges into MST when only it results in union of two different sets.

taking care of disjoint sets:
```java
public static class DisjointSets {
		int[] parents;

		public DisjointSets(int size) {
			parents = new int[size];
			for (int i = 0; i < size; i++) {
				parents[i] = i;
			}

		}

		public int find(int x) {
			if (parents[x] == x) {
                return x;
			}else{
				parents[x]=find(parents[x]);
				return parents[x];
			}
			
		}
		
		public void union(int x,int y){
			parents[find(x)]=find(y);
		}

	}
```
add all the edges to pq and send it as parameter for function
```java
private static int kruskals(PriorityQueue<Edge> pq, int v) {
		DisjointSets ds=new DisjointSets(v);
		Edge current;
		int components=v;
		int cost=0;
		while(!pq.isEmpty()){
			current=pq.remove();
			if(ds.find(current.edge)==ds.find(current.oEdge)){
				continue;
			}
			components--;
			ds.union(current.edge,current.oEdge);
			cost+=current.cost;
		}
		if(components>1){
			return -1;
		}else{
			return cost;
		}
		
	}
```
##Range Minimum Query (RMQ)
--------------------------
description: on arrays to find the position of an element with the minimum value between two specified indices.

Algo:
 preprocess sqrt(N) segment minimums
 range given then 2 half participated and remaining all full participated segments.
* preprocess: O(N)
* range query : O(sqrt(N))

when update(i,X)
then calculate min for inserted segment O(sqrt(N))

##Least commom ansestor 
-----------------------
desc : can be reduced to a restricted version of an RMQ problem, in which consecutive array elements differ by exactly 1.

preprocessing:O(N)
divide into sqrt(h) height segments make each element in the segment point to the least ancestor in the next height segment.
query:O(log(N))
lca(a,b)
then check the height segment of the nodes and make min of them jump segmnts till it reaches the the other by moving up to its parents similar to previous problem then 

if both parent for next height segment values are same then start moving up the in the same height segment one after another by comparing both of their parents 
else move both pointers to next height segment to their resoectice parents


other algo : write inorder of the tree and find minimum in range of tree index [a,b] . 

try coding it
```java
struct Node *findLCA(struct Node* root, int n1, int n2)
{
   
   if (root == NULL) return NULL; 
   if (root->key == n1 || root->key == n2)
        return root;
    
    Node *left_lca  = findLCA(root->left, n1, n2);
    Node *right_lca = findLCA(root->right, n1, n2);
 
   if (left_lca && right_lca)  return root;
 
     return (left_lca != NULL)? left_lca: right_lca;
}
```

problems:
http://www.spoj.com/problems/LCASQ/
http://www.spoj.com/problems/RMQSQ/
http://www.spoj.com/problems/LCA/


resource:
http://help.topcoder.com/data-science/competing-in-algorithm-challenges/algorithm-tutorials/range-minimum-query-and-lowest-common-ancestor/

##Range Sum Query:
-----------------
a[] =original array
b[] =cumative sum array

get an array which have sum of all the b[i]=b[i-1]+a[i]


* preprocessing : o(N) 
* query: b[j]-b[i-1]  o(1)
* update: o(N)

can be done better by using:
 	**Fenwick tree or binary indexed tree**
 	
```java	
void updateArray(val,index)
{
	while(index<=fenwickArray.length){
		fenwickArray[index] = fenwickArray[index] + val;
		index = index + (index&-index)
}
}
```
 	
http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=binaryIndexedTrees
http://pdf.aminer.org/001/073/976/a_new_data_structure_for_cumulative_frequency_tables.pdf  



TO DO:
-------
basic:

http://www.spoj.com/problems/FCTRL/
http://www.spoj.com/problems/BSEARCH1/
http://www.spoj.com/problems/HANGOVER/
http://www.spoj.com/problems/PALIN/
spoj.com/problems/TEST
spoj.com/problems/ADDREV
spoj.com/problems/PRIME1

http://www.spoj.com/problems/ANARC09C/

for disjoint sets
http://goo.gl/e9h857
http://goo.gl/orqp9H


* suffix tree,suffix array
* segment tree(intialize and use for range minimum query problem 
	result in O(N) prepocessing and O(log(N)) query processing 



finding median in unsorted array :

http://discuss.codechef.com/questions/1489/find-median-in-an-unsorted-array-without-sorting-it

UFPT Mega Dynamic Programming List
---------------------------------------------------------------------
Most straightforward:
http://www.spoj.com/problems/COINS/                                      

More straightforward:
http://www.spoj.com/problems/MBALL                                  
http://www.spoj.com/problems/PARTY                                  
http://www.spoj.com/problems/KNAPSACK/
http://www.spoj.com/problems/MKBUDGET
http://www.spoj.com/problems/PIGBANK
http://www.spoj.com/problems/MMAXPER                                
http://www.spoj.com/problems/SCUBADIV/                             
http://www.spoj.com/problems/MINVEST
http://www.spoj.com/problems/ACODE/     RECOMMENDED                 
http://www.spoj.com/problems/BYTESM2/
http://www.spoj.com/problems/MIXTURES/  RECOMMENDED                                     
http://www.spoj.com/problems/ROCK/                                  
http://www.spoj.com/problems/NY10E/
 
http://www.spoj.com/problems/BABTWR/
http://www.spoj.com/problems/SQRBR/
http://www.spoj.com/problems/TWENDS/
http://www.spoj.com/problems/M3TILE/
http://www.spoj.com/problems/LISA/
http://www.spoj.com/problems/TRT/         NEW
 
Graph DP
http://www.spoj.com/problems/EDIST/                                  
http://www.spoj.com/problems/CSTREET/
http://www.spoj.com/problems/CHICAGO/                               
http://www.spoj.com/problems/ACPC10D/
http://www.spoj.com/problems/DSUBSEQ/
http://www.spoj.com/problems/TAP2013J     NEW
 
 
Mediumish:
http://www.spoj.com/problems/JOCHEF/
http://www.spoj.com/problems/ACMAKER/
http://www.spoj.com/problems/MCOINS/
http://www.spoj.com/problems/CHOCOLA/
http://www.spoj.com/problems/MPILOT
http://www.spoj.com/problems/MENU/
http://www.spoj.com/problems/CRSCNTRY
http://www.spoj.com/problems/MBLAST/
http://www.spoj.com/problems/ANARC07G/
http://www.spoj.com/problems/IKEYB/
http://www.spoj.com/problems/PONY2/       NEW (do ACODE first)
http://www.spoj.com/problems/PONY9/       NEW
 
 
Hard:
http://www.spoj.com/problems/NGON
http://www.spoj.com/problems/MYSTIC/
http://www.spoj.com/problems/MSTRING
http://www.spoj.com/problems/CHOCDIST
http://www.spoj.com/problems/GOSTONES     NEW

Tree:
----------------
spoj.com/problems/PT07Y

spoj.com/problems/TUTBFS
spoj.com/problems/PT07Y
spoj.com/problems/UCV2013H
spoj.com/problems/LABYR1
spoj.com/problems/SHOP
spoj.com/problems/BYTESE1
spoj.com/problems/BITMAP
spoj.com/problems/PT07Z


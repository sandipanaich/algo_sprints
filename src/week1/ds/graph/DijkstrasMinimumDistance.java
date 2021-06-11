/**
 * Dijkstrs Minimum Distance Algorithm Implementation.
 * Space Complexity: O(V + E)
 * Running Time Complexity: O((V + E)logV)
 */
package week1.ds.graph;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import week1.ds.graph.Graph.Edge;

/**
 * @author Sandipan Aich
 */
public class DijkstrasMinimumDistance {

	public static void minimumDistance(Graph graph, int source) {

		int size = graph.size();
		List<Edge>[] adj = graph.adj;

		int[] previous = new int[size];
		previous[source] = -1;

		int[] distance = new int[size];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;

		boolean[] visited = new boolean[size];
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((u, v) -> distance[u] - distance[v]);
		pq.add(source);

		while (!pq.isEmpty()) { // O(V)
			int u = pq.remove(); // O(log V)
			visited[u] = true;
			
			for(Edge edge : adj[u])//O(E), including the previous for loop.
			{
				int v = edge.v;
				int w = edge.w;

				if(!visited[v] && distance[v] > distance[u] + w) 
				{
					distance[v] = distance[u] + w;
					previous[v] = u;
					
					// This is a hack due to the way Java Priority Queues are implemented. Sadly, its 0(log(N))
					// Ideally, one should have an Min Heap implementation that perform heapify operation
					// on the node that is updated.
					pq.remove(v);
					pq.add(v);
				}
			}
		}
		
		for(int i = 0; i < size; i++)
			System.out.println(i + " :: previous:" + previous[i] + " :: distance:" + distance[i]);
	}

	public static void main(String[] args) {
		
		Graph graph = new Graph(4);
		graph.addEdge(0, 1, 6);
		graph.addEdge(0, 2, 2);
		graph.addEdge(0, 3, 10);
		graph.addEdge(2, 3, 5);
		
		minimumDistance(graph, 0);
	}

}

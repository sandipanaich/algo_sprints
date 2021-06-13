/**
 * Prims Minimum Spanning Tree Algorithm Implementation.
 * Running Time Complexity: O(ElogV)
 */
package week1.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import week1.ds.graph.Graph.Edge;

/**
 * @author Sandipan Aich
 */
public class PrimsMST {

	public static final List<Edge> mst(Graph graph) {

		int source = 0;
		int size = graph.size();
		
		int[] distance = new int[size];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;

		int[] previous = new int[size];
		distance[source] = source;

		Set<Integer> set = new HashSet<>();
		set.add(source);
		
		List<Edge> tree = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> distance[i]));

		for (int u = 0; u < size; u++)
			pq.add(u);

		while (!pq.isEmpty()) {

			int u = pq.poll();

			if (!set.contains(u))
			{
				tree.add(new Edge(previous[u], u, distance[u]));
				set.add(u);
			}

			for (Edge edge : graph.adj[u]) {
				int v = edge.v;

				if (distance[v] > edge.w) {
					distance[v] = edge.w;
					previous[v] = u;

					// This is a hack due to the way Java Priority Queues are implemented. Sadly, its 0(log(N))
					// Ideally, one should have an Min Heap implementation that perform heapify
					// operation
					// on the node that is updated.
					pq.remove(v);
					pq.add(v);
				}
			}
		}
		return tree;
	}

	public static void main(String[] args) {
		int size = 9;
		Graph graph = new Graph(size);

		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 7, 8);
		graph.addEdge(1, 2, 8);
		graph.addEdge(1, 7, 11);
		graph.addEdge(2, 3, 7);
		graph.addEdge(2, 5, 4);
		graph.addEdge(2, 8, 2);
		graph.addEdge(3, 4, 9);
		graph.addEdge(3, 5, 14);
		graph.addEdge(4, 5, 10);
		graph.addEdge(5, 6, 2);
		graph.addEdge(6, 8, 6);
		graph.addEdge(6, 7, 1);
		graph.addEdge(7, 8, 7);

		for (Edge edge : mst(graph))
			System.out.println(edge);
	}

}

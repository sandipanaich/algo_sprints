/**
 * Simple Graph Implementation.
 * Space Complexity: O(V)
 * Running Time Complexity: O(V + E)
 */
package week1.ds.graph;

import java.util.Arrays;
import java.util.List;

import week1.ds.graph.Graph.Edge;

/**
 * @author Sandipan Aich
 */
public class TopologicalSort {

	public static final int[] sort(Graph graph) {

		int size = graph.size();
		int index = size - 1;

		int[] inorder = inorder(graph);
		int[] topological = new int[size];
		boolean[] visited = new boolean[size];

		for (int u = 0; u < size; u++) {

			if (inorder[u] == 0) {
				index = explore(graph.adj, u, index, topological, visited);
			}
		}
		return topological;
	}

	private static int explore(List<Edge>[] adj, int u, int index, int[] topological, boolean[] visited) {

		visited[u] = true;

		for (Edge edge : adj[u]) {
			int v = edge.v;
			if (!visited[v])
				index = explore(adj, v, index, topological, visited);
		}

		topological[index] = u;
		index--;
		return index;
	}

	private static final int[] inorder(Graph graph) {
		int size = graph.size();
		int[] inorder = new int[size];

		for (int u = 0; u < size; u++) {
			for (Edge edge : graph.adj[u]) {
				inorder[edge.v]++;
			}
		}
		return inorder;
	}

	public static void main(String[] args) {

		Graph graph = new Graph(6, false);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(5, 0);
		graph.addEdge(5, 2);

		int[] topological = sort(graph);
		System.out.println(Arrays.toString(topological));

	}

}

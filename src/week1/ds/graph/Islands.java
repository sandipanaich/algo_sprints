/**
 * To see if than undirected graph has island, or whether the graph is a forest.
 * Time Complexity: O(V + E)
 */
package week1.ds.graph;

import java.util.function.Consumer;

/**
 * @author Sandipan Aich
 */
public class Islands {

	public static final int forests(Graph graph) {

		int count = 0;
		int size = graph.size();
		boolean[] visited = new boolean[size];

		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				graph.exploreByBFS(i, visited, donothing());
				count++;
			}
		}
		return count;
	}

	public static final boolean isForest(Graph graph) {
		return forests(graph) != 1;
	}

	private static Consumer<Integer> donothing() {
		return nothing -> {
		};
	}

	public static void main(String[] args) {
		
		Graph undirected = new Graph(10);

		undirected.addEdge(7, 8);
		undirected.addEdge(8, 9);
		undirected.addEdge(9, 7);

		
		undirected.addEdge(0, 1);
		undirected.addEdge(0, 6);
		undirected.addEdge(1, 2);
		undirected.addEdge(1, 5);
		undirected.addEdge(2, 6);
		undirected.addEdge(2, 4);
		undirected.addEdge(2, 3);
		undirected.addEdge(3, 5);
		undirected.addEdge(3, 4);
		undirected.addEdge(4, 2);
		undirected.addEdge(4, 5);
		undirected.addEdge(5, 6);
		
		System.out.println(isForest(undirected));
		System.out.println(forests(undirected));

	}

}

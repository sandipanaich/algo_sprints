/**
 * To see if than undirected graph has island, or whether the graph is a forest.
 * Time Complexity: O(V + E)
 */
package week2.ds.graph;

import java.util.function.Consumer;

/**
 * @author Sandipan Aich
 */
public class Islands {

	private static int forests(Graph undirected) {

		int size = undirected.size();
		boolean[] visited = new boolean[size];
		int count = 0;

		for (int u = 0; u < size; u++) {
			
			if(!visited[u])
			{
				count++;
				undirected.exploreBFS(u, visited, doNothing());
			}
		}
		return count;
	}

	private static <T> Consumer<T> doNothing() {

		return e -> {
		};
	}

	private static boolean isForest(Graph undirected) {
		return forests(undirected) > 1;
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

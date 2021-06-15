/**
 * Simple Graph Implementation.
 * Space Complexity: O(V + E)
 * BFS Running Time Complexity: O(V + E)
 * DFS Running Time Complexity: O(V + E)
 */
package week2.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

/**
 * @author Sandipan Aich
 */
public class Graph {

	public Graph(int size) {
	}

	@SuppressWarnings("unchecked")
	public Graph(int size, boolean undirected) {

	}

	public void addEdge(int u, int v) {
	}

	public void addEdge(int u, int v, int w) {
	}

	public static void main(String[] args) {

		Graph undirected = new Graph(7);

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

		List<Integer> undirecteddfs = new ArrayList<>();
//		undirected.dfs(undirecteddfs::add);
		System.out.println();
		List<Integer> undirectedbfs = new ArrayList<>();
//		undirected.bfs(undirectedbfs::add);
		System.out.println();

		System.out.println("=========");
		System.out.println("=========");

		Graph directed = new Graph(7, false);

		directed.addEdge(0, 1);
		directed.addEdge(0, 6);
		directed.addEdge(1, 2);
		directed.addEdge(1, 5);
		directed.addEdge(2, 4);
		directed.addEdge(3, 2);
		directed.addEdge(3, 5);
		directed.addEdge(3, 4);
		directed.addEdge(5, 4);
		directed.addEdge(5, 6);
		directed.addEdge(6, 2);

		List<Integer> directeddfs = new ArrayList<>();
//		directed.dfs(directeddfs::add);
		System.out.println();
		List<Integer> directedbfs = new ArrayList<>();
//		directed.bfs(directedbfs::add);
		System.out.println();
		
		System.out.println(Arrays.toString(directedbfs.toArray()));
		System.out.println(Arrays.toString(directeddfs.toArray()));
		System.out.println(Arrays.toString(undirectedbfs.toArray()));
		System.out.println(Arrays.toString(undirecteddfs.toArray()));

	}
}

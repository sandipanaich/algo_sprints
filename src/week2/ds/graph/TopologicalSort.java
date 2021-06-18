package week2.ds.graph;

import java.util.Arrays;
import java.util.List;

import week2.ds.graph.Graph.Edge;

public class TopologicalSort {

	private static int[] sort(Graph graph) {

		int size = graph.size();
		int last = size - 1;

		boolean[] visited = new boolean[size];
		int[] topological = new int[size];
		List<Edge>[] adj = graph.adj;

		int[] inorder = inorder(adj);
		
		for (int u = 0; u < size; u++) {
			
			if(inorder[u] == 0)
				last = sort(u, adj, visited, topological, last);
		}

		return topological;
	}

	private static int sort(int node, List<Edge>[] adj, boolean[] visited, int[] topological, int last) {

		if (visited[node])
			return last;
		visited[node] = true;
		
		for(Edge edge : adj[node])
		{
			int v= edge.v;
			if(!visited[v])
				last = sort(v, adj, visited, topological, last);
		}

		topological[last] = node;
		
		return last - 1;
	}
	
	private static int[] inorder(List<Edge>[] adj)
	{
		int size = adj.length;
		int[] inorder = new int[size];
		
		for(int u = 0 ; u < size; u++)
		{
			for(Edge edge : adj[u])
			{
				int v = edge.v;
				inorder[v]++;
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

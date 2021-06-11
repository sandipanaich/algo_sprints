/**
 * Bellman Ford Minimum Distance Algorithm Implementation.
 * Space Complexity: O(V + E)
 * Running Time Complexity: O(V.E)
 */
package week1.ds.graph;

/**
 * @author Sandipan Aich
 */
import java.util.Arrays;
import java.util.List;

import week1.ds.graph.Graph.Edge;

public class BellmanFord {

	public static final int[] minimumDistance(Graph graph, int source)
	{
		List<Edge>[] adj = graph.adj;
		int size = adj.length;
		
		int[] previous = new int[size];
		previous[source] = source;
		
		int[] distance = new int[size];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;
		
		for(int i = 0; i < size; i++)
		{
			for(int u = 0 ; u < size; u++)
			{
				for(Edge edge : adj[u])
				{
					int v = edge.v;
					int w = edge.w;
					
					if(distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + w)
					{
						distance[v] = distance[u] + w;
						previous[v] = u;
						
						if(i == size-1)
							System.out.println("The Graph has a negative cycle");
					}
				}
			}
		}
		return distance;
	}
	
	public static void main(String[] args) {
		
		int size = 5;
		
		Graph graph = new Graph(size, false);

		graph.addEdge(0, 1, -1);
		graph.addEdge(0, 2, 4);
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 3, 2);
		graph.addEdge(1, 4, 2);
		graph.addEdge(3, 1, 1);
		graph.addEdge(3, 2, 5);
		graph.addEdge(4, 3, -3);
		
		System.out.println(Arrays.toString(minimumDistance(graph, 0)));
	}

}

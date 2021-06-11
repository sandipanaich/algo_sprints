/**
 * Kruskals Minimum Spanning Tree Algorithm Implementation.
 * Running Time Complexity: O(ElogV)
 */
package week1.ds.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import week1.ds.graph.Graph.Edge;
import week1.ds.unionfind.UnionFind;
import week1.ds.unionfind.WeightedUnionFind;

/**
 * @author Sandipan Aich
 */
public class KruskalsMST {

	public static final List<Edge> mst(Graph graph) {

		int size = graph.size();
		
		UnionFind uf = new WeightedUnionFind(size);

		List<Edge> mst = new ArrayList<>();
		List<Edge> edges = edges(graph);
		Collections.sort(edges, Comparator.comparingInt(e -> e.w));

		for(Edge edge : edges)
		{
			int u = edge.u;
			int v = edge.v;
			
			if(!uf.connected(u, v))
			{
				uf.union(u, v);
				mst.add(edge);
			}
		}
		return mst;
	}

	private static final List<Edge> edges(Graph graph) {

		List<Edge> edgeList = new ArrayList<Edge>();
		final int size = graph.size();

		for (int u = 0; u < size; u++) {
			for (Edge edge : graph.adj[u]) {
				edgeList.add(edge);
			}
		}
		return edgeList;
	}

	public static void main(String[] args) {
		int size = 9;
		Graph graph = new Graph(size);
		
		graph.addEdge(0,1,4);
		graph.addEdge(0,7,8);
		graph.addEdge(1,2,8);
		graph.addEdge(1,7,11);
		graph.addEdge(2,3,7);
		graph.addEdge(2,5,4);
		graph.addEdge(2,8,2);
		graph.addEdge(3,4,9);
		graph.addEdge(3,5,14);
		graph.addEdge(4,5,10);
		graph.addEdge(5,6,2);
		graph.addEdge(6,8,6);
		graph.addEdge(6,7,1);
		graph.addEdge(7,8,7);
		
		for(Edge edge : mst(graph))
			System.out.println(edge);
	}

}

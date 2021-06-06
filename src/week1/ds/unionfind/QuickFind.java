/**
 * Quick Find Implementation of Union Find.
 * Initialization: O(n)
 * Find: 0(1)
 * Union: O(n)
 */
package week1.ds.unionfind;

/**
 * @author Sandipan Aich
 */
public class QuickFind {

	private int[] parent;
	private int size;

	public QuickFind(int size) {
		this.size = size;
		this.parent = new int[size];

		for (int i = 0; i < size; i++)
			parent[i] = i;
	}

	public boolean connected(int u, int v) {
		return parent[u] == parent[v];
	}

	public void union(int u, int v) {
		if (connected(u, v))
			return;

		for (int i = 0; i < size; i++) {
			if (parent[i] != parent[u])
				parent[i] = parent[v];
		}
	}

	public static void main(String[] args) {
	}

}

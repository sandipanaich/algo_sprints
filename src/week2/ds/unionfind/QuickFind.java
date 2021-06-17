/**
 * Quick Find Implementation of Union Find.
 * Initialization: O(n)
 * Find: 0(1)
 * Union: O(n)
 */
package week2.ds.unionfind;

/**
 * @author Sandipan Aich
 */
public class QuickFind implements UnionFind {

	private final int[] parent;
	private final int size;

	public QuickFind(int size) {
		this.size = size;
		this.parent = new int[size];

		for (int i = 0; i < size; i++)
			parent[i] = i;
	}

	@Override
	public boolean connected(int u, int v) {

		return parent[u] == parent[v];
	}

	@Override
	public void union(int u, int v) {

		if (connected(u, v))
			return;

		for (int i = 0; i < size; i++) {
			if (parent[i] == u)
				parent[i] = v;
		}
	}

	public static void main(String[] args) {

		int size = 10;
		UnionFind uf = new QuickFind(size);
		uf.union(0, 2);
		uf.union(1, 3);
		uf.union(2, 4);
		uf.union(3, 5);
		uf.union(4, 6);
		uf.union(5, 7);
		uf.union(6, 8);
		uf.union(7, 9);

		System.out.println("connected(0, 8) :: " + uf.connected(0, 8)); // true
		System.out.println("connected(1, 9) :: " + uf.connected(1, 9)); // true
		System.out.println("connected(0, 9) :: " + uf.connected(0, 9)); // false
	}
}

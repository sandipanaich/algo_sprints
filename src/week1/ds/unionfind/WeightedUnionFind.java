/**
 * Weighted Union Find Implementation of Union Find.
 * Initialization: O(n)
 * Find: 0(log(n))
 * Union: O(log(n))
 */
package week1.ds.unionfind;

/**
 * @author Sandipan Aich
 */
public class WeightedUnionFind implements UnionFind {

	private int size;
	private int[] parent;
	private int[] weights;

	public WeightedUnionFind(int size) {
		this.size = size;
		this.parent = new int[size];
		this.weights = new int[size];

		for (int i = 0; i < size; i++) {
			parent[i] = i;
			weights[i] = 1;
		}
	}

	private int root(int u) {
		while (u != parent[u])
			u = parent[u];
		return u;
	}

	public boolean connected(int u, int v) {
		return root(u) == root(v);
	}

	public void union(int u, int v) {
		if (!connected(u, v)) {
			int parent_u = root(u);
			int parent_v = root(v);

			if (weights[parent_u] < weights[parent_v]) {
				parent[parent_u] = parent[parent_v];
				weights[parent_v] += weights[parent_u];
			} else {
				parent[parent_v] = parent[parent_u];
				weights[parent_u] += weights[parent_v];
			}
		}
	}

	public int getSize() {
		return size;
	}

	public static void main(String[] args) {
		int size = 10;

		UnionFind uf = new WeightedUnionFind(size);

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

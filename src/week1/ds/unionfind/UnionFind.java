package week1.ds.unionfind;

public interface UnionFind {

	boolean connected(int u, int v);
	void union(int u, int v);
}

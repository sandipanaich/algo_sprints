/**
 * The Union Find Interface.
 */
package week1.ds.unionfind;

/**
 * @author Sandipan Aich
 */
public interface UnionFind {

	boolean connected(int u, int v);
	void union(int u, int v);
}

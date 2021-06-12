/**
 * Node implementation for a Binary Tree.
 */
package week1.ds.tree;

/**
 * @author Sandipan Aich
 */
public class Node<K, V> {

	private K key;
	private V value;
	private Node<K, V> left;
	private Node<K, V> right;

	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K key() {
		return key;
	}

	public void key(K key) {
		this.key = key;
	}

	public V value() {
		return value;
	}

	public void value(V value) {
		this.value = value;
	}

	public Node<K, V> left() {
		return left;
	}

	public void left(Node<K, V> left) {
		this.left = left;
	}

	public Node<K, V> right() {
		return right;
	}

	public void right(Node<K, V> right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", value=" + value + "]";
	}
}

/**
 * Node of a Tree Data Structure.
 */
package week3.ds.tree;

public class Node<T> {

	private T value;
	private Node<T> left;
	private Node<T> right;

	public Node(T value) {
		super();
		this.value = value;
	}

	public T value() {
		return value;
	}

	public void value(T value) {
		this.value = value;
	}

	public Node<T> left() {
		return left;
	}

	public Node<T> left(Node<T> left) {
		return this.left = left;
	}

	public Node<T> right() {
		return right;
	}

	public Node<T> right(Node<T> right) {
		return this.right = right;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

}

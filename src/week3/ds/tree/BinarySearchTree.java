/**
 * Binary Search Tree Implementation.
 */
package week3.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

	public Node<T> root;

	public final BinarySearchTree<T> add(T data) {

		Node<T> node = new Node<T>(data);

		Node<T> parentNode = null;
		Node<T> treeNode = root;

		while (treeNode != null) {
			parentNode = treeNode;
			if (data.compareTo(treeNode.value()) < 0)
				treeNode = treeNode.left();
			else
				treeNode = treeNode.right();
		}

		if (parentNode == null)
			root = node;
		else if (data.compareTo(parentNode.value()) < 0)
			parentNode.left(node);
		else
			parentNode.right(node);

		return this;
	}

	// ------------------------------------------------------------------------------------------------
	public final List<Node<T>> postOrderTraversal() {

		List<Node<T>> traversalList = new ArrayList<>();

		Node<T> node = root;
		postOrder(node, traversalList);
		return traversalList;
	}

	private final void postOrder(Node<T> node, List<Node<T>> traversalList) {

		if (node == null)
			return;

		postOrder(node.left(), traversalList);
		postOrder(node.right(), traversalList);
		traversalList.add(node);
	}

	// ------------------------------------------------------------------------------------------------
	public final List<Node<T>> preOrderTraversal() {

		List<Node<T>> traversalList = new ArrayList<>();

		Node<T> node = root;
		preOrder(node, traversalList);
		return traversalList;
	}

	private final void preOrder(Node<T> node, List<Node<T>> traversalList) {

		if (node == null)
			return;

		traversalList.add(node);
		preOrder(node.left(), traversalList);
		preOrder(node.right(), traversalList);
	}

	// ------------------------------------------------------------------------------------------------
	public final List<Node<T>> inorderTraversal() {

		List<Node<T>> traversalList = new ArrayList<>();

		Node<T> node = root;
		inorder(node, traversalList);
		return traversalList;
	}

	private final void inorder(Node<T> node, List<Node<T>> traversalList) {

		if (node == null)
			return;

		inorder(node.left(), traversalList);
		traversalList.add(node);
		inorder(node.right(), traversalList);
	}

	// ------------------------------------------------------------------------------------------------
	public final List<Node<T>> levelOrderTraversal() {
		List<Node<T>> traversalList = new ArrayList<>();
		Queue<Node<T>> queue = new LinkedList<>();

		if (root != null)
			queue.add(root);

		while (!queue.isEmpty()) {
			Node<T> node = queue.remove();
			traversalList.add(node);

			if (node.left() != null)
				queue.add(node.left());
			if (node.right() != null)
				queue.add(node.right());
		}
		return traversalList;
	}

//------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();

		tree.add(100).add(50).add(150).add(25).add(75).add(125).add(175).add(200);
		tree.levelOrderTraversal().stream().forEach(a -> System.out.print(a + " "));
		System.out.println();
		tree.preOrderTraversal().stream().forEach(a -> System.out.print(a + " "));
		System.out.println();
		tree.postOrderTraversal().stream().forEach(a -> System.out.print(a + " "));
		System.out.println();
		tree.inorderTraversal().stream().forEach(a -> System.out.print(a + " "));
	}
}

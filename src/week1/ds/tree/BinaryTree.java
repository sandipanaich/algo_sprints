/**
 * A Simple/Basic implementation of a Binary Tree.
 * 
 * Add :: O(n)
 * Delete :: O(n)
 * Update :: O(n)
 * Retrieve :: O(n)
 * Traversal :: O(n)
 */
package week1.ds.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sandipan Aich
 */
public class BinaryTree<K, V> {

	private Node<K, V> root;
	private int size;

	public void add(K key, V value) {

		if (root == null) {
			root = new Node<K, V>(key, value);
			size++;
			return;
		}

		Queue<Node<K, V>> queue = new LinkedList<Node<K, V>>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node<K, V> node = queue.poll();
			if (node.left() == null) {
				node.left(new Node<K, V>(key, value));
				break;
			} else if (node.right() == null) {
				node.right(new Node<K, V>(key, value));
				break;
			} else {
				queue.add(node.left());
				queue.add(node.right());
			}
		}
		size++;
	}

	public V remove(K key) {

		if (root == null || key == null)
			return null;

		Queue<Node<K, V>> queue = new LinkedList<>();
		queue.offer(root);

		Node<K, V> toRemove = null;
		Node<K, V> parent = null;
		Node<K, V> lastParent = root;

		while (!queue.isEmpty()) {
			Node<K, V> node = queue.poll();

			if (node.key().equals(key))
				toRemove = node;
			if (node.left() != null && node.left().key().equals(key))
				parent = node;
			if (node.right() != null && node.right().key().equals(key))
				parent = node;
			if (node.left() != null || node.right() != null) {
				if (node.left() != null)
					queue.add(node.left());
				if (node.right() != null)
					queue.add(node.right());
				lastParent = node;
			}
		}

		V value = null;
		if (toRemove != null) {
			value = toRemove.value();
			if (lastParent.right() != null) 
			{
				toRemove.key(lastParent.right().key());
				toRemove.value(lastParent.right().value());
				lastParent.right(null);
			} 
			else if (lastParent.left() != null) 
			{
				toRemove.key(lastParent.left().key());
				toRemove.value(lastParent.left().value());
				lastParent.left(null);
			} 
			else 
			{
				root = null;
			}
			System.out.println(toRemove + " :: " + parent + " :: " + lastParent);
			size--;
		}
		return value;
	}

	public void update(K key, V value) {
		if (root == null || key == null)
			return;

		Queue<Node<K, V>> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node<K, V> node = queue.poll();
			if (node.key().equals(key)) {
				node.value(value);
				return;
			}
			if (node.left() != null)
				queue.offer(node.left());
			if (node.right() != null)
				queue.offer(node.right());
		}
	}

	public V get(K key) {

		if (root == null || key == null)
			return null;

		Queue<Node<K, V>> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node<K, V> node = queue.poll();

			if (node.key().equals(key))
				return node.value();
			if (node.left() != null)
				queue.add(node.left());
			if (node.right() != null)
				queue.add(node.right());
		}
		return null;
	}

	public Node<K, V>[] traverse() {
		if (root == null)
			return null;

		Queue<Node<K, V>> queue = new LinkedList<>();
		queue.add(root);
		@SuppressWarnings("unchecked")
		Node<K, V>[] array = (Node<K, V>[]) new Node[size];

		for (int i = 0; !queue.isEmpty(); i++) {
			Node<K, V> node = array[i] = queue.poll();
			if (node.left() != null)
				queue.add(node.left());
			if (node.right() != null)
				queue.add(node.right());
		}
		return array;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		BinaryTree<String, Integer> tree = new BinaryTree<String, Integer>();
		tree.add("A", 1);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.add("B", 2);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.add("C", 3);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.add("D", 4);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.add("E", 5);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.add("F", 6);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.add("G", 7);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.add("H", 8);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.add("I", 9);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.add("J", 10);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));

		System.out.println("========================================================================================");

		tree.update("A", 10);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.update("B", 20);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.update("C", 30);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.update("D", 40);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.update("E", 50);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.update("F", 60);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.update("G", 70);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.update("H", 80);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.update("I", 90);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.update("J", 100);
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));

		System.out.println("========================================================================================");

		System.out.println("Get A :: " + tree.get("A"));
		System.out.println("Get B :: " + tree.get("B"));
		System.out.println("Get C :: " + tree.get("C"));
		System.out.println("Get D :: " + tree.get("D"));
		System.out.println("Get E :: " + tree.get("E"));
		System.out.println("Get F :: " + tree.get("F"));
		System.out.println("Get G :: " + tree.get("G"));
		System.out.println("Get H :: " + tree.get("H"));
		System.out.println("Get I :: " + tree.get("I"));
		System.out.println("Get J :: " + tree.get("J"));

		System.out.println("========================================================================================");

		tree.remove("A");
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.remove("B");
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.remove("C");
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.remove("D");
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.remove("E");
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.remove("F");
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.remove("G");
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.remove("H");
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.remove("I");
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));
		tree.remove("J");
		System.out.println("Size :: " + tree.size() + " :: Traversal :: " + Arrays.toString(tree.traverse()));

	}
}

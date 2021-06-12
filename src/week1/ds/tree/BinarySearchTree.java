/**
 * An implementation of a Binary Search Tree.
 * 
 * Add :: O(log(n))
 * Delete :: O(log(n))
 * Update :: O(log(n))
 * Retrieve :: O(log(n))
 * Traversal :: O(n)
 */
package week1.ds.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sandipan Aich
 */
public class BinarySearchTree<K extends Comparable<K>, V> {

	private Node<K, V> root;
	private int size;

	public V get(K key) {
		if (key == null)
			return null;

		Node<K, V> node = root;

		while (node != null) {

			if (node.key().equals(key)) {
				return node.value();
			}

			if (less(node.key(), key))
				node = node.right();
			else
				node = node.left();
		}
		return null;
	}

	public void add(K key, V value) {
		if (key == null)
			return;

		if (root == null) {
			root = new Node<K, V>(key, value);
			size++;
			return;
		}

		Node<K, V> node = root;

		while (true) {
			if (node.key().equals(key)) {
				node.value(value);
				return;
			} else if (less(node.key(), key)) {
				if (node.right() == null) {
					node.right(new Node<K, V>(key, value));
					size++;
					return;
				} else
					node = node.right();
			} else {
				if (node.left() == null) {
					node.left(new Node<K, V>(key, value));
					size++;
					return;
				} else
					node = node.left();
			}
		}
	}

	public int size() {
		return size;
	}

	public Node<K, V>[] traverse() {
		
		@SuppressWarnings("unchecked")
		Node<K, V>[] array = (Node<K, V>[]) new Node[size()];

		Queue<Node<K, V>> queue = new LinkedList<>();
		queue.add(root);

		for (int i = 0; !queue.isEmpty(); i++) {

			Node<K, V> node = array[i] = queue.remove();

			if (node.left() != null)
				queue.add(node.left());
			if (node.right() != null)
				queue.add(node.right());
		}
		return array;
	}

	public V removeNode(K key) 
	{
		V value = remove(key);
		if(value != null)
			size--;
		return value;
	}

	public V remove(K key) {
		
		if (root == null || key == null)
			return null;

		Node<K, V> parent = null;
		Node<K, V> current = root;

		while (current != null && current.key() != key) {
			parent = current;
			if (less(current.key(), key))
				current = current.right();
			else
				current = current.left();
		}

		if (current == null)
			return null;
		
//		if(parent == null)
//		{
//			root = null;
//			return current.value();
//		}
		
		if(isLeaf(current))
		{
			if(parent != null)
			{
				if(parent.left() != null && parent.left().key().equals(key))
					parent.left(null);
				else
					parent.right(null);
			}
			else
			{
				root = null;
			}
			return current.value();
		}
		else if(current.left() != null && current.right() != null)
		{
			Node<K, V> next = findMin(current.right());
			V currentValue = current.value();

			K nextKey = next.key();
			V nextValue = next.value();

			remove(next.key());

			current.key(nextKey);
			current.value(nextValue);
			return currentValue;
		}
		else
		{
			if(parent == null)
				parent = root;
			
			if(parent.left() != null && parent.left().key().equals(key))
				parent.left(current.left() != null ? current.left() : current.right());
			else if (parent.right() != null)
				parent.right(current.left() != null ? current.left() : current.right());
			return current.value();
		}
	}

	private Node<K, V> findMin(Node<K, V> node)
	{
		while(node.left() != null)
			node = node.left();
		
		return node;
	}
	
	private boolean isLeaf(Node<K, V> node) {
		return node.left() == null && node.right() == null;
	}

	private boolean less(K key1, K key2) {
		return key1.compareTo(key2) < 0;
	}

	public static void main(String[] args) {

		BinarySearchTree<String, Integer> tree = new BinarySearchTree<String, Integer>();

		tree.add("E", 5);
		System.out.println("Size :: " + tree.size() + " :: " + Arrays.toString(tree.traverse()));
		tree.add("C", 3);
		System.out.println("Size :: " + tree.size() + " :: " + Arrays.toString(tree.traverse()));
		tree.add("B", 2);
		System.out.println("Size :: " + tree.size() + " :: " + Arrays.toString(tree.traverse()));
		tree.add("D", 4);
		System.out.println("Size :: " + tree.size() + " :: " + Arrays.toString(tree.traverse()));
		tree.add("A", 1);
		System.out.println("Size :: " + tree.size() + " :: " + Arrays.toString(tree.traverse()));

		tree.add("H", 8);
		System.out.println("Size :: " + tree.size() + " :: " + Arrays.toString(tree.traverse()));
		tree.add("F", 6);
		System.out.println("Size :: " + tree.size() + " :: " + Arrays.toString(tree.traverse()));
		tree.add("J", 10);
		System.out.println("Size :: " + tree.size() + " :: " + Arrays.toString(tree.traverse()));
		tree.add("G", 7);
		System.out.println("Size :: " + tree.size() + " :: " + Arrays.toString(tree.traverse()));
		tree.add("I", 9);
		System.out.println("Size :: " + tree.size() + " :: " + Arrays.toString(tree.traverse()));

		System.out.println("======================================================================");

		System.out.println("Size :: " + tree.size() + " get A :: " + tree.get("A"));
		System.out.println("Size :: " + tree.size() + " get B :: " + tree.get("B"));
		System.out.println("Size :: " + tree.size() + " get C :: " + tree.get("C"));
		System.out.println("Size :: " + tree.size() + " get D :: " + tree.get("D"));
		System.out.println("Size :: " + tree.size() + " get E :: " + tree.get("E"));
		System.out.println("Size :: " + tree.size() + " get F :: " + tree.get("F"));
		System.out.println("Size :: " + tree.size() + " get G :: " + tree.get("G"));
		System.out.println("Size :: " + tree.size() + " get H :: " + tree.get("H"));
		System.out.println("Size :: " + tree.size() + " get I :: " + tree.get("I"));
		System.out.println("Size :: " + tree.size() + " get J :: " + tree.get("J"));
		System.out.println("======================================================================");

		
		System.out.println("Size :: " + tree.size() +" remove A :: " + tree.removeNode("A"));
		System.out.println("Size :: " + tree.size() +" remove B :: " + tree.removeNode("B"));
		System.out.println("Size :: " + tree.size() +" remove C :: " + tree.removeNode("C"));
		System.out.println("Size :: " + tree.size() +" remove D :: " + tree.removeNode("D"));
		System.out.println("Size :: " + tree.size() +" remove E :: " + tree.removeNode("E"));
		System.out.println("Size :: " + tree.size() +" remove F :: " + tree.removeNode("F"));
		System.out.println("Size :: " + tree.size() +" remove G :: " + tree.removeNode("G"));
		System.out.println("Size :: " + tree.size() +" remove H :: " + tree.removeNode("H"));
		System.out.println("Size :: " + tree.size() +" remove I :: " + tree.removeNode("I"));
		System.out.println("Size :: " + tree.size() +" remove J :: " + tree.removeNode("J"));
		System.out.println("Size :: " + tree.size());

	}

}

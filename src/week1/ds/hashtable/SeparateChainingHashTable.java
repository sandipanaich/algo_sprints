/**
 * HashTable Implementation using Separate Chaining.
 * 
 * get O(1)
 * put O(1)
 * remove O(1)
 * traverse O(n)
 */
package week1.ds.hashtable;

import java.util.function.Consumer;

/**
 * @author Sandipan Aich
 */
public class SeparateChainingHashTable<K, V> implements HashTable<K, V> {

	int size;
	int length;
	private Node<K, V>[] data;
	private static final int DEFAULT_LENGTH = 4;

	public SeparateChainingHashTable() {
		this(DEFAULT_LENGTH);
	}

	@SuppressWarnings("unchecked")
	public SeparateChainingHashTable(int size) {
		this.size = 0;
		this.length = DEFAULT_LENGTH;
		this.data = (Node<K, V>[]) new Node[length];
	}

	@Override
	public V get(K key) {

		int index = hash(key);
		Node<K, V> node = data[index];

		while (node != null) {
			if (node.key.equals(key))
				return node.value;
		}
		return null;
	}

	@Override
	public V remove(K key) {

		int index = hash(key);

		Node<K, V> prev = null;
		Node<K, V> node = data[index];

		while (node != null) {

			if (node.key.equals(key)) {

				if (prev == null)
					data[index] = node.next;
				else
					prev.next = node.next;
				size--;
				
				return node.value;
			}
			prev = node;
			node = node.next;
		}
		return null;
	}

	@Override
	public void put(K key, V value) {

		int index = hash(key);

		Node<K, V> prev = null;
		Node<K, V> node = data[index];

		if (node == null)
			data[index] = new Node<>(key, value);

		while (node != null) {
			if (node.key.equals(key)) {
				node.value = value;
				return;
			}
			prev = node;
			node = node.next;
		}

		if (prev == null)
			data[index] = new Node<>(key, value);
		else
			prev.next = new Node<>(key, value);
		size++;
	}

	@Override
	public boolean isFull() {

		return false;
	}

	@Override
	public boolean isEmpty() {

		return size == 0;
	}

	@Override
	public void traverse() {
		traverse(System.out::println);
	}

	@Override
	public void traverse(Consumer<Node<K, V>> consumer) {
		for (Node<K, V> node : data) {
			while (node != null) {
				consumer.accept(node);
				node = node.next;
			}
		}
	}

	@Override
	public int size() {
		return size;
	}

	private int hash(K key) {
		int hash = key.hashCode() & 0x7FFFFFFF;
		hash %= length;
		return hash;
	}

	public static void main(String[] args) {
		int size = 6;
		String[] keys = new String[] { "A", "B", "C", "D", "E", "F" };
		Integer values[] = new Integer[] { 1, 2, 3, 4, 5, 6 };

		SeparateChainingHashTable<String, Integer> map = new SeparateChainingHashTable<String, Integer>();

		for (int i = 0; i < size; i++) {
			map.put(keys[i], values[i]);
		}

		int i = 0;
		while (!map.isEmpty()) {
			System.out.println(map.remove(keys[i++]));
		}
		map.traverse();
	}
}

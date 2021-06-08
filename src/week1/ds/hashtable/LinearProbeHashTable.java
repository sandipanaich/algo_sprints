/**
 * HashTable Implementation using Linear Probe.
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
public class LinearProbeHashTable<K, V> implements HashTable<K, V> {

	int size;
	int length;
	private Node<K, V>[] data;
	private static final int DEFAULT_LENGTH = 100;

	public LinearProbeHashTable() {
		this(DEFAULT_LENGTH);
	}

	@SuppressWarnings("unchecked")
	public LinearProbeHashTable(int length) {
		this.size = 0;
		this.length = length;
		this.data = (Node<K, V>[]) new Node[length];
	}

	public V get(K key) {

		if (isEmpty())
			throw new RuntimeException("The HashTable is Empty.");

		int index = hash(key);

		while (data[index] != null) {
			if (data[index].key.equals(key))
				return data[index].value;
		}
		return null;
	}

	public V remove(K key) {

		if (isEmpty())
			throw new RuntimeException("The HashTable is Empty.");

		int index = hash(key);

		while (data[index] != null) {
			if (data[index].key.equals(key)) {
				V element = data[index].value;
				data[index] = null;
				size--;
				return element;
			}
		}
		return null;
	}

	public void put(K key, V value) {

		if (isFull())
			throw new RuntimeException("The HashTable is Full.");

		int index = hash(key);

		while (data[index] != null) {
			if (data[index].key.equals(key)) {
				data[index].value = value;
				return;
			}
			index++;
		}
		data[index] = new Node<>(key, value);
		size++;
	}

	public boolean isFull() {
		return size == length;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void traverse() {
		traverse(System.out::println);
	}

	public void traverse(Consumer<Node<K, V>> consumer) {
		for (Node<K, V> node : data) {
			if (node != null)
				consumer.accept(node);
		}
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

		LinearProbeHashTable<String, Integer> map = new LinearProbeHashTable<String, Integer>();

		for (int i = 0; i < size; i++) {
			map.put(keys[i], values[i]);
		}
		map.traverse();
	}

}

/**
 * HashTable Interface.
 */
package week1.ds.hashtable;

import java.util.function.Consumer;

/**
 * @author Sandipan Aich
 */
public interface HashTable<K, V> {

	V get(K key);

	V remove(K key);

	void put(K key, V value);

	boolean isFull();

	boolean isEmpty();

	int size();

	void traverse();

	void traverse(Consumer<Node<K, V>> consumer);

	static class Node<K, V> {
		K key;
		V value;
		Node<K, V> next;

		public Node(K key, V value) {

			if (key == null)
				throw new RuntimeException("Null keys are not allowed.");

			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + "]";
		}
	}

}

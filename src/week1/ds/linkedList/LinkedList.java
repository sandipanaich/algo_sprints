/**
 * Linked List Implementation.
 * 
 * append O(1)
 * prepend O(1)
 * removeTead O(1)
 * removeTail O(n)
 * traverse O(n)
 */
package week1.ds.linkedList;

/**
 * @author Sandipan Aich
 */
import java.util.Arrays;
import java.util.function.Consumer;

public class LinkedList<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public void append(T element) {

		Node<T> node = new Node<>(element);

		if (isEmpty()) {
			head = node;
			tail = head;
		} else {
			tail.next = node;
			tail = node;
		}
		size++;
	}

	public void prepend(T element) {

		Node<T> node = new Node<>(element);

		if (isEmpty()) {
			head = node;
			tail = head;
		} else {
			node.next = head;
			head = node;
		}
		size++;
	}

	public T removeHead() {
		if (isEmpty())
			throw new RuntimeException("List is empty");

		Node<T> element = head;
		head = head.next;
		if (head == null)
			tail = null;
		size--;
		return element.data;
	}

	public T removeTail() {
		if (isEmpty())
			throw new RuntimeException("List is empty");

		Node<T> element = tail;

		Node<T> node = head;

		if (head.next == null) {
			head = null;
			tail = null;
		} else {
			while (node.next.next != null) {
				node = node.next;
			}
			tail = node;
			tail.next = null;
		}
		size--;
		return element.data;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void print() {
		T[] array = (T[]) new Object[size];
		Node<T> node = head;
		for (int i = 0; node != null; i++) {
			array[i] = node.data;
			node = node.next;
		}
		System.out.println(Arrays.toString(array));
	}

	public void traverse() {
		traverse(System.out::print);
	}

	public void traverse(Consumer<T> consumer) {
		Node<T> node = head;
		
		while (node != null) {
			consumer.accept(node.data);
			node = node.next;
		}
	}

	private static class Node<T> {
		T data;
		Node<T> next;

		Node(T element) {
			this.data = element;
		}
	}

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<Integer>();

		int[] data = new int[] { 0, 1, 2, 9, 2, 8, 3, 7, 4, 6, 5 };
		for (int i : data)
			list.append(i);

		data = new int[] { 10, 11, 12, 19, 12, 18, 13, 17, 14, 16, 15 };
		for (int i : data)
			list.prepend(i);

		for (int i = 0; i < 5; i++)
			list.removeHead();

		for (int i = 0; i < 6; i++)
			list.removeTail();

		list.print();
		list.traverse();
		System.out.println();
	}
}

/**
 * MaxHeap Implementation using arrays.
 * 
 * add O(log(n))
 * remove O(log(n))
 * initialization O(1) or O(n log(n)) // depends upon the Constructor used
 */
package week1.ds.heaps;

/**
 * @author Sandipan Aich
 */
public class MaxHeap<T extends Comparable<T>> {

	private int size;
	private int length;
	private T[] data;

	public MaxHeap(int length) {

		this.data = (T[]) new Comparable[length];
		this.size = 0;
		this.length = length;
	}

	public MaxHeap(T[] array) {
		this.data = array;
		this.size = array.length;
		this.length = array.length;
		heapify();
	}

	public T remove() {

		if (isEmpty())
			throw new RuntimeException("The heap is empty");

		T element = data[0];

		int last = size - 1;
		swap(0, last);
		size -= 1;
		sink(0);

		return element;
	}

	public void add(T element) {

		if (isFull())
			throw new RuntimeException("The heap is full.");

		int position = size;
		size += 1;
		data[position] = element;
		swim(position);
	}

	public boolean isFull() {
		return size == length;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void heapify() {
		int last = size - 1;
		int parent = parent(last);

		for (int i = parent; i >= 0; i--)
			sink(i);
	}

	private void sink(int i) {
		int left = left(i);
		int right = right(i);

		int largest = less(data[left], data[right]) ? right : left;

		if (largest != i && less(data[i], data[largest])) {
			swap(i, largest);
			sink(largest);
		}
	}

	private void swim(int i) {

		if (less(data[parent(i)], data[i])) {
			swap(i, parent(i));
			swim(parent(i));
		}
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

	private int right(int i) {
		int right = 2 * i + 2;
		if (right < size)
			return right;
		return i;
	}

	private int left(int i) {
		int left = 2 * i + 1;
		if (left < size)
			return left;
		return i;
	}

	private void swap(int i, int j) {
		T temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	private boolean less(T one, T two) {
		return one.compareTo(two) < 0;
	}

	public static void main(String[] args) {

		Integer[] data = new Integer[] { 1, 0, 2, 9, 3, 8, 4, 7, 5, 6 };
		MaxHeap<Integer> heap = new MaxHeap<Integer>(data);

		while (!heap.isEmpty())
			System.out.print("_" + heap.remove() + "_");

		System.out.println("\n++++++++++++++++++++++++++++++");

		heap = new MaxHeap<Integer>(10);
		for (int i : data)
			heap.add(i);

		while (!heap.isEmpty())
			System.out.print("_" + heap.remove() + "_");
	}
}

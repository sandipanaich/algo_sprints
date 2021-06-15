/**
 * MaxHeap Implementation using arrays.
 * 
 * add O(log(n))
 * remove O(log(n))
 * initialization O(1) or O(n log(n)) // depends upon the Constructor used
 */
package week2.ds.heaps;

/**
 * @author Sandipan Aich
 */
public class MaxHeap<T extends Comparable<T>> {

	private T[] data;
	private int size;
	private final int length;

	@SuppressWarnings("unchecked")
	public MaxHeap(int size) {
		this.size = 0;
		this.length = size;
		this.data = (T[]) new Comparable[size];
	}

	public MaxHeap(T[] array) {
		this.size = array.length;
		this.length = array.length;
		this.data = array;
		this.heapify();
	}
	
	public void heapify()
	{
		int last = size - 1;
		
		for(int i = parent(last); i >= 0; i--)
			sink(i);
	}

	public T peek()
	{
		if(isEmpty())
			throw new RuntimeException("Heap is empty.");
		
		return data[0];
	}
	
	public T remove() {
		
		T element = peek();

		int last = size - 1;
		data[0] = data[last];

		size--;
		sink(0);
		return element;
	}

	public void add(T element) {
		
		if(isFull())
			throw new RuntimeException("Heap is Full.");

		int position = size;
		size++;
		data[position] = element;

		swim(position);

	}
	
	public boolean isEmpty() {
		
		return size == 0;
	}
	
	public boolean isFull() {
		
		return size == length;
	}

	public int size() {

		return size;
	}

	private void swim(int i) {
		
		int parent = parent(i);

		while (less(data[parent], data[i])) {
			swap(i, parent);
			i = parent;
			parent = parent(i);
		}
	}

	private void sink(int i) {
		int left = left(i);
		int right = right(i);
		int largest = (less(left, right)) ? right : left;

		if (i != largest && less(i, largest)) {
			swap(i, largest);
			sink(largest);
		}
	}

	private void swap(int i, int j) {

		T temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	private boolean less(int one, int two) {
		return less(data[one], data[two]);
	}

	private boolean less(T one, T two) {

		return one.compareTo(two) < 0;
	}

	private int parent(int i) {

		return (i - 1) / 2;
	}

	private int left(int i) {

		int left = 2 * i + 1;
		if (left < size)
			return left;
		return i;
	}

	private int right(int i) {

		int right = 2 * i + 2;
		if (right < size)
			return right;
		return i;
	}

	public static void main(String[] args) {

		Integer[] data = new Integer[] { 1, 0, 2, 9, 3, 8, 4, 7, 5, 6 };
		MaxHeap<Integer> heap = new MaxHeap<Integer>(data);

		while (!heap.isEmpty())
			System.out.print("_" + heap.remove() + "_");

		System.out.println("\n++++++++++++++++++++++++++++++");

		data = new Integer[] { 1, 0, 2, 9, 3, 8, 4, 7, 5, 6 };
		heap = new MaxHeap<Integer>(10);
		for (int i : data)
			heap.add(i);

		while (!heap.isEmpty())
			System.out.print("_" + heap.remove() + "_");
	}
}

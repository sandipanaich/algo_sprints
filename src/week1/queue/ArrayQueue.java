/**
 * Queue Implementation using resizing/dynamic arrays.
 * 
 * peekFirst O(1)
 * peekLast O(1)
 * enqueue O(1)
 * dequeue O(1)
 */
package week1.queue;

/**
 * @author Sandipan Aich
 */
public class ArrayQueue<T> implements Queue<T> {

	private int first;
	private int last;
	private int size;

	private T[] data;

	private int LENGTH;
	public static final int DEFAULT_LENGTH = 5;

	public ArrayQueue() {

		this(DEFAULT_LENGTH);
	}

	public ArrayQueue(int length) {

		this.first = -1;
		this.last = -1;
		this.size = 0;
		this.LENGTH = length;
		this.data = (T[]) new Object[length];
	}

	public boolean isEmpty() {

		return size == 0;
	}

	public boolean isFull() {

		return size == LENGTH;
	}

	public T peekFirst() {

		if (isEmpty())
			throw new RuntimeException("ArrayQueue is Empty.");
		return data[first];
	}

	public T peekLast() {

		if (isEmpty())
			throw new RuntimeException("ArrayQueue is Empty.");
		return data[last];
	}

	public void enqueue(T element) {

		if (isFull()) {
			throw new RuntimeException("Stack is Full.");
		} else if (isEmpty()) {
			first = 0;
			last = 0;
		} else {
			last = (last + 1) % LENGTH;
		}
		data[last] = element;
		size++;

		checkAndResize(true);
	}

	public T dequeue() {
		T element = peekFirst();

		first = (first + 1) % LENGTH;
		size--;
		checkAndResize(false);
		return element;
	}

	private void checkAndResize(boolean added) {

		int newLength = LENGTH;

		if (!added && size < LENGTH / 4 && size > DEFAULT_LENGTH)
			newLength = LENGTH / 2;

		if (added && size > LENGTH / 2)
			newLength = LENGTH * 2;

		if (newLength == LENGTH)
			return;

		T[] temp = (T[]) new Object[newLength];

		int j = 0;
		for (int i = first; i != last; i = (i + 1) % LENGTH, j++)
			temp[j] = data[i];
		temp[j] = data[last];
		
		first = 0;
		last = j;
		LENGTH = newLength;
		data = temp;

	}

	public static void main(String[] args) {
		
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
		
		for(int i = 0; i <= 20; i++)
		{
			queue.enqueue(i);
			System.out.println("i :: " + i + " :: first :: " + queue.peekFirst() + " :: last :: " + queue.peekLast() + " size :: " + queue.size + " :: Length :: " + queue.LENGTH);
		}

		System.out.println("--------------------");
		while(!queue.isEmpty())
		{
			System.out.println("first :: " + queue.peekFirst() + " :: last :: " + queue.peekLast() + " size :: " + queue.size + " :: Length :: " + queue.LENGTH);
			queue.dequeue();
		}

	}

}

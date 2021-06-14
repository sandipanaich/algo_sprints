/**
 * Stack Implementation using resizing/dynamic arrays.
 * peek: O(1)
 * pop: 0(1)
 * push: O(1)
 */
package week2.ds.stack;

/**
 * @author Sandipan Aich
 */
public class Stack<T> {

	private int size;
	private int LENGTH = DEFAULT_SIZE;
	public static final int DEFAULT_SIZE = 5;

	private T[] data;

	@SuppressWarnings("unchecked")
	public Stack() {
		this.size = 0;
		this.data = (T[]) new Object[LENGTH];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		// This should happen only if JVM was not able to allocate extra memory at
		// runtime.
		return size == LENGTH;
	}

	public T peek() {
		if (isEmpty())
			throw new RuntimeException("Stack is empty.");
		int current = size - 1;
		T element = data[current];
		return element;
	}

	public T pop() {

		T element = peek();
		size--;
		checkAndResize(false);
		return element;
	}

	public void push(T element) {
		if (isFull())
			throw new RuntimeException("Stack is full.");

		int position = size;
		size++;
		data[position] = element;
		checkAndResize(true);
	}

	private void checkAndResize(final boolean added) {

		int NEW_LENGTH = LENGTH;

		if (added && size >= LENGTH / 2)
			NEW_LENGTH = LENGTH * 2;

		if (!added && size <= LENGTH / 4 && LENGTH > DEFAULT_SIZE)
			NEW_LENGTH = LENGTH / 2;

		if (NEW_LENGTH == LENGTH)
			return;

		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[NEW_LENGTH];
		System.arraycopy(array, 0, array, 0, size);
		LENGTH = NEW_LENGTH;
		data = array;

	}

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();

		System.out.println("==== PUSH ==============");
		for (int i = 0; i < 20; i++) {
			stack.push(i);
			System.out.println("Data :: " + stack.peek() + " :: size :: " + stack.size() + " :: " + stack.LENGTH);
		}

		System.out.println("==== POP ===============");
		while (!stack.isEmpty()) {
			System.out.println("Data :: " + stack.peek() + " :: size :: " + stack.size() + " :: " + stack.LENGTH);
			stack.pop();
		}
	}

}

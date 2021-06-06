/**
 * Stack Implementation using resizing/dynamic arrays.
 * peek: O(1)
 * pop: 0(1)
 * push: O(1)
 */
package week1.ds.stack;

/**
 * @author Sandipan Aich
 */
public class Stack<T> {

	private int size;
	private int LENGTH = DEFAULT_LENGTH;
	private T[] data;
	public static final int DEFAULT_LENGTH = 5;

	public Stack() {
		this(DEFAULT_LENGTH);
	}

	public Stack(int size) {
		this.size = 0;
		this.LENGTH = size;

		this.data = (T[]) new Object[size];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		// This should not happen.
		return size == LENGTH;
	}

	public T peek() {
		if (isEmpty())
			throw new RuntimeException("Stack is Empty.");

		int current = size - 1;
		return data[current];
	}

	public T pop() {
		T element = peek();
		size--;
		checkAndResize(false);
		return element;
	}

	public int getSize() {
		return size;
	}

	public void push(T element) {
		if (isFull())
			throw new RuntimeException("The Stack is Full.");

		int position = size;
		size++;
		data[position] = element;

		checkAndResize(true);
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
		System.arraycopy(data, 0, temp, 0, size);
		LENGTH = newLength;
		data = temp;
	}

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();

		System.out.println("==== PUSH ==============");
		for (int i = 0; i < 20; i++) {
			stack.push(i);
			System.out.println("Data :: " + stack.peek() + " :: size :: " + stack.getSize() + " :: " + stack.LENGTH);
		}
		
		System.out.println("==== POP ===============");
		while (!stack.isEmpty()) {
			System.out.println("Data :: " + stack.peek() + " :: size :: " + stack.getSize() + " :: " + stack.LENGTH);
			stack.pop();
		}
	}

}

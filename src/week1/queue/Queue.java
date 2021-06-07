/**
 * Queue Interface.
 */
package week1.queue;

/**
 * @author Sandipan Aich
 */
public interface Queue<T> {
	
	public boolean isEmpty();

	public boolean isFull();

	public T peekFirst();

	public T peekLast();

	public void enqueue(T element);

	public T dequeue();
}

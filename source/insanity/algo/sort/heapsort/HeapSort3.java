// In Place, O(Logn), unstable
package insanity.algo.sort.heapsort;

import java.util.Arrays;

public class HeapSort3 {

	public static final <T extends Comparable<T>> T[] sort(T[] array) {

		if (array == null || array.length < 2)
			return array;

		int len = array.length;
		int last = len - 1;
		Heap<T> heap = new Heap<>(array);

		while (last >= 0)
			array[last--] = heap.remove();

		last = array.length - 1;
		for (int i = 0, j = last; i < last / 2; i++, j--)
			swap(array, i, j);

		return array;
	}

	private static final <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static final class Heap<E extends Comparable<E>> {

		private final E[] heap;
		private int len;
		private int size;

		private Heap(E[] array) {
			this.heap = array;
			this.len = array.length;
			this.size = array.length;
			this.heapify();
		}

		private final void heapify() {
			int index = this.len / 2 - 1;
			while (index >= 0) {
				sink(index);
				index--;
			}
		}

		private final void sink(int index) {
			int left = index * 2 + 1;
			int right = index * 2 + 2;

			left = (left < this.len) ? left : index;
			right = (right < this.len) ? right : index;

			int least = less(heap[left], heap[right]) ? left : right;
			least = less(heap[index], heap[least]) ? index : least;

			if (index != least) {
				swap(heap, index, least);
				sink(least);
			}
		}

		private final E remove() {
			if (len == 0)
				return null;
			int last = len - 1;

			E element = heap[0];
			heap[0] = heap[last];
			len -= 1;
			sink(0);
			return element;
		}

		private final boolean less(E one, E two) {
			return one.compareTo(two) < 0;
		}

		private final void swap(E[] array, int i, int j) {
			E temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 3, 4, 7, 8, 9, 6, 5, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 1, 0, 3, 2, 4, 5, 7, 6, 9, 8 })));
	}

}

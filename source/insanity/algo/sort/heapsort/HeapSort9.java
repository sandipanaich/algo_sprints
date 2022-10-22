package insanity.algo.sort.heapsort;

import java.util.Arrays;

public class HeapSort9 {

	public static final <T extends Comparable<T>> T[] sort(T[] array) {

		if (array == null || array.length < 2)
			return array;

		int length = array.length;
		int last = length - 1;

		Heap<T> heap = new Heap<>(array);

		for (int index = 0; index < length; index++)
			array[last - index] = heap.remove();

		for (int index = 0; index < last / 2; index++)
			swap(array, index, last - index);

		return array;
	}

	private static final <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static class Heap<E extends Comparable<E>> {

		private int length;
		private final E[] heap;

		private Heap(E[] array) {
			this.length = array.length;
			this.heap = array;
			heapify();
		}

		private void heapify() {
			int last = length - 1;
			for (int index = last / 2; index >= 0; index--)
				sink(index);
		}

		private final E remove() {
			E element = heap[0];
			int last = this.length - 1;
			swap(heap, 0, last);
			this.length -= 1;
			sink(0);
			return element;
		}

		private void sink(int index) {
			int left = 2 * index + 1;
			int right = 2 * index + 2;

			left = (left < this.length) ? left : index;
			right = (right < this.length) ? right : index;

			int least = less(heap[left], heap[right]) ? left : right;
			least = less(heap[least], heap[index]) ? least : index;

			if (index != least) {
				swap(heap, least, index);
				sink(least);
			}
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

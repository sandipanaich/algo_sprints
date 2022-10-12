package insanity.algo.sort.heapsort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapSort1<T extends Comparable<T>> {

	public final T[] sort(T[] array) {

		MinHeap heap = new MinHeap(array);
		for (int i = 0; i < array.length; i++) {
			array[i] = heap.remove();
		}

		return array;
	}

	private class MinHeap {

		private int size;
		private int len;
		private final T[] heap;

		@SuppressWarnings("unchecked")
		public MinHeap(T[] array) {
			this.len = 0;
			this.size = array.length;
			this.heap = (T[]) Array.newInstance(array[0].getClass(), size);
			for (T element : array)
				add(element);
		}

		private void add(T element) {

			if (len == size)
				return;

			heap[len] = element;
			len += 1;
			swim(len - 1);
		}

		private void swim(int index) {
			int parent = (index - 1) / 2;

			if (parent >= 0 && heap[parent].compareTo(heap[index]) > 0) {
				swap(heap, parent, index);
				swim(parent);
			}
		}

		private T remove() {
			if (len == 0)
				return null;

			T element = heap[0];
			heap[0] = heap[len - 1];
			len--;
			sink(0);
			return element;
		}

		private void sink(int index) {
			int left = 2 * index + 1;
			int right = 2 * index + 2;

			left = (left < len) ? left : index;
			right = (right < len) ? right : index;

			int least = (heap[left].compareTo(heap[right]) < 0) ? left : right;

			if (least != index) {
				swap(heap, least, index);
				sink(least);
			}
		}

		private void swap(T[] array, int i, int j) {
			T temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}

	public static void main(String[] args) {
		HeapSort1<Integer> heapSort = new HeapSort1<>();
		System.out.println(Arrays.toString(heapSort.sort(new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 })));
		System.out.println(Arrays.toString(heapSort.sort(new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(heapSort.sort(new Integer[] { 0, 3, 4, 7, 8, 9, 6, 5, 2, 1 })));
		System.out.println(Arrays.toString(heapSort.sort(new Integer[] { 1, 0, 3, 2, 4, 5, 7, 6, 9, 8 })));
	}

}

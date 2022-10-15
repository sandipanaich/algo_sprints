package insanity.algo.sort.heapsort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapSort2 {

	public static final <T extends Comparable<T>> T[] sort(T[] array) {

		if(array == null || array.length < 2)
			return array;
		
		Heap<T> heap = new Heap<T>(array);
		int size = array.length;
		for (int i = 0; i < size; i++)
			array[i] = heap.remove();
		return array;
	}

	private static class Heap<E extends Comparable<E>> {

		private final int size;
		private int length;
		private E[] heap;

		private Heap(E[] array) {
			this.size = array.length;
			this.heap = (E[]) Array.newInstance(array[0].getClass(), this.size);
			for (E element : array)
				add(element);
		}

		private void add(E element) {
//			if (this.length == this.size)
//				return;
			int index = this.length;
			this.heap[index] = element;
			this.length++;
			swim(index);
		}

		private void swim(int index) {
			if (index <= 0)
				return;

			int parent = (index - 1) / 2;

			if (less(heap[index], heap[parent])) {
				swap(heap, parent, index);
				swim(parent);
			}
		}

		private E remove() {
//			if (this.length == 0)
//				return null;

			E element = this.heap[0];
			int last = this.length - 1;
			swap(this.heap, 0, last);
			this.length--;
			sink(0);
			return element;
		}

		private void sink(int index) {
			int left = 2 * index + 1;
			int right = 2 * index + 2;

			left = (left < this.length) ? left : index;
			right = (right < this.length) ? right : index;

			int least = less(this.heap[left], this.heap[right]) ? left : right;
			least = less(this.heap[least], this.heap[index]) ? least : index;

			if (least != index) {
				swap(this.heap, least, index);
				sink(least);
			}

		}

		private final void swap(E[] array, int i, int j) {
			E temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}

		private final boolean less(E one, E two) {
			return one.compareTo(two) < 0;
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 3, 4, 7, 8, 9, 6, 5, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 1, 0, 3, 2, 4, 5, 7, 6, 9, 8 })));
	}
}

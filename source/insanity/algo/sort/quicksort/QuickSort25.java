package insanity.algo.sort.quicksort;

import java.util.Arrays;

public class QuickSort25 {

	public static final <T extends Comparable<T>> T[] sort(T[] array) {

		if (array == null || array.length < 2)
			return array;

		int length = array.length;
		int last = length - 1;

		return sort(array, 0, last);
	}

	private static final <T extends Comparable<T>> T[] sort(T[] array, int left, int right) {

		if (left < right) {

			int pivot = partition(array, left, right);
			sort(array, left, pivot - 1);
			sort(array, pivot + 1, right);
		}
		return array;
	}

	private static final <T extends Comparable<T>> int partition(T[] array, int left, int right) {

		int pivot = left;
		T element = array[pivot];
		left += 1;

		while (left <= right) {
			if (less(array[left], element))
				left++;
			else if (less(element, array[right]))
				right--;
			else
				swap(array, left, right);
		}
		swap(array, pivot, right);
		return right;
	}

	private static final <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static final <T extends Comparable<T>> boolean less(T one, T two) {
		return one.compareTo(two) < 0;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 3, 4, 7, 8, 9, 6, 5, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 1, 0, 3, 2, 4, 5, 7, 6, 9, 8 })));
	}

}

package insanity.algo.sort.bubblesort;

import java.util.Arrays;

public class BubbleSort30 {

	public static final <T extends Comparable<T>> T[] sort(T[] array) {

		if (array == null || array.length < 2)
			return array;

		int length = array.length;
		int last = length - 1;

		for (int i = last; i > 0; i--) {
			for (int j = 0; j < last; j++) {
				if (less(array[j + 1], array[j]))
					swap(array, j, j + 1);
			}
		}
		return array;
	}

	private static final <T extends Comparable<T>> boolean less(T one, T two) {
		return one.compareTo(two) < 0;
	}

	private static final <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 3, 4, 7, 8, 9, 6, 5, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 1, 0, 3, 2, 4, 5, 7, 6, 9, 8 })));
	}

}

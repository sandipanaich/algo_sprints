package insanity.algo.sort.selectionsort;

import java.util.Arrays;

public class SelectionSort5 {

	public static final <T extends Comparable<T>> T[] sort(T[] array) {

		int len = array.length;
		int last = len - 1;

		for (int i = 0; i < last; i++) {
			int least = i;
			for (int j = i + 1; j < len; j++) {
				if (array[j].compareTo(array[least]) < 0)
					least = j;
			}
			if (i != least)
				swap(array, i, least);
		}

		return array;
	}

	private static <T> void swap(T[] array, int i, int j) {
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

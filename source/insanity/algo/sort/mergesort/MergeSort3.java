package insanity.algo.sort.mergesort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort3 {

	public static final <T extends Comparable<T>> T[] sort(T[] array) {

		if (array == null || array.length <= 1)
			return array;

		int len = array.length;
		int last = len - 1;
		T[] aux = (T[]) Array.newInstance(array[0].getClass(), len);
		return sort(array, aux, 0, last);
	}

	private static final <T extends Comparable<T>> T[] sort(T[] array, T[] aux, int left, int right) {

		if (left < right) {
			int mid = (left + right) / 2;
			sort(array, aux, left, mid);
			sort(array, aux, mid + 1, right);
			merge(array, aux, left, mid, right);
		}
		return array;
	}

	private static final <T extends Comparable<T>> void merge(T[] array, T[] aux, int left, int mid, int right) {

		int index = left;
		int i = left;
		int j = mid + 1;

		while (true) {
			if (i > mid && j > right)
				break;
			else if (i > mid)
				aux[index++] = array[j++];
			else if (j > right)
				aux[index++] = array[i++];
			else {
				if (array[i].compareTo(array[j]) < 0)
					aux[index++] = array[i++];
				else
					aux[index++] = array[j++];
			}
		}

		for (i = left; i <= right; i++)
			array[i] = aux[i];
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sort(new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 0, 3, 4, 7, 8, 9, 6, 5, 2, 1 })));
		System.out.println(Arrays.toString(sort(new Integer[] { 1, 0, 3, 2, 4, 5, 7, 6, 9, 8 })));
	}

}

/**
 * Quicksort Implementation.
 */
package week3.algo.sort;
// INCOMPLETE

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort<T extends Comparable<T>> {

	public static final void sort(int[] array) {

		int start = 0;
		int last = array.length - 1;
		sort(array, start, last);
	}

	private static final void sort(int[] array, int start, int last) {

		if (start < last) {
			int pivot = partition(array, start, last);
			sort(array, start, pivot - 1);
			sort(array, pivot + 1, last);
		}
	}

	private static final int partition1(int[] array, int left, int right) {

		int pivot = left;
		int element = array[left];
		left++;

		while (left <= right) {
			if (array[left] < element)
				left++;
			else if (array[right] > element)
				right--;
			else
				swap(array, left++, right--);
		}
		swap(array, right, pivot);
		return right;
	}

	private static final int partition(int[] array, int left, int right) {

		int pivot = right;
		int element = array[right];
		right--;

		while (left <= right) {
			if (array[left] < element)
				left++;
			else if (array[right] > element)
				right--;
			else
				swap(array, left++, right--);
		}
		swap(array, left, pivot);
		return left;
	}

	private static final void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] data = new int[] { 0, 2, 4, 6, 8, 9, 7, 5, 3, 1 };
//		int[] data = new int[] { 0, 2, 4, 6, 8, 9, 7, 5, 3, 1 };
//		int[] data = new int[] { 9, 1, 3, 4, 7, 6, 5, 2, 0, 8 };
//		int[] data = new int[] { 9, 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] data = new int[] { 9, 1, 2, 3, 8, 7, 4, 6, 5, 0 };		
//		int[] data = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		int[] data = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		partition(data, 0, data.length - 1);
		sort(data);
		System.out.println(Arrays.toString(data));
	}

}

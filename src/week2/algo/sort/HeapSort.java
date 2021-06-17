/**
 * Heap Sort Implementation.
 * Time Complexity: O(log(n))
 * Space Complexity: O(1) // In-place Algorithm
 * Stable: NO
 */
package week2.algo.sort;

import java.util.Arrays;

import week2.ds.heaps.MaxHeap;

/**
 * @author Sandipan Aich
 */
public class HeapSort {

	public static <T extends Comparable<T>> void sort(T[] data) {
		
		int size = data.length;
		MaxHeap<T> heap = new MaxHeap<T>(data);
		
		while(size > 0)
		{
			int last = size - 1;
			data[last] = heap.remove();
			size--;
		}
	}

	public static void main(String[] args) {

		Integer[] data = new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
//		String[] data = new String[] { "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A", };
		sort(data);
		System.out.println(Arrays.toString(data));

	}

}

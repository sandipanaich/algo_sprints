/**
 * Shell Sort Implementation.
 * Time Complexity: O(n^2), but faster than Insertion Sort.
 * Space Complexity: O(1)
 * Stable: NO
 */
package week2.algo.sort;

import java.util.Arrays;

/**
 * @author Sandipan Aich
 */
public class ShellSort {

	public static void main(String[] args) {

		Integer[] data = new Integer[] { 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
//		String[] data = new String[] { "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A", };
//		sort(data);
		System.out.println(Arrays.toString(data));
	}

}

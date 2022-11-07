package insanity.algo.dynamic.programming.day1;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	private static final int lcs(int[] array) {

		if (array == null)
			return 0;

		int length = array.length;
		int[] aux = new int[length];
		for (int index = 0; index < length; index++)
			aux[index] = 1;

		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j])
					aux[i] = Math.max(aux[i], aux[j] + 1);
			}
		}

		int max = aux[0];
		for(int index = 0; index < length; index++)
			max = Math.max(max, aux[index]);
		System.out.println(Arrays.toString(aux));
		return max;
	}

	public static void main(String[] args) {
		int[] array = { 1, 10, 2, 11, 3, 4, 12, 5, 13, 14, 15, 6, 16, 17, 18, 7, 19, 8, 20, 21, 9, 22 };
		System.out.println(lcs(array));
	}

}

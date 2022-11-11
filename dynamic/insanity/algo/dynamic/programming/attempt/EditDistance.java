package insanity.algo.dynamic.programming.attempt;

import static java.lang.Math.min;

import java.util.Arrays;

public class EditDistance {

	public static final int editDistance(String string1, String string2) {

		if (string1 == null && string2 == null)
			return 0;
		if (string1 == null && string2 != null)
			return string2.length();
		if (string1 != null && string2 == null)
			return string1.length();

		char[] str1 = string1.toCharArray();
		char[] str2 = string2.toCharArray();

		int matrix[][] = new int[str1.length][str2.length];
		int val = editDistanceDynamic(str1, str2, 0, 0, matrix);
		
		for(int[] arr: matrix)
			System.out.println(Arrays.toString(arr));
		return val;
	}

	private static final int editDistanceDynamic(char[] str1, char[] str2, int i, int j, int[][] matrix) {

		if (i == str1.length)
			return str2.length - j;

		if (j == str2.length)
			return str1.length - i;

		if (matrix[i][j] != 0)
			return matrix[i][j];

		if (str1[i] == str2[j])
			return matrix[i][j] = editDistanceDynamic(str1, str2, i + 1, j + 1, matrix);
		else
			return matrix[i][j] = 1 + min(editDistanceDynamic(str1, str2, i + 1, j + 1, matrix),
										min(editDistanceDynamic(str1, str2, i, j + 1, matrix),
												editDistanceDynamic(str1, str2, i + 1, j, matrix)));
	}

	private static final int editDistance(char[] str1, char[] str2, int i, int j) {

		if (i == str1.length)
			return str2.length - j;

		if (j == str2.length)
			return str1.length - i;

		if (str1[i] == str2[j])
			return editDistance(str1, str2, i + 1, j + 1);
		else
			return 1 + min(editDistance(str1, str2, i + 1, j + 1),
					min(editDistance(str1, str2, i, j + 1), editDistance(str1, str2, i + 1, j)));
	}

	public static void main(String[] args) {
		System.out.println(editDistance("dorw12", "word21"));
	}
}

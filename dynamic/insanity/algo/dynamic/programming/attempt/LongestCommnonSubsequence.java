package insanity.algo.dynamic.programming.attempt;

public class LongestCommnonSubsequence {

	public static final int lcs(char[] string1, char[] string2) {

		if (string1 == null || string2 == null || string1.length == 0 || string2.length == 0)
			return 0;

		int index1 = string1.length - 1;
		int index2 = string2.length - 1;

		return lcs(string1, index1, string2, index2);

	}

	private static final int lcs(char[] string1, int index1, char[] string2, int index2) {
		if (index1 < 0 || index2 < 0)
			return 0;

		if (string1[index1] == string2[index2])
			return 1 + lcs(string1, index1 - 1, string2, index2 - 1);
		else
			return Math.max(lcs(string1, index1 - 1, string2, index2), lcs(string1, index1, string2, index2 - 1));
	}

	public static void main(String[] args) {
	}

}

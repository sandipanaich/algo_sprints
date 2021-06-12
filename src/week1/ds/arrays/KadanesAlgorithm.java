package arrays;

public class KadanesAlgorithm {

	public static int maxSum(int[] array) {
		int size = array.length;
		int max = array[0];
		int max_current = array[0];

		for (int i = 0; i < size; i++) {
			max_current = Math.max(array[i], max_current + array[i]);
			if (max < max_current)
				max = max_current;
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(maxSum(new int[] { -2, -3, 4, -1, -2, 1, 5, -3 }));
	}

}

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution1423 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution1423().maxScore(new int[] { 1, 2, 3, 4, 5, 6, 1 }, 3));
	}

	public int maxScore1(int[] cardPoints, int k) {
		int len = cardPoints.length;
		if (k == len) {
			return Arrays.stream(cardPoints).sum();
		} else {
			return Math.max(dfsMax(cardPoints, 1, len - 1, k, 1, cardPoints[0]),
					dfsMax(cardPoints, 0, len - 2, k, 1, cardPoints[len - 1]));
		}
	}

	private int dfsMax(int[] cardPoints, int i, int j, int k, int curr, int sum) {
		if (curr == k) {
			return sum;
		}
		return Math.max(dfsMax(cardPoints, i + 1, j, k, curr + 1, sum + cardPoints[i]),
				dfsMax(cardPoints, i, j - 1, k, curr + 1, sum + cardPoints[j]));
	}

	public int maxScore(int[] cardPoints, int k) {
		int len = cardPoints.length;
		if (k == len) {
			return Arrays.stream(cardPoints).sum();
		} else {
			int sum = 0;
			int max = 0;
			for (int i = 0; i < k; i++) {
				sum += cardPoints[i];
			}
			max = sum;
			for (int i = k - 1; i >= 0; i--) {
				sum -= cardPoints[i];
				sum += cardPoints[cardPoints.length - (k - i)];
				max = Math.max(max, sum);
			}
			return max;
		}
	}
}

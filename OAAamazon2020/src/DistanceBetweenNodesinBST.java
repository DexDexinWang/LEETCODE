
public class DistanceBetweenNodesinBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findDistance(new int[] {2,1,3}, 1,3));
	}

	/*
	 * Find Lowest Common Ancestor LCA as root, find target 1 with len LCA as root,
	 * find target 2 with len return len1 + len2
	 */
	public static int findDistance(int[] is, int i, int j) {
		int rootIndex = 0;
		while((is[rootIndex] - i) * (is[rootIndex] - j) > 0) {
			rootIndex =  is[rootIndex] - i > 0 ?  rootIndex * 2 + 1 : rootIndex * 2 + 2;
		}
		return findTargetWithLen(is, rootIndex, i) + findTargetWithLen(is, rootIndex, j); 
		
	}
	public static int findTargetWithLen(int[] is, int index, int target) {
		int res = 0;
		while(is[index] != target) {
			res++;
			index = is[index] > target ? index*2+1 : index *2 + 2;
		}
		return res; 
	}
}

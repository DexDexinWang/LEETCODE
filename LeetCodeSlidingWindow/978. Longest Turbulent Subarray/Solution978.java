
public class Solution978 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Solution978().maxTurbulenceSize(new int[] {100,100,100});
	}
    //SW with flexible ragne to present the maximum sub-array that regards the current node as most right element.
    //SW should be shrinked to main the rule.
    public int maxTurbulenceSize(int[] A) {
        if(A == null || A.length == 0) return 0;
        if(A.length == 1) return 1;
        
        int left = 0;
        int right = 1;
        int max = 1;
        boolean leftIsSmaller = A[0] < A[1];
        while(right < A.length) {
            if(A[right - 1] < A[right] && !leftIsSmaller || A[right - 1] > A[right] && leftIsSmaller){
                left = right - 1;
                leftIsSmaller = A[left] < A[right];
            }
            while(A[right - 1] == A[right]) {
                if(right < A.length - 1) {
                    left = right;
                    right = right + 1;
                    leftIsSmaller = A[left] < A[right];
                } else {
                    left = right;
                    break;
                }
            }
            max = Math.max(max, right - left + 1);
            leftIsSmaller = !leftIsSmaller;
            right++;
        } 
        return max;
    }
}

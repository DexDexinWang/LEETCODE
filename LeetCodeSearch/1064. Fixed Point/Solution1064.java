
public class Solution1064 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {-10,-5,-2,0,4,5,6,7,8,9,10};
		fixedPoint(input);
	}

    //Binary search method with 2 pointers:
    //l - left, all elements in left side of l are smaller than l;
    //r - right, all elements in right side of r are bigger than r; 
    //all elements between l and r are unchecked.
    //use while loop to check mid pointer.
    //If the element is bigger and equal than pointer number, move r poting. Otherwiese, move l pointer.
    public static int fixedPoint(int[] A) {
        //Assumptions: A is not null and length is >= 1
        int i = 0;
        int j = A.length -1;
        while (i < j - 1) {
            int mid = i + (j - i) / 2;
            if (A[mid] >= mid) {
                j = mid; 
            }  else {
                i = mid;
            }
        }
        if (A[i] == i) {
            return i;
        } else if (A[j] == j) {
            return j;
        } else {
            return -1;
        }
    }
}

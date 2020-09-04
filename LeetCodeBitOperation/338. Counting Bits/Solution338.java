
public class Solution338 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution338().countBits1(3));
	}
	
	
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i = 0; i <=num; i++) {
            res[i] = sumOnes(i);
        }
        return res;
    }
    
    public int sumOnes(int n) {
        int res = 0;
        while(n!=0) {
            res++;
            n&=(n-1);
        }
        return res;
    }
    
    public int[] countBits1(int num) {
        int[] res = new int[num+1];
        ;
        if(num >= 1) {
        	res[1] = 1; 
        }
        int limit = 1;
        for(int i = 2; i <=num; i++) {
        	if((i & (i-1)) == 0) {
                limit<<=1;
            }
            res[i] = 1 + res[i - limit];
        }
        return res;
    }
}

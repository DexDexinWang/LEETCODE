public class Solution1100 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution1100().numKLenSubstrNoRepeats("havefunonleetcode", 5));
	}
	//Sliding Window represents the substring that has K length;
    //The range will be shrinked if the sliding window size is k + 1;
    //The result will in the range which has K differnt character 
    public int numKLenSubstrNoRepeats(String S, int K) {
        int[] count = new int[26];
        int left =0; 
        int right = 0;
        int totalChar = 0;
        int res = 0;
        while(right < S.length()) {
            char curr = S.charAt(right);
            count[curr - 'a']++;
            if(count[curr - 'a'] == 1) totalChar ++;
            if(right - left + 1 == K) {
                if(totalChar == K) {
                    res++;
                }
                char leftCurr = S.charAt(left);
                if(count[leftCurr - 'a'] == 1) {
                    totalChar--;
                }
                count[leftCurr - 'a']--;
                left++;
            }
            right++;
        }
        return res;
    }
}

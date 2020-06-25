
public class Solution997 {
	//Directed Graph, find a node that be pointed every other nodes, and point to nobody. count[num[0]]++; count[num[1]--];
	public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
       
         for(int[] num: trust) {
             count[num[1]]++;
             count[num[0]]--;
         }
        for(int i = 1; i < N+1; i++) {
            if(count[i] == N-1) {
                return i;
            }
        }
        return -1;
    }

}

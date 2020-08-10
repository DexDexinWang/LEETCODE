
public class DeletionDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  //dog and frog 
	  //p1 and p2 
	  //define int count
	  //p1 = 0; p2 = 0; not same ==> f becuase frog has the longer length. count++
	  //p1 = 0; p2 = 1; not same ==> d ; count++
	  //p1 = 1; p2 = 1; not same ==> f ; count++
	  //p1 = 1; p2 = 2; same ==> p1 =2 and p2 =3;
	  //===>.... un both p1, p2 traversed all characters in s1 and s2
	  //===> final return will 3.
	  //Time compelxity will be O(m + n) which m, n are lens for s1 and s2.
	  //Space complexity will be O(1);
	  static int deletionDistance(String str1, String str2) {
	    //coner cases
	    int len1 = str1.length();
	    int len2 = str2.length();
	    if(len1 == 0 || len2 == 0 ) {
	      return Math.max(len1, len2);
	    }
	    int p1 = 0;
	    int p2 = 0;
	    int count = 0;
	    while(p1 < len1 && p2 < len2) {
	      if(str1.charAt(p1) != str2.charAt(p2)) {
	          if(len1 - p1 >= len2 - p2) {
	            p1++;
	          } else {
	            p2++;
	          }
	          count++;
	        } else {
	          p1++;
	          p2++;
	        }
	        if(p1==len1) count += len2-p2;
	        if(p2==len2) count += len1-p1;
	    }
	    return count;
	  }
}

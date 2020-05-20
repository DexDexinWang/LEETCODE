
public class BackspaceStringCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackspaceStringCompare test = new BackspaceStringCompare();
		test.backspaceCompare("xywrrmp", "xywrrmu#p");
	}
	
	//Solve the problem with 2 points for each string to move each characters. and compare each non-# character
	//Time complexity is O(n) 
	//Space complexity is O(1) excluding char arrays 
	public boolean backspaceCompare(String S, String T) {
        //corner cases
        if (S == null && T == null) {
            return true;
        } else if (S == null || T == null) {
            return false;
        } else {
            char[] chars1 = processBackspace(S.toCharArray());
            char[] chars2 = processBackspace(T.toCharArray());
            int i = 0;
            while(i < chars1.length && i < chars2.length) {
                if (chars1[i] != chars2[i]) {
                    return false;
                }
                i++;
            }
            if (i < chars1.length) {
                return chars1[i] == '#';
            }
            if (i < chars2.length) {
                return chars2[i] == '#';
            }
            return true;
        }
    }
    
    public char[] processBackspace(char[] chars) {
        if (chars.length == 0) {
            return chars;
        } else {
            int i = 0; 
            int j = 0;
            while (j < chars.length) {
                if(chars[j] != '#') {
                    chars[i++] = chars[j++];
                } else {
                    if (i > 0) {
                        i--;
                    }
                    j++;
                }
            }
            while(i < chars.length) {
                chars[i++] = '#';
            }
            return chars;
        }
    }
    
    //Solve the problem with Stack 
    public boolean backspaceCompare1(String S, String T) {
        //corner cases
        if (S == null && T == null) {
            return true;
        } else if (S == null || T == null) {
            return false;
        } else {
            char[] chars1 = processBackspace1(S.toCharArray());
            char[] chars2 = processBackspace1(T.toCharArray());
            int i = 0;
            while(i < chars1.length && i < chars2.length) {
                if (chars1[i] != chars2[i]) {
                    return false;
                }
                i++;
            }
            if (i < chars1.length) {
                return chars1[i] == '#';
            }
            if (i < chars2.length) {
                return chars2[i] == '#';
            }
            return true;
        }
    }
    
    public char[] processBackspace1(char[] chars) {
        if (chars.length == 0) {
            return chars;
        } else {
            int i = 0; 
            int j = 0;
            while (j < chars.length) {
                if(chars[j] != '#') {
                    chars[i++] = chars[j++];
                } else {
                    if (i > 0) {
                        i--;
                    }
                    j++;
                }
            }
            while(i < chars.length) {
                chars[i++] = '#';
            }
            return chars;
        }
    }
    
}
